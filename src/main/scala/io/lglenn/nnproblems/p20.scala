package io.lglenn.nnproblems

/*
* P20 (*) Remove the Kth element from a list.
* Return the list and the removed element in a Tuple. Elements are numbered from 0.
* Example:
*
* scala> removeAt(1, List('a, 'b, 'c, 'd))
* res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
*/

object P20 {

    def removeAt[T](i: Int, l: List[T]): (List[T],T) = {
        (l.take(i) ::: l.drop(i + 1),l(i))
    }

}

// vim: set ts=4 sw=4 et:
