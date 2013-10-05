scalatypeclasses
================

Scala type classes workshop

License
=======

See the LICENSE file.

Exercise 1: Comparable
======================

1. Define the `ComparatorInt` instance.
2. Define the `min` method, which should calculate the smallest collection element.
3. Define the `max` method, which should calculate the greatest collection element.
4. Define the `ComparatorString` instance.
5. Define the `ComparatorAbsInt` instance (which compares absolute values).
6. Define the `ComparatorStringIgnoreCase` instance (which ignores the distinction between uppercase and lowercase characters).
7. Add the `+` method to the `Tree` class.
8. Add the `contains` method to the `Tree` class.

Exercise 2: Monoid
==================

1. Define the `MonoidString` instance.
2. Define the `msum` method, which has the following signature:
`def msum[T](list: T*)(implicit m: Monoid[T]): T`
3. Define the `MonoidSum` instance.
4. Define the `MonoidProduct` instance.
5. Define the `MonoidAnything` instancee.
6. Define the `MonoidAll` instance.
7. Define the `MonoidList` instance.
8. Define the `MonoidTuple2` instance.
9. Define the `MonoidMap` instance.

Exercise 3: Functor
===================

1. Define the `FunctorOption` instance.
2. Define the `FunctorList` instance.
3. Define the `FunctorTree` instance.

Exercise 4: Foldable
====================

1. Define the `FoldableList` instance.
2. Define the `FoldableTree` instance.
3. Define the `fold` method, which has the following signature:
`def fold[A:Monoid,F[A]:Foldable](f: F[A]): A`
4. Define the `toList` method converting a foldable into a list.
5. Define the `size` method calculating the foldable size.

Exercise 5: Applic
==================

1. Define the `ApplicId` instance.
2. Define the `ApplicOption` instance.
3. Implement the `map` method.
4. Define the `lift2` method, which has the following signature:
`def lift2[F[_],A,B,C](a: F[A], b: F[B])(g: (A,B) => C)(implicit applic: Applic[F]): F[C]`
5. Define the `lift3` method, which has the following signature:
`def lift3[F[_],A,B,C,D](a: F[A], b: F[B], c: F[C])(g: (A,B,C) => D)(implicit applic: Applic[F]): F[D]`
6. Define the `ApplicList` instance.
7. Define the `ApplicZipList` instance.

Exercise 6: Monad
=================

1. Define the `MonadOption` instance.
2. Implement the `map` method.
3. Implement the `ap` method.
4. Define the `foldM` method, which has the following signature:
`def foldM[M[_],A,B](list: List[A])(v: B)(g: (B,A) => M[B])(implicit m: Monad[M]): M[B]`
5. Define the `MonadList` instance.
6. Define the `join` method, which has the following signature:
`def join[M[_],A,B](mm: M[M[A]])(implicit m: Monad[M]): M[A]`

Exercise 7: Travers
===================

1. Define the `TraversId` instance.
2. Implement the `map` method.
3. Define the `TraversOption` instance.
4. Define the `sequence` method, which has the following signature:
`def sequence[T[_]:Travers,F[_]:Applic,A](t: T[F[A]]): F[T[A]]`
5. Define the `TraversList` instance.
6. Implement the `foldMap` method.
