package io.lglenn.nnproblems

/*
* P22 (*) Create a list containing all integers within a given range.
* Example:
* scala> range(4, 9)
* res0: List[Int] = List(4, 5, 6, 7, 8, 9)
*/

object P22 {

    def range(start: Int, finish: Int): List[Int] = {
        List.iterate(start,finish - start + 1) { _ + 1 }
    }

    def rangeBuiltin(start: Int, finish: Int): List[Int] = {
        List.range(start,finish + 1)
    }

    def rangeRec(start: Int, finish: Int): List[Int] = {
        if (start == finish) {
            Nil
        } else if (start == finish - 1) {
            List(finish)
        } else {
            start :: rangeRec(start + 1,finish)
        }
    }

}
// vim: set ts=4 sw=4 et:
