package scalaexercises

import Section3.factorial

// Higher Order Functions
// Functions that take other functions as parameters or
// that return functions as results are called higher order functions.
object Section7 extends App {
  def id(x: Int) = x

  def cube(x: Int) = x * x * x

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  def sumTail(f: Int => Int, a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(x: Int, acc: Int): Int = {
      if (x > b) acc
      else loop(x + 1, acc + f(x))
    }

    loop(a, 0)
  }

  def sumInts(a: Int, b: Int) = sum(id, a, b)

  def sumCubes(a: Int, b: Int) = sum(cube, a, b)

  def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)

  // Anonymous functions
  def sumSquares(a: Int, b: Int) = sum(x => x * x, a, b)

  val intSum = sumInts(2, 4)
  val cubeSum = sumCubes(2, 4)
  val factorialSum = sumFactorials(2, 4)
  println(intSum, cubeSum, factorialSum)

  val squareSum = sumSquares(2, 4)
  println(squareSum)
  println(sumTail(x => x, 1, 10))

}
