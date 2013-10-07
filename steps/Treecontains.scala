
def contains[T >: A](e: T)(implicit comparator: Comparator[T]): Boolean = this match {
  case EmptyTree => false
  case Node(_, elem, _) if comparator.compare(e,elem) == 0 => true
  case Node(left, elem, right) if comparator.compare(e,elem) < 0 => left.contains(e)
  case Node(left, elem, right) => right.contains(e)
}
