package spark


import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object WordCount {
  def main(args: Array[String]) {
    // create Spark context with Spark configuration
   val sc = new SparkContext("local[*]", "SparkWordCount")

       println(sc.sparkUser);
      }

}