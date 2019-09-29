package org.scala.concepts

//You can combine expressions by surrounding them with {}
object Func {

  def main(args: Array[String]): Unit = {

    println({
      val x = 1 + 1
      x + 1
    }) // 3

  }

}