
trait Monoid[T] {
  def mzero: T
  def madd(a: T, b: T): T
}
case class Sum(value: Int) extends AnyVal
case class Product(value: Int) extends AnyVal
case class Anything(value: Boolean) extends AnyVal
case class All(value: Boolean) extends AnyVal
