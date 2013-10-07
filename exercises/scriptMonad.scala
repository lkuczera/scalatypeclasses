
// 1
val a: Option[Int] = Some(5)
val n: Option[Int] = None
val h: Int => Option[Int] = x => Some(x+1)
val k: Int => Option[Int] = _ => None
import Monad._
flatMap(a)(h)
flatMap(a)(k)
flatMap(n)(h)
// 2
import Functor._
map(a)(_+1)
map(n)(_+1)
// 3
val f: Option[Int => Int] = Some(_+1)
val g: Option[Int => Int] = None
import Applic._
ap(a)(f)
ap(a)(g)
ap(n)(f)
// 4
def sumSqrt(list: List[Double]): Option[Double] =
  foldM(list)(0.0)( (sum,x) => if (x>=0) Some(sum+math.sqrt(x)) else None )
sumSqrt(Nil)
sumSqrt(List(1.0))
sumSqrt(List(1.0,4.0))
sumSqrt(List(1.0,4.0,9.0))
sumSqrt(List(1.0,4.0,-1.0,9.0))
// 5
val x = List(4,25)
val j: Int => List[Double] = x => List(math.sqrt(x),-math.sqrt(x))
flatMap(x)(j)
// 6
val y = List(List(1,2),List(4,5))
val z: Option[Option[String]] = Some(Some("abc"))
join(y)
join(z)
