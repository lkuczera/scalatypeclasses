
trait Comparator[T] {
  def compare(x:T,y:T):Int
}
object Comparator {
  def compare[T:Comparator](x:T,y:T) =
    implicitly[Comparator[T]].compare(x,y)
}
sealed abstract class Tree[+A]
case object EmptyTree extends Tree[Nothing] {
  override def toString = "."
}
final case class Node[A](left: Tree[A], elem: A, right: Tree[A]) extends Tree[A] {
  override def toString = s"($left $elem $right)"
}
