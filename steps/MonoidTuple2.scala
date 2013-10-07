
implicit def MonoidTuple2[S,T](implicit ms: Monoid[S], mt: Monoid[T]) = new Monoid[(S,T)] {
  override def mzero = (ms.mzero,mt.mzero)
  override def madd(a: (S,T), b: (S,T)) = (ms.madd(a._1, b._1), mt.madd(a._2, b._2))
}
