
// 1
val a: Option[Int] = Some(5)
val n: Option[Int] = None
import Functor._
map(a)(_+1)
map(n)(_+1)
// 2
val x = List(5,2)
map(x)(_*2)
// 3
val b = EmptyTree+5+7+2+1+6
map(b)(_+2)
