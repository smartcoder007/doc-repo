package org.scala.concepts

/*
In Scala, a tuple is a value that contains a fixed number of elements, 
each with a distinct type. Tuples are immutable.

Tuples are especially handy for returning multiple values from a method.

A tuple with two elements can be created as follows:
* 
* 
*/
object TuppleDed{
  def main(args:Array[String]): Unit= {
    
    //tupple
    val ingredient = ("Sugar" , 25)
    
    // Accessing the elements
    //println(ingredient._1) // Sugar
    //println(ingredient._2) // 25

  }
}

