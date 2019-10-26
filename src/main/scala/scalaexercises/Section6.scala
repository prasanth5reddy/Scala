package scalaexercises

// Structuring information
object Section6 extends App {

  // case class
  case class NoteInMusic(name: String, duration: String, octave: Int)

  // sealed trait
  sealed trait Symbol

  case class Note(name: String, duration: String, octave: Int) extends Symbol

  case class Rest(duration: String) extends Symbol

  // Pattern matching
  def symbolDuration(symbol: Symbol) = {
    symbol match {
      case Note(name, duration, octave) => duration
      case Rest(duration) => duration
    }
  }

  // Exhaustivity
  def unexhaustive(): Unit = {
    sealed trait Symbol
    case class Note(name: String, duration: String, octave: Int) extends Symbol
    case class Rest(duration: String) extends Symbol

    def nonExhaustiveDuration(symbol: Symbol) = {
      symbol match {
        case Note(name, duration, octave) => duration
      }
    }
    // This will give error as this is not implemented as a part of match
    // println(nonExhaustiveDuration(Rest("Half")))
  }

  // Enumeration
  sealed trait NoteName

  case object A extends NoteName

  case object B extends NoteName

  case object C extends NoteName

  case object D extends NoteName

  case object E extends NoteName

  case object F extends NoteName

  case object G extends NoteName

  // Algebraic data types
  sealed trait Duration

  case object Whole extends Duration

  case object Half extends Duration

  case object Quarter extends Duration

  def fractionOfWhole(duration: Duration) = {
    duration match {
      case Whole => 1.0
      case Half => 0.5
      case Quarter => 0.25
    }
  }

  val c3 = NoteInMusic("C", "Quarter", 3)
  println(c3.name, c3.duration, c3.octave)
  val symbol1: Symbol = Note("C", "Quarter", 3)
  val symbol2: Symbol = Rest("Whole")
  // Notice that we can't do anything with Symbols
  println(symbol1, symbol2)
  // Pattern matching allows us to manipulate members
  println(symbolDuration(symbol1), symbolDuration(symbol2))
  // Equals
  val otherC3 = Note("C", "Quarter", 3)
  val anotherC3 = Note("C", "Quarter", 3)
  val f3 = Note("F", "Quarter", 3)
  println(otherC3 == anotherC3, otherC3 == f3)
  // Enumerations
  val d4 = Note(D.toString, "Quarter", 4)
  println(d4)
  // Algebraic data types
  println(fractionOfWhole(Half))
}
