package org.scala.concepts

//Scala has a special type of class called a “case” class. 
//By default, case classes are immutable and compared by value. 
//You can define case classes with the case class keywords.


case class Point(x: Int, y: Int)



//You can instantiate case classes without new keyword
//val point = Point(1, 2)
//val anotherPoint = Point(1, 2)


//And they are compared by value

/*
if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
} // Point(1,2) and Point(1,2) are the same.

*/



