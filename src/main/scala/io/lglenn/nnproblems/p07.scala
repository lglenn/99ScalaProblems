package io.lglenn.nnproblems

// p07: flatten a nested list structure

object P07 {

    def flatten(l: List[Any]): List[Any] = l flatMap {
        case xs: List[_] => flatten(xs)
        case x => List(x)
    }

}

// vim: set ts=4 sw=4 et:
