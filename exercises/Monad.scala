
import language.higherKinds
trait Monad[M[_]] extends Applic[M] {
  def flatMap[A,B](m: M[A])(g: A => M[B]): M[B]
  override def map[A,B](functor: M[A])(g: A => B): M[B] = ???
  override def ap[A,B](applic: M[A])(g: M[A => B]): M[B] = ???
}
object Monad {
  def flatMap[M[_]:Monad,A,B](m: M[A])(g: A => M[B]): M[B] =
    implicitly[Monad[M]].flatMap(m)(g)
}
