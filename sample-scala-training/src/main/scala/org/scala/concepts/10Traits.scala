package org.scala.concepts


//Traits are types containing certain fields and methods. Multiple traits can be combined.

//You can define traits with trait keyword.


//Traits are used to share interfaces and fields between classes. 
//They are similar to Java 8’s interfaces. 
//Classes and objects can extend traits but traits cannot be instantiated 
//and therefore have no parameters.

trait GreeterTrait {
  def greet(name: String): Unit
}