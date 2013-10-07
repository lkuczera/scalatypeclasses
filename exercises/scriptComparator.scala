
// 1
Comparator.compare(1,1)
Comparator.compare(1,0)
Comparator.compare(2,8)
// 2
val numbers = List(3,1,-6,4,2)
Comparator.min(numbers)
// 3
Comparator.max(numbers)
// 4
val strings = List("a","m","Z","b")
Comparator.min(strings)(Comparator.ComparatorString)
Comparator.min(strings)
Comparator.max(strings)
// 5
Comparator.min(numbers)(Comparator.ComparatorIntAbs)
Comparator.max(numbers)(Comparator.ComparatorIntAbs)
import Comparator.ComparatorIntAbs
Comparator.min(numbers)(Comparator.ComparatorIntAbs)
Comparator.max(numbers)(Comparator.ComparatorIntAbs)
// 6
Comparator.min(strings)(Comparator.ComparatorStringIgnoreCase)
Comparator.max(strings)(Comparator.ComparatorStringIgnoreCase)
import Comparator.ComparatorStringIgnoreCase
Comparator.min(strings)
Comparator.max(strings)
// 7
val a: Tree[Int] = EmptyTree
val b: Tree[Int] = Node(EmptyTree, 2, Node(EmptyTree, 5, EmptyTree))
val c = EmptyTree+5+7+2+1+6
// 8
c contains 7
c contains 4
c contains 2
val d = EmptyTree+"m"+"a"+"z"+"Z"
d contains "Z"
d contains "a"
d contains "A"
