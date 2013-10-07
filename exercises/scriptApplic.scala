
// 1
val id2: Id[Int] = Id(2)
val id5: Id[Int] = Id(5)
val id1_+ : Id[Int => Int] = Id(1+_)
val id_+ : Id[Int => Int => Int] = Id(x => y => x+y)
import Applic._
ap(id2)(id1_+)
ap(id2)(ap(id5)(id_+))
// 2
val a: Option[Int] = Some(5)
val n: Option[Int] = None
val f: Option[Int => Int] = Some(_+1)
val g: Option[Int => Int] = None
ap(a)(f)
ap(a)(g)
ap(n)(f)
// 3
import Functor._
map(a)(_+1)
map(n)(_+1)
// 4
val b: Option[Int] = Some(2)
lift2(a,b)(_+_)
lift2(n,b)(_+_)
// 5
val c: Option[Int] = Some(4)
lift3(a,b,c)(_+_+_)
lift3(a,b,n)(_+_+_)
lift3(a,n,c)(_+_+_)
// 6
val x: List[Int] = List(5,2)
val h: List[Int => Int] = List(_+1,_+2)
val y = List(6,7)
val z = List(8)
val w = List[Int]()
ap(x)(h)
lift2(x,y)(_+_)
lift2(x,w)(_+_)
lift3(x,y,z)(_+_+_)
lift3(x,w,z)(_+_+_)
// 7
val x2 = ZipList(x)
val h2 = ZipList(h)
val y2 = ZipList(y)
val z2 = ZipList(z)
val w2 = ZipList(w)
ap(x2)(h2)
lift2(x2,y2)(_+_)
lift2(x2,w2)(_+_)
lift3(x2,y2,z2)(_+_+_)
lift3(x2,w2,z2)(_+_+_)
