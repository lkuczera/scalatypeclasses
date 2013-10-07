
def max[T : Comparator](a: Seq[T]): T = {
  val comparator = implicitly[Comparator[T]]
  a.reduceLeft{(x,y) => if (comparator.compare(x,y)>0) x else y}
}
