package io.lglenn.nnproblems

import scala.annotation.tailrec

// P14 (*) Duplicate the elements of a list.

object P14 {

    def dupe[T](l: List[T]): List[T] = l match {
        case Nil => Nil
        case x :: xs => x :: x :: dupe(xs)
    }

    def tailRecDupe[T](l: List[T]): List[T] = {
        @tailrec
        def myDupe(l: List[T], acc: List[T]): List[T] = l match {
            case Nil => acc.reverse
            case x :: xs => myDupe(xs, x :: x :: acc)
        }
        myDupe(l,Nil)
    }

}

// vim: set ts=4 sw=4 et:
