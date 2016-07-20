package io.lglenn.nnproblems

import scala.util.Random
import io.lglenn.nnproblems.P20.removeAt

/* P23 (**) Extract a given number of randomly selected elements from a list.
* Example:
* scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
* res0: List[Symbol] = List('e, 'd, 'a)
* Hint: Use the solution to problem P20
*/

object P23 {

    def randomSelect[T](n: Int, l: List[T]): List[T] = {
        def mySelect(n: Int, l: List[T],rand: Random): List[T] = {
            if (n == 0)
                Nil
            else {
                val (xs,x) = removeAt(rand.nextInt(l.size),l)
                    x :: randomSelect(n-1,xs)
            }
        }
        mySelect(n,l,new Random)
    }

}

// vim: set ts=4 sw=4 et:
