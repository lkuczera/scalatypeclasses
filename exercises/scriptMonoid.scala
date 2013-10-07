
// 1
import Monoid._
MonoidString.mzero
MonoidString.madd("a","b")
// 2
msum("H","ello"," ","wo","rld","!")
// 3
msum(Sum(2), Sum(5), Sum(4))
// 4
msum(Product(2), Product(5), Product(4))
// 5
msum(Anything(false), Anything(true), Anything(false))
// 6
msum(All(false), All(true), All(false))
// 7
msum(List(2,5), List(7,9,1))
// 8
msum((Sum(2), "Hello"), (Sum(4), " "), (Sum(5), "World"))
// 9
val h = Map( 'en -> ("Hello", Sum(5)), 'pl -> ("Witaj", Sum(5)) )
val s = Map( 'en -> (" ", Sum(1)), 'pl -> (" ", Sum(1)) )
val w = Map( 'en -> ("World", Sum(5)), 'pl -> ("Swiecie", Sum(7)) )
msum(h,s,w)
