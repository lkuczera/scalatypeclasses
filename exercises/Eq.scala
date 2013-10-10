
abstract class Figure {
  def area: Double
  def circum: Double
}
class Square(
  val a: Double
) extends Figure {
  def area = a*a
  def circum = 4*a
}
class Triangle(
  val a: Double,
  val b: Double,
  val c: Double
) extends Figure {
  def area =
    Math.sqrt((a+b+c)*(a+b-c)*
              (a+c-b)*(b+c-a))/4
  def circum = a+b+c
}
trait Eq[T] {
  def isEq(a:T,b:T):Boolean
  def notEq(a:T,b:T) =
    !isEq(a,b)
}
class LowPriorityEq {
  implicit object FigureEqArea extends Eq[Figure] {
    def isEq(a: Figure, b: Figure): Boolean =
      a.area == b.area
  }
}
object Eq extends LowPriorityEq {
  implicit object FigureEq extends Eq[Figure] {
    def isEq(a: Figure, b: Figure): Boolean =
      a.circum == b.circum
  }
  implicit object StringEq extends Eq[String] {
    def isEq(a: String, b: String): Boolean =
      a.length == b.length
  }
  implicit object OptionIntEq extends Eq[Option[Int]] {
    def isEq(a: Option[Int], b: Option[Int]): Boolean =
      (a,b) match {
        case (Some(_),Some(_)) => true
        case (None,None) => true
        case _ => false
      }
  }
  def isEq[T](a:T,b:T)(implicit e: Eq[T]): Boolean =
    e.isEq(a,b)
  def equals3[T](a:T,b:T,c:T)(implicit e: Eq[T]): Boolean =
    e.isEq(a,b) && e.isEq(b,c)
  def notEq[T:Eq](a:T,b:T): Boolean =
    implicitly[Eq[T]].notEq(a,b)
}
