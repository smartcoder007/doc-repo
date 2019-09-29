package org.scala.concepts


// objects are singleton

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}


//You can access an object by referring to its name

//val newId: Int = IdFactory.create()
//println(newId)

//val newerId: Int = IdFactory.create()
//println(newerId) // 2
