package io.lglenn.nnproblems

/*
* P21 (*) Insert an element at a given position into a list.
* Example:
* scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
* res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
*/

object P21 {

    def insertAt[T](obj: T, i: Int, l: List[T]): List[T] = {
        l.take(i) ::: (obj :: l.drop(i + 1))
    }

}

// vim: set ts=4 sw=4 et:
