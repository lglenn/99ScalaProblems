package io.lglenn.nnproblems

import io.lglenn.nnproblems.P23._

/* 
* P25 (*) Generate a random permutation of the elements of a list.
* Hint: Use the solution of problem P23.
* Example:
*
* scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
* res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
*/

object P25 {

    def randomPermute[T](l: List[T]): List[T] = randomSelect(l.size,l)

    }

// vim: set ts=4 sw=4 et:
