
implicit object MonoidProduct extends Monoid[Product] {
  override def mzero = Product(1)
  override def madd(a: Product, b: Product) = Product(a.value * b.value)
}
