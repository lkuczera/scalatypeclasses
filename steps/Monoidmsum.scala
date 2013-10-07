
def msum[T](list: T*)(implicit m: Monoid[T]): T =
  list.foldLeft(m.mzero)(m.madd)
