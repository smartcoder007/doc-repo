package org.spark.concepts

import org.apache.spark.sql.SparkSession

//Creating Spark DataFrame from Parquet
object CreateDFFromNways {
  def main(args: Array[String]) {
    
     // Create spark session
    val spark = SparkSession.builder.master("local[*]").getOrCreate();

    
    import spark.implicits._
    
   
    //3. Creating Spark DataFrame from CSV
    val df2 = spark.read.csv("/src/resources/file.csv")   
    
    //4. Creating from text (TXT) file
    val df3 = spark.read.text("/src/resources/file.txt")
    
    //5. Creating from JSON file
    val df4 = spark.read.json("/src/resources/file.json")
    
    //6.  Creating from an XML file
    //To create DataFrame by parse XML, we should use DataSource "com.databricks.spark.xml" spark-xml api from Databricks.
    /*
        <dependency>
         <groupId>com.databricks</groupId>
         <artifactId>spark-xml_2.11</artifactId>
         <version>0.6.0</version>
     </dependency>
		*/    
    //val df5 = spark.read.format("com.databricks.spark.xml").option("rowTag", "person")   .xml("src/main/resources/persons.xml")

    //7. Creating from Hive
    val hiveContext = new org.apache.spark.sql.hive.HiveContext(spark.sparkContext)
    val hiveDF = hiveContext.sql("select * from emp")
    
    //8. Creating from the Database table (RDBMS)
    //8.a) From Mysql table
    //Make sure you have MySQL library as a dependency in your pom.xml file or MySQL jars in your classpath.

      val df_mysql = spark.read.format("jdbc")
         .option("url", "jdbc:mysql://localhost:port/db")
         .option("driver", "com.mysql.jdbc.Driver")
         .option("dbtable", "tablename")
         .option("user", "user")
         .option("password", "password")
         .load()

         
         //8.b) From DB2 table
          //Make sure you have DB2 library as a dependency in your pom.xml file or DB2 jars in your classpath.

        val df_db2 = spark.read.format("jdbc")
           .option("url", "jdbc:db2://localhost:50000/dbname")
           .option("driver", "com.ibm.db2.jcc.DB2Driver")
           .option("dbtable", "tablename")
           .option("user", "user")
           .option("password", "password")
           .load()
           
          //9 Create DataFrame from HBase table
          //To create Spark DataFrame from HBase table, we should use DataSource defined in Spark HBase connectors. for example use DataSource “org.apache.spark.sql.execution.datasources.hbase” from Hortonworks or use “org.apache.hadoop.hbase.spark“from spark HBase connector.

         // val hbaseDF = spark.read.options(Map(HBaseTableCatalog.tableCatalog -> catalog))
         //   .format("org.apache.spark.sql.execution.datasources.hbase")
         //   .load()
          


    

  }
}