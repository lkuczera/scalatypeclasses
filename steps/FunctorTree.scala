
implicit object FunctorTree extends Functor[Tree] {
  override def map[A,B](tree: Tree[A])(g: A => B): Tree[B] =
    tree match {
      case EmptyTree => EmptyTree
      case Node(left, elem, right) => Node(map(left)(g), g(elem), map(right)(g))
    }
}
