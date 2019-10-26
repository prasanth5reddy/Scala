package scalaexercises

import Section3.sqrt

import scala.util.{Failure, Success, Try}

// Standard library
object Section8 extends App {

  // Homogeneous Lists
  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty = List()

  // Heterogeneous Lists
  val heterogeneousList: List[Any] = List(1, "1", 1)
  println(heterogeneousList)

  // type Lists
  val numbers: List[Int] = List(1, 2, 3, 4)
  val nothing: List[Nothing] = List()
  println(nothing)

  // Constructors of Lists
  val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))
  // easy way
  val firstFourNaturalNumbers = 1 :: 2 :: 3 :: 4 :: Nil
  // method way
  val firstThreeNaturalNumbers = Nil.::(3).::(2).::(1)
  println(firstFourNaturalNumbers, firstThreeNaturalNumbers)

  // Manipulating Lists
  def defineLists(numbers: List[Any]): String = {
    numbers match {
      // Lists of `Int` that starts with `1` and then `2`
      case 1 :: 2 :: xs => "List starting with 1 and 2"
      // A list that contains as only element another list that starts with `2`
      case List(2 :: xs) => "List of lists that starts with 2"
      // Lists of length 1
      case x :: Nil => "List is of length 1"
      // Same as `x :: Nil`
      case List(x) => "List is of length 1"
      // The empty list, same as `Nil`
      case List() => "List is empty"
    }
  }

  println(defineLists(numbers))
  println(defineLists(List(2)).equals(defineLists(List(3))))
  println(defineLists(List()))
  println(defineLists(List(List(2, 3, 4))))

  // Sorting Lists
  def cond: (Int, Int) => Boolean = (x: Int, y: Int) => x < y

  def insert(x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => x :: Nil
      case y :: ys =>
        if (cond(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }
  }

  def insertionSort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
  }

  println("Insertion Sort : " + insertionSort(List(2, 4, 1, 9, 8, 5)))

  // Operations on Lists
  val firstThreeNaturalNumbersPlusOne = firstThreeNaturalNumbers.map(x => x + 1)
  println(firstThreeNaturalNumbersPlusOne)
  val firstEvenNaturalNumber = firstThreeNaturalNumbers.filter(x => x % 2 == 0)
  println(firstEvenNaturalNumber)
  val xs = firstThreeNaturalNumbers.flatMap { x =>
    List(x, 2 * x, 3 * x)
  }
  println(xs)

  // Optional Values
  def sqrtSome(x: Double): Option[Double] = if (x < 0) None else Some(sqrt(x))

  println(sqrtSome(9))
  println(sqrtSome(-1))

  println(Some(1).map(x => x + 1))
  println(None.map((x: Int) => x * 3))
  println(Some(1).filter(x => x % 2 == 0))
  println(Some(3).flatMap(x => Some(x + 1)))

  // Error handling
  def sqrtHandle(x: Double): Try[Double] =
    if (x < 0) Failure(new IllegalArgumentException("x must be positive"))
    else Success(sqrt(x))

  println(sqrtHandle(4))
  println(sqrtHandle(-2))

  // Either
  def sqrtEither(x: Double): Either[String, Double] =
    if (x < 0) Left("x must be positive")
    else Right(sqrt(x))

  println(sqrtEither(4))
  println(sqrtEither(-2))
  // Manipulating either only works on right
  println(Right(1).map((x: Int) => x + 1))
  println(Left("foo").map((x: Int) => x + 1))
  println(Right(1).filterOrElse(x => x % 2 == 0, "Odd value"))

  def triple(x: Int): Int = 3 * x

  // Had to specify right for previous versions of scala as either was unbiased
  def tripleEither(x: Either[String, Int]) = x.right.map(triple)

  println(tripleEither(Right(6)))
  println(tripleEither(Left("not a number")))
}
