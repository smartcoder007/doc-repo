import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.log4j.Logger
import java.io.File


object SparkWordCount {
  def main(args: Array[String]) {
    // create Spark context with Spark configuration
   // val sc = new SparkContext("local", "SparkWordCount")
    
      val log = Logger.getLogger(this.getClass.getName);
      val inputFile = "C:/test.txt";     
      val outputFile = "C:/test3.txt";
      log.info("inputFile" + inputFile);
      log.info("outputFile"+outputFile)
     // val conf = new SparkConf().setAppName("wordCount")
      // Create a Scala Spark Context.
      val sc = SparkContext.getOrCreate()
      // Load our input data.
      
      val input =  sc.textFile(inputFile)
      // Split up into words.
      val words = input.flatMap(line => line.split(" "))
       log.info("word"+words.collect())
      // Transform into word and count.
      val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
      // Save the word count back out to a text file, causing evaluation.
         log.info("count"+counts.collect())
       
      counts.saveAsTextFile(outputFile)


      }
}

