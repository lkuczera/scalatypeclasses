
implicit object MonoidAll extends Monoid[All] {
  override def mzero = All(true)
  override def madd(a: All, b: All) = All(a.value && b.value)
}
