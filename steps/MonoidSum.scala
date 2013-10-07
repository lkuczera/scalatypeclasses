
implicit object MonoidSum extends Monoid[Sum] {
  override def mzero = Sum(0)
  override def madd(a: Sum, b: Sum) = Sum(a.value + b.value)
}
