
def +[T >: A](e: T)(implicit comparator: Comparator[T]): Tree[T] = this match {
  case EmptyTree => Node(EmptyTree, e, EmptyTree)
  case Node(left, elem, right) if comparator.compare(e,elem) < 0 => Node(left+e, elem, right)
  case Node(left, elem, right) => Node(left, elem, right+e)
}
