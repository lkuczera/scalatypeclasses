
implicit object ComparatorStringIgnoreCase extends Comparator[String] {
  def compare(x: String, y: String) =
    x.toLowerCase.compareTo(y.toLowerCase)
}
