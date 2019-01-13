package com.kareem.spark

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import java.text.SimpleDateFormat
import java.util.Calendar
import org.apache.log4j.{Level, LogManager, PropertyConfigurator}


object WordCount {
  def main(args: Array[String]) {

    val sc = new SparkContext("local", "SparkWordCount")

    //val log = Logger.getLogger(this.getClass.getName);
    @transient lazy val log = org.apache.log4j.LogManager.getLogger(this.getClass.getName)
    

    val textFile = sc.textFile("C://test.txt")
    println(textFile)
    log.info(textFile)
    val flatMapRDD = textFile.flatMap(line => line.split(" "))  // return Array eg:(Sundari,song,Lyrics)
    log.info("flatMapRDD " + flatMapRDD.collect)
    println("flatMapRDD" + flatMapRDD.collect.toString())
    val mapRDD = flatMapRDD.map(word => (word, 1))
    log.info("mapRDD " + mapRDD.collect) // Array[Tuple] eg:Array((sundari,1),(Song,1))
    println("mapRDD" + mapRDD.collect)
    val countsRDD = mapRDD.reduceByKey(_ + _)  // reduce by key eg:Array((sundari,2),(Song,4))
    log.info("countsRDD " + countsRDD.collect)
    println("countsRDD " + countsRDD.collect.toString()) 
    println(countsRDD.collect.foreach(println))

    countsRDD.saveAsTextFile("C://test_" + getTimeInMill + ".txt")

  }

  def getTime(): java.util.Date = {
    val today = Calendar.getInstance.getTime

    // create the date/time formatters
    val minuteFormat = new SimpleDateFormat("mm")
    val hourFormat = new SimpleDateFormat("hh")
    val amPmFormat = new SimpleDateFormat("a")

    val currentHour = hourFormat.format(today) // 12
    val currentMinute = minuteFormat.format(today) // 29
    val amOrPm = amPmFormat.format(today) // PM
    return today
  }

  def getTimeInMill(): Long = {
    val timeInMillis = System.currentTimeMillis()
    return timeInMillis

  }

}