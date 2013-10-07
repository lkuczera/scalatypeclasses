
implicit def MonoidList[S] = new Monoid[List[S]] {
  override def mzero = Nil
  override def madd(a: List[S], b: List[S]) = a ++ b
}
