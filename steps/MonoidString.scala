
implicit object MonoidString extends Monoid[String] {
  override def mzero = ""
  override def madd(a: String, b: String) = a + b
}
