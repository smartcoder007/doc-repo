package org.scala.concepts

/*
*   1. List
*   2. Seq
*   
*/
object ListTest {
  def main(args: Array[String]): Unit = {

    val salaries = Seq(20000, 70000, 40000)

    val list: List[Any] = List(
      "a string",
      732, // an integer
      'c', // a character
      true, // a boolean value
      () => "an anonymous function returning a string")
      
      println(salaries)
      println(list)
  }

  
}


