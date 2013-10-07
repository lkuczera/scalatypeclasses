
def min[T](a: Seq[T])(implicit comparator: Comparator[T]): T =
   a.reduceLeft{(x,y) => if (comparator.compare(x,y)<0) x else y}
