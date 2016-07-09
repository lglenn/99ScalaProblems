package io.lglenn.nnproblems

import scala.annotation.tailrec

// P08 (**) Eliminate consecutive duplicates of list elements.

object P08 {

    def dedupe[T](l: List[T]): List[T] = l match {
        case Nil => Nil
        case x :: xs => x :: dedupe(xs.dropWhile(_ == x))
    }

    def dedupeFunc[T](l: List[T]): List[T] = {
        l.foldRight(List[T]()) { (elem,acc) => if (acc.isEmpty || elem != acc.head) elem :: acc else acc }
    }

    def dedupeTail[T](l: List[T]): List[T] = {
        @tailrec
        def myDedupe(l: List[T],acc:List[T]): List[T] = l match {
            case Nil => acc
            case x :: xs => myDedupe(xs, x :: acc.dropWhile(_ == x))
        }
        myDedupe(l,List[T]()).reverse
    }

}

// vim: set ts=4 sw=4 et:
