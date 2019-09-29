package org.scala.concepts

/*
*   Higher order functions take other functions as parameters or return a function as a result
*
*/
object HigherOrder {
  def main(args: Array[String]): Unit = {

    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
    
    
    
    //To shrink the code, we could make the function anonymous and pass it 
    //directly as an argument to map:


    val salaries2 = Seq(20000, 70000, 40000)
    val newSalaries2 = salaries2.map(x => x * 2) // List(40000, 140000, 80000)

  }

  //for each
}


