package org.scala.concepts

//Variables are like values, except you can re-assign them
object Var {

  def main(args: Array[String]): Unit = {
    var x = 1 + 1
    x = 3 // This compiles because "x" is declared with the "var" keyword.
    println(x * x) // 9

  }

}