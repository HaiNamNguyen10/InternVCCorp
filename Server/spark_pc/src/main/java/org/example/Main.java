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
                .appName("spark_pc")
                .getOrCreate();

        // Create Java SparkContext
        JavaSparkContext jsc = new JavaSparkContext(
                spark.sparkContext());

        Dataset<Row> df = spark.read().parquet("/data/Parquet/PageViewV1/*");

        df.createOrReplaceTempView("table");
        Dataset<Row> newdf = spark.sql("SELECT concat(domain, path) as url, COUNT(*) AS view FROM table GROUP BY domain, path ORDER BY view DESC");


        newdf.show(10, false);

        newdf.printSchema();


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