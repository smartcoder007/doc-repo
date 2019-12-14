package org.spark.concepts

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import scala.collection.Seq
import scala.reflect.api.materializeTypeTag
//Create Spark DataFrame from RDD
object CreateDF {
   def main(args: Array[String]) {

    // Create spark session
    val spark = SparkSession.builder.master("local[*]").getOrCreate();

    
    import spark.implicits._
    
    //Test Data
    val columns = Seq("language", "users_count")
    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
    
    
    // Create RDD 
    val rdd = spark.sparkContext.parallelize(data);
    
    
    // 1: Using toDF() functions
    val dfFromRDD1 = rdd.toDF()
    dfFromRDD1.printSchema()
    
    //2: Using Spark createDataFrame() from SparkSession
    val dfFromRDD2 = spark.createDataFrame(rdd).toDF(columns:_*)
    dfFromRDD2.printSchema()
    
    
    //3: Using createDataFrame() with the Row type
    //From RDD (USING createDataFrame and Adding schema using StructType)
      val schema = StructType(columns.map(fieldName => StructField(fieldName, StringType, nullable = true)))
      //convert RDD[T] to RDD[Row]
      val rowRDD = rdd.map(attributes => Row(attributes._1, attributes._2))
      val dfFromRDD3 = spark.createDataFrame(rowRDD,schema)
      dfFromRDD3.printSchema();
    
    
    
    
  }
}