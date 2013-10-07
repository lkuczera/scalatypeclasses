
def size[A,F[A]:Foldable](f: F[A]): Int = foldMap(f)(a => Sum(1)).value
