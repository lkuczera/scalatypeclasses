
implicit object ComparatorIntAbs extends Comparator[Int] {
  def compare(x:Int,y:Int) = x.abs - y.abs
}
