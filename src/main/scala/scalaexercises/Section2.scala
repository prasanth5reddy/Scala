package scalaexercises

// Definitions and Evaluations
object Section2 extends App {
  def square(x: Double) = x * x

  def area(x: Double) = 3.14159 * square(x)

  def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

  def power(x: Double, y: Int): Double = ???

  def loop: Int = loop

  def triangleArea(base: Double, height: Double) = {
    base * height / 2
  }

  println(square(4))
  println(area(10))
  // println(power(2, 5))
  val x = 2
  val y = square(2)
  println(y)

  def l = loop // Not an infinite loop

  // val il = loop // infinite loop
  println(triangleArea(3, 4), triangleArea(5, 6))

}
