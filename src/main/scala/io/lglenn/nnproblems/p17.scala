package io.lglenn.nnproblems

/*
* P17 (*) Split a list into two parts.
* The length of the first part is given. Use a Tuple for your result.
* Example:
*
* scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
* res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
*/

object P17 {

    def split[T](n: Int, l: List[T]): (List[T], List[T]) = (l.take(n), l.drop(n))

}

// vim: set ts=4 sw=4 et:
