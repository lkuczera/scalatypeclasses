
implicit def MonoidMap[K,V](implicit mv: Monoid[V]) = new Monoid[Map[K,V]] {
  override def mzero = Map.empty[K,V]
  override def madd(a: Map[K,V], b: Map[K,V]) = b.foldLeft(a){ case (map, (k,v)) =>
      if (map contains k) map + ((k, mv.madd(map(k),v))) else map + ((k,v)) }
}
