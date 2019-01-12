package com.kareem.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.log4j.Logger
import java.io.File

object WordCount {
  def main(args: Array[String]) {

    val sc = new SparkContext("local", "SparkWordCount")

    val log = Logger.getLogger(this.getClass.getName);

    val textFile = sc.textFile("C://test.txt")
    println(textFile)
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      println(counts)
    counts.saveAsTextFile("C://test2.txt")
  }

}