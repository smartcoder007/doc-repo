package org.scala.concepts

//You can combine expressions by surrounding them with {}

object Block {

  def main(args: Array[String]): Unit = {
    
    
   
  }
  
  
  //You can define an anonymous function (i.e. no name) that returns a given integer plus one
  //On the left of => is a list of parameters. 
   //On the right is an expression involving the parameters.


  (x: Int) => x + 1
  
  //You can also named functions
  val addOne = (x: Int) => x + 1

  //Functions may take multiple parameters.
  
  val add = (x: Int, y: Int) => x + y
  println(add(1, 2)) // 3



}