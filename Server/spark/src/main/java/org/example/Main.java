package org.example;

// Create Java RDD Example
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import javax.xml.crypto.Data;

import static org.apache.spark.sql.functions.col;

public class Main {
    public static void main(String args[]){

        // Create SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("spark_ads")
                .getOrCreate();

        // Create Java SparkContext
        JavaSparkContext jsc = new JavaSparkContext(
                spark.sparkContext());

        Dataset<Row> df = spark.read().parquet("/data/Parquet/AdnLog/*");
        df.printSchema();
        df.createOrReplaceTempView("table");

        Dataset<Row> newdf = spark.sql("SELECT campaignID AS cp, click_or_view, COUNT(*) AS num FROM table GROUP BY campaignID, click_or_view ORDER BY cp");
        newdf.createOrReplaceTempView("table1");

        Dataset<Row> df_view = spark.sql("SELECT cp, num AS view FROM table1 WHERE click_or_view = false");
        Dataset<Row> df_click = spark.sql("select cp, num AS click from table1 WHERE click_or_view = true");

        Dataset<Row> result = df_view.join(df_click, df_view.col("cp").equalTo(df_click.col("cp")));
        result.show(5);

        // Ghi DataFrame vào tệp CSV trên hệ thống tệp cục bộ
//        result.write().option("header", "true")
//                .csv("file:///home/namnh2/output.csv");

        // Stop the SparkSession and JavaSparkContext

        try {
            Thread.sleep(70000); // Giữ SparkSession hoạt động thêm 60 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}