package io.lglenn.nnproblems

// P09 (**) Pack consecutive duplicates of list elements into sublists.

object P09 {

    def packHO[T](l: List[T])(comparator: (T,T) => Boolean): List[List[T]] = {
        l.foldRight(List[List[T]]()) {
            (elem,acc) => acc match {
                case Nil => List(elem) :: acc
                case x :: xs => if (comparator(elem,x.head)) (elem :: x) :: xs else List(elem) :: acc
            }
        }
    }

    def pack[T](l: List[T]): List[List[T]] = {
        packHO(l) { (a,b) => a == b }
    }

    def packRec[T](l: List[T]): List[List[T]] = l match { 
        case Nil => List[List[T]]()
        case x :: xs => {
            val packed = packRec(xs)
                if (packed.isEmpty || x != packed.head.head) List(x) :: packed else (x :: packed.head) :: packed.tail
        }
    }

    def packSpan[T](l: List[T]): List[List[T]] = {
        if (l.isEmpty) {
            List[List[T]]()
        } else {
            val(packed, next) = l.span { _ == l.head }
            packed :: packSpan(next)
        }
    }

    def packSpanCase[T](l: List[T]): List[List[T]] = l match {
        case Nil => List[List[T]]()
        case x :: _ => {
            val(packed, next) = l.span { _ == x }
            packed :: packSpanCase(next)
        }
    }

}

// vim: set ts=4 sw=4 et:
