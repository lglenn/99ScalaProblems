package io.lglenn.nnproblems

import scala.util.Random
import io.lglenn.nnproblems.P23.randomSelect

/*
* P24 (*) Lotto: Draw N different random numbers from the set 1..M.
* Example:
* scala> lotto(6, 49)
* res0: List[Int] = List(23, 1, 17, 33, 21, 37)
*/

object P24 {

    def lotto(n: Int, max: Int): List[Int] = randomSelect(n, List.range(1,max + 1))

}

// vim: set ts=4 sw=4 et:
