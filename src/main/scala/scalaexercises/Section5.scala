package scalaexercises

// Tail Recursion
object Section5 extends App {
  // In fact, it turns out that if you have a recursive function that calls itself as its last action
  // then you can reuse the stack frame of that function. This is called tail recursion.
  // Tail recursive function can execute in constant stack space, so it is another formulation of an iterative process

  // annotation ensures that method is tail recursive
  @scala.annotation.tailrec
  def gcd(a: Double, b: Double): Double =
    if (b == 0) a else gcd(b, a % b)

  //  This leads to error as it is not tail recursive
  //  @scala.annotation.tailrec
  //  def factorial(n: Int): Int =
  //    if (n == 0) 1 else factorial(n - 1) * n
  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 0) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

  println(factorial(5))
}
