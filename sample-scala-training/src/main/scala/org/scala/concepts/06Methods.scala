package org.scala.concepts

object Method {

  def main(args: Array[String]): Unit = {

  }

  //Methods look and behave very similar to functions,
  //but there are a few key differences between them.

  //Methods are defined with the def keyword. def is followed by a name,
  //parameter lists, a return type, and a body.

  def add(x: Int, y: Int): Int = x + y
  println(add(1, 2)) // 3

  //Methods can have multi-line expressions as well
  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println(getSquareString(2.5)) // 6.25

}