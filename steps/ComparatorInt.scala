
implicit object ComparatorInt extends Comparator[Int] {
  def compare(x:Int,y:Int) = x - y
}
