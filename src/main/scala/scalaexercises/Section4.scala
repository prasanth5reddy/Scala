package scalaexercises

import Section2.square
import Section3.abs

// Lexical Scopes
object Section4 {
  // Using main method to execute an object file
  def main(args: Array[String]) = {
    def sqrt(x: Double) = {
      // Nested functions
      def sqrtIter(guess: Double, x: Double): Double =
        if (isGoodEnough(guess, x)) guess
        else sqrtIter(improve(guess, x), x)

      def improve(guess: Double, x: Double) =
        (guess + x / guess) / 2

      def isGoodEnough(guess: Double, x: Double) =
        abs(square(guess) - x) < 0.001

      sqrtIter(1, x)
    }

    def sqrtAlt(x: Double) = {
      // Lexical Scoping. Since x is available as parameter, we can remove it in lower definitions
      def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))

      def improve(guess: Double) =
        (guess + x / guess) / 2

      def isGoodEnough(guess: Double) =
        abs(square(guess) - x) < 0.001

      sqrtIter(1)
    }

    def f(y: Int) = y + 1

    println(sqrt(3))
    val x = 1
    val result = {
      // block variables shadows the names of outside variables
      val x = f(3)
      x * x
    } + x
    println(result)
    println(sqrtAlt(4))

    object Foo {
      val k = 1
    }

    object Bar {
      val k = 2
    }

    object Baz {

      import Bar.k

      val y = k + Foo.k
    }
    println(Baz.y)
  }
}
