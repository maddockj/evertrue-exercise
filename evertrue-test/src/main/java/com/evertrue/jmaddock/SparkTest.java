package com.evertrue.jmaddock;

import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.elasticsearch.spark.rdd.api.java.JavaEsSpark;

public class SparkTest
{
	public static void main(String[] args)
	{
		// Initialize the Spark configuration
		SparkConf conf = new SparkConf().setAppName("EverTrue Test");
		// Everything is running locally
		conf.setMaster("local");
		
		// Start Spark
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Read customers from the elasticsearch index
		JavaPairRDD<String, Map<String, Object>> esRDD = JavaEsSpark.esRDD(sc, "customer/external");
		
		// Stop Spark
		sc.stop();
		
		// Display the customer count
		System.out.println(esRDD.count() + " customers");
	}
}
