package org.spark.concepts

import org.apache.spark.sql.SparkSession

//Create Spark DataFrame from List
object CreateDFUsingList {
   def main(args: Array[String]) {

    // Create spark session
    val spark = SparkSession.builder.master("local[*]").getOrCreate();

    
    import spark.implicits._
    
    //Test Data
   // val columns = Seq("language", "users_count")
   // val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
    val data: List[String] = List("test1","test2","test32");

    
    // Create RDD 
    //val rdd = spark.sparkContext.parallelize(data);
    
    
    // 1: Using toDF() functions
    val dfFromRDD1 = data.toDF()
    dfFromRDD1.printSchema()
    
    
    
    
    
  }
}