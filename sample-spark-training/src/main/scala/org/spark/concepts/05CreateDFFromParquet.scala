package org.spark.concepts

import org.apache.spark.sql.SparkSession

//Creating Spark DataFrame from CSV

/****Apache Arvo Advantages *****/
/*
Reduces IO operations.
Fetches specific columns that you need to access.
It consumes less space.
Support type-specific encoding.
*/

object  CreateDFFromParquet {
   def main(args: Array[String]) {

   // Create spark session
    val spark = SparkSession.builder.master("local[*]").getOrCreate();

    val data = Seq(
      ("James ", "", "Smith", "36636", "M", 3000),
      ("Michael ", "Rose", "", "40288", "M", 4000),
      ("Robert ", "", "Williams", "42114", "M", 4000),
      ("Maria ", "Anne", "Jones", "39192", "F", 4000),
      ("Jen", "Mary", "Brown", "", "F", -1))

    val columns = Seq("firstname", "middlename", "lastname", "dob", "gender", "salary")
    import spark.sqlContext.implicits._
    val df = data.toDF(columns: _*)
    
    //Spark Write DataFrame to Parquet file format
    df.write.parquet("/tmp/output/people.parquet")
    
    //Spark Read Parquet file into DataFrame
    val parqDF = spark.read.parquet("/tmp/output/people.parquet")
    
    //Append to existing Parquet file
    df.write.mode("append").parquet("/tmp/output/people.parquet")
    
    
    //Using SQL queries on Parquet
    parqDF.createOrReplaceTempView("ParquetTable")
    val parkSQL = spark.sql("select * from ParquetTable where salary >= 4000 ")
    
    //Spark parquet partition – Improving performance    
    df.write.partitionBy("gender","salary").parquet("/tmp/output/people2.parquet")
    
    
    //The execution of this query is significantly faster than the query without partition
    val parqDF2 = spark.read.parquet("/tmp/output/people2.parquet")
    parqDF2.createOrReplaceTempView("Table2")
    val df2 = spark.sql("select * from Table2  where gender='M' and salary >= 4000")
    
    //Spark Read a specific Parquet partition
    val parqDF3 = spark.read.parquet("/tmp/output/people2.parquet/gender=M")
    
           
            

  }
}