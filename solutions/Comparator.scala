
trait Comparator[T] {
  def compare(x:T,y:T):Int
}
class LowPriorityComparator {
  implicit object ComparatorIntAbs extends Comparator[Int] {
    def compare(x:Int,y:Int) = x.abs - y.abs
  }
  implicit object ComparatorStringIgnoreCase extends Comparator[String] {
    def compare(x: String, y: String) =
      x.toLowerCase.compareTo(y.toLowerCase)
  }
}
object Comparator extends LowPriorityComparator {
  def compare[T:Comparator](x:T,y:T) =
    implicitly[Comparator[T]].compare(x,y)
  implicit object ComparatorInt extends Comparator[Int] {
    def compare(x:Int,y:Int) = x - y
  }
  implicit object ComparatorString extends Comparator[String] { 
    def compare(x:String,y:String) = x.compareTo(y)
  }
  
  def min[T](a: Seq[T])(implicit comparator: Comparator[T]): T =
     a.reduceLeft{(x,y) => if (comparator.compare(x,y)<0) x else y}
  def max[T : Comparator](a: Seq[T]): T = {
    val comparator = implicitly[Comparator[T]]
    a.reduceLeft{(x,y) => if (comparator.compare(x,y)>0) x else y}
  }
}
sealed abstract class Tree[+A] {
  def +[T >: A](e: T)(implicit comparator: Comparator[T]): Tree[T] = this match {
    case EmptyTree => Node(EmptyTree, e, EmptyTree)
    case Node(left, elem, right) if comparator.compare(e,elem) < 0 => Node(left+e, elem, right)
    case Node(left, elem, right) => Node(left, elem, right+e)
  }
  def contains[T >: A](e: T)(implicit comparator: Comparator[T]): Boolean = this match {
    case EmptyTree => false
    case Node(_, elem, _) if comparator.compare(e,elem) == 0 => true
    case Node(left, elem, right) if comparator.compare(e,elem) < 0 => left.contains(e)
    case Node(left, elem, right) => right.contains(e)
  }
}
case object EmptyTree extends Tree[Nothing] {
  override def toString = "."
}
final case class Node[A](left: Tree[A], elem: A, right: Tree[A]) extends Tree[A] {
  override def toString = s"($left $elem $right)"
}
