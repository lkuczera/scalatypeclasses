
implicit object FoldableList extends Foldable[List] {
  override def foldMap[A,B](fa: List[A])(g: A => B)(implicit m: Monoid[B]): B =
    fa.foldLeft(m.mzero)( (b,a) => m.madd(b,g(a)) )
}
