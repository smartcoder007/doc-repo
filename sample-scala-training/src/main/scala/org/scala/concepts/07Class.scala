package org.scala.concepts


//You can define classes with the class keyword followed by its name and constructor parameters.

//The return type of the method greet is Unit, which says there’s nothing meaningful to return. 
//It’s used similarly to void in Java and C



class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}



//You can make an instance of a class with the new keyword.

//val greeter = new Greeter("Hello, ", "!")
//greeter.greet("Scala developer") // Hello, Scala developer!
