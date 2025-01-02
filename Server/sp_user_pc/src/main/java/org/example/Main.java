package org.example;

// Create Java RDD Example
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import static org.apache.spark.sql.functions.col;

public class Main {
    public static void main(String args[]){

        // Create SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("spark_user")
                .getOrCreate();

        // Create Java SparkContext
        JavaSparkContext jsc = new JavaSparkContext(
                spark.sparkContext());

        jsc.setLogLevel("WARN");

        Dataset<Row> df = spark.read().parquet("/data/Parquet/PageViewV1/*");
        Dataset<Row> df1 = spark.read().parquet("/data/Parquet/PageViewMobile/*");

        df.createOrReplaceTempView("table");
        df1.createOrReplaceTempView("table1");

        Dataset<Row> df_pc = spark.sql("select concat(domain, path) as url, guid from table group by domain, path, guid");
        Dataset<Row> df_mb = spark.sql("select concat(domain,path) as url, guid from table1 group by domain, path, guid");

        df_pc.createOrReplaceTempView("t");
        df_mb.createOrReplaceTempView("t1");

        spark.sql("select url, count(*) as number_user from t group by url order by number_user desc").show(10, false);
        spark.sql("select url, count(*) as number_user from t1 group by url order by number_user desc").show(10, false);



        // Stop the SparkSession and JavaSparkContext
//        spark.stop();
//        jsc.stop();
//        try {
//            Thread.sleep(70000); // Giữ SparkSession hoạt động thêm 60 giây
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}