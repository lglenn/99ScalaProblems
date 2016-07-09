package io.lglenn.nnproblems

// p04: number of elements of list

object P04 {

    def size[T](l: List[T]): Int = l match {
        case Nil => 0
        case x :: xs => 1 + size(xs)
    }

}

// vim: set ts=4 sw=4 et:
