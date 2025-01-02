package org.example;

// Create Java RDD Example
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import static org.apache.spark.sql.functions.*;

public class Main {
    public static void main(String args[]){

        // Create SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("spark_ads")
                .getOrCreate();

        // Create Java SparkContext
        JavaSparkContext jsc = new JavaSparkContext(
                spark.sparkContext());

        WindowSpec windowSpec = Window
                .partitionBy("campaignId", "guid") // Chia nhóm theo campaignId và guid
                .orderBy("time"); // Sắp xếp theo time

        Dataset<Row> df = spark.read().parquet("/data/Parquet/AdnLog/*");
        df.printSchema();
        df.createOrReplaceTempView("table");

        Dataset<Row> df1 = spark.sql("select campaignId, guid, click_or_view, time_group.time_create as time from table group by campaignId, guid, click_or_view, time_group.time_create ");
        df1.createOrReplaceTempView("t1");

        //loc ra nhung user phat sinh click
        Dataset<Row> df2 = spark.sql("select campaignId, guid from table group by campaignId, guid having count(distinct click_or_view) > 1");
        df2.createOrReplaceTempView("t2");

        //nhom data theo campaignId, guid, sap xep moi nhom theo time
        //voi moi nhom campaignId, guid, tao cot stt row_number de tinh toan so view truoc khi phat sinh click
        Dataset<Row> df3 = spark.sql("select t1.campaignId , t1.guid, t1.click_or_view, t1.time as time from t1 join t2 on t1.campaignId = t2.campaignId and t1.guid = t2.guid").withColumn("row_number", functions.row_number().over(windowSpec));

        //loc ra nhung hang co gia tri true de tinh
        Dataset<Row> df4 = df3.filter(col("click_or_view").equalTo(true)).withColumn("num_view", col("row_number").minus(1) ).drop(col("row_number"));
        df4.createOrReplaceTempView("t4");

        Dataset<Row> df5 = spark.sql("select num_view from t4");
        df5.show(50, false);

        df5.coalesce(1).write().mode("overwrite").csv("/user/namnh2/output.csv");


        // Ghi DataFrame vào tệp CSV trên hệ thống tệp cục bộ


        // Stop the SparkSession and JavaSparkContext

        try {
            Thread.sleep(70000); // Giữ SparkSession hoạt động thêm 60 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}