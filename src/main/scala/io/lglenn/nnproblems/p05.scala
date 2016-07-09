package io.lglenn.nnproblems

import scala.annotation.tailrec

// p05: reverse a list

object P05 {

    def reverse[T](l: List[T]): List[T] = {
        @tailrec
        def myReverse(l: List[T], acc: List[T]): List[T] = l match {
            case Nil => acc
            case x :: xs => myReverse(xs,x :: acc)
        }
        myReverse(l,Nil)
    }

}

// vim: set ts=4 sw=4 et:
