
trait Monoid[T] {
  def mzero: T
  def madd(a: T, b: T): T
}
case class Sum(value: Int) extends AnyVal
case class Product(value: Int) extends AnyVal
case class Anything(value: Boolean) extends AnyVal
case class All(value: Boolean) extends AnyVal
object Monoid {
  implicit object MonoidString extends Monoid[String] {
    override def mzero = ""
    override def madd(a: String, b: String) = a + b
  }
  implicit object MonoidSum extends Monoid[Sum] {
    override def mzero = Sum(0)
    override def madd(a: Sum, b: Sum) = Sum(a.value + b.value)
  }
  implicit object MonoidProduct extends Monoid[Product] {
    override def mzero = Product(1)
    override def madd(a: Product, b: Product) = Product(a.value * b.value)
  }
  implicit object MonoidAnything extends Monoid[Anything] {
    override def mzero = Anything(false)
    override def madd(a: Anything, b: Anything) = Anything(a.value || b.value)
  }
  implicit object MonoidAll extends Monoid[All] {
    override def mzero = All(true)
    override def madd(a: All, b: All) = All(a.value && b.value)
  }
  implicit def MonoidList[S] = new Monoid[List[S]] {
    override def mzero = Nil
    override def madd(a: List[S], b: List[S]) = a ++ b
  }
  implicit def MonoidTuple2[S,T](implicit ms: Monoid[S], mt: Monoid[T]) = new Monoid[(S,T)] {
    override def mzero = (ms.mzero,mt.mzero)
    override def madd(a: (S,T), b: (S,T)) = (ms.madd(a._1, b._1), mt.madd(a._2, b._2))
  }
  implicit def MonoidMap[K,V](implicit mv: Monoid[V]) = new Monoid[Map[K,V]] {
    override def mzero = Map.empty[K,V]
    override def madd(a: Map[K,V], b: Map[K,V]) = b.foldLeft(a){ case (map, (k,v)) =>
        if (map contains k) map + ((k, mv.madd(map(k),v))) else map + ((k,v)) }
  }
  def msum[T](list: T*)(implicit m: Monoid[T]): T =
    list.foldLeft(m.mzero)(m.madd)
}
