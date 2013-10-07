
implicit object ComparatorString extends Comparator[String] { 
  def compare(x:String,y:String) = x.compareTo(y)
}
