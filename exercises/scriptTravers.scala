
// 1
import Travers._
val a = Id(2)
val f: Int => Option[Int] = x => Some(x*x)
val af = traverse(a)(f)
// 2
import Functor._
map(a)(_+5)
map(a)(f)
// 3
val b: Option[Int] = Some(5)
val g: Int => Id[Int] = x => Id(x+x)
val bg = traverse(b)(g)
// 4
sequence(af)
sequence(bg)
// 5
val c: List[Option[Int]] = List(Some(1), Some(5))
val d: List[Option[Int]] = List(Some(1), None, Some(7))
val c1 = sequence(c)
sequence(c1)
val d1 = sequence(d)
sequence(d1)
// 6
val t: Tree[Int] = EmptyTree+8+7+11+12
traverse(t)(f)
val u: Tree[List[Int]] = Node(EmptyTree, List(2,3), Node(EmptyTree, List(5,6), EmptyTree))
sequence(u)
// 7
import Foldable._
val r = EmptyTree+5+7+2+1+6
foldMap(r)(x => All(x > 2))
foldMap(r)(x => All(x >= 1))
foldMap(r)(x => Anything(x == 5))
foldMap(r)(x => Sum(x))
foldMap(r)(_.toString)
toList(r)
