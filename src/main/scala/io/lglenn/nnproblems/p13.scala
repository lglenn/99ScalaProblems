package io.lglenn.nnproblems

import scala.annotation.tailrec

/*
 * P13 (**) Run-length encoding of a list (direct solution).
 * Implement the so-called run-length encoding data compression method directly.
 * I.e. don't use other methods you've written (like P09's pack); do all the work directly.
 * Example:
 * 
 * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
*/

object P13 {

    def rle[T](l: List[T]): List[(Int,T)] = l match {
        case Nil => List[(Int,T)]()
        case x :: _ => {
            val (packed,next) = l.span(_ == x)
            (packed.size, x) :: rle(next)
        }
    }

    def rleTail[T](l: List[T]): List[(Int,T)] = {
        @tailrec def myRle(l: List[T], acc: List[(Int,T)]): List[(Int,T)] = l match {
            case Nil => acc
            case x :: _ => {
                val (packed,next) = l.span(_ == x)
                    myRle(next,(packed.size, x) :: acc)
            }
        }
        myRle(l,Nil).reverse
    }

    def rleFunc[T](l: List[T]): List[(Int,T)] = {
        l.foldRight(List[(Int,T)]()) {
            (e,acc) =>
            if (acc.isEmpty || e != acc.head._2)
                (1,e) :: acc
            else
                ((acc.head._1 + 1, e)) :: acc.tail 
        }
    }

}

// vim: set ts=4 sw=4 et:
