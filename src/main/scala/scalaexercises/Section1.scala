package scalaexercises

// Terms And Types
object Section1 extends App {
  println(1 + 2)
  val hello = "Hello, " ++ "Scala!"
  println(hello)
  println(hello.size, hello.length)
  println(hello.toUpperCase())
  println(-42.abs)
  println(16.toHexString)
  println((0 until 10).contains(10))
  println("foo".drop(1))
  println("bar".take(2))
}