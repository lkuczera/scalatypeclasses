
// 1
import Foldable._
val p = List(2,7,5,4)
foldMap(p)(x => All(x > 2))
foldMap(p)(x => All(x >= 1))
foldMap(p)(x => Anything(x == 5))
foldMap(p)(x => Sum(x))
foldMap(p)(_.toString)
// 2
val r = EmptyTree+5+7+2+1+6
foldMap(r)(x => All(x > 2))
foldMap(r)(x => All(x >= 1))
foldMap(r)(x => Anything(x == 5))
foldMap(r)(x => Sum(x))
foldMap(r)(_.toString)
// 3
val q = List(Sum(2),Sum(7),Sum(5),Sum(4))
fold(q)
// 4
toList(r)
// 5
size(p)
size(r)
