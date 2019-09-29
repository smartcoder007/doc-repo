package org.scala.concepts

//Named results, such as x here, are called values. Referencing a value does not re-compute it.

//Values cannot be re-assigned.

object Val {

  def main(args: Array[String]): Unit = {
    val x = 1 + 1
    println(x) // 2
    // x=3  // cann' assign
    
    
    val y: Int = 1 + 1

  }

}