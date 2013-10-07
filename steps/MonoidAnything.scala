
implicit object MonoidAnything extends Monoid[Anything] {
  override def mzero = Anything(false)
  override def madd(a: Anything, b: Anything) = Anything(a.value || b.value)
}
