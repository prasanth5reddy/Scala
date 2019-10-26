package scalaexercises

import Section2.square

// Functional loops
object Section3 extends App {
  def abs(x: Double) = if (x >= 0) x else -x

  def isGoodEnough(guess: Double, x: Double) =
    abs(square(guess) - x) < 0.001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def sqrtIter(guess: Double, x: Double): Double =
  // finding square root using newton's method
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def sqrt(x: Double): Double = sqrtIter(1, x)

  def factorial(n: Int): Int =
    if (n == 1 || n == 0) 1
    else factorial(n - 1) * n

  println(abs(-10), abs(10))
  println(sqrt(2))
  println(factorial(3), factorial(6))
}
