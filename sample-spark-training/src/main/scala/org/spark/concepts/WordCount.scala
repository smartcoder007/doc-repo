

package org.spark.concepts

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession;

object WordCount {
  def main(args: Array[String]) {

    val spark = SparkSession.builder.master("local[*]").getOrCreate();

    val sc = spark.sparkContext

    val textFile = sc.textFile("file:///C:/test.txt")
    val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)) .reduceByKey(_ + _)
    counts.saveAsTextFile("file:///C:/test-out.txt")

  }
}