package org.spark.concepts

import org.apache.spark.sql.types.{ ArrayType, StringType, StructType }
import org.apache.spark.sql.{ Row, SparkSession }

object SimpleFor extends App {

  val spark = SparkSession.builder().appName("ArrayToColumn")
    .master("local[1]")
    .getOrCreate()

  val words = Array("first", "second", "third", "fourth")
  var listArray = List[String]()

  for (i <- 0 until words.length) {
    val temp = words(i)
    listArray :+= temp
  }

  listArray.toStream.print()

}