package io.lglenn.nnproblems

import scala.annotation.tailrec

object P01 {

    def lastDirect[A](l: List[A]): A = l.last

    @tailrec
    def lastRecursive[A](l: List[A]): A = l match {
        case x :: Nil => x
        case _ :: xs => lastRecursive(xs)
        case Nil => throw new Exception
    }

}

// vim: set ts=4 sw=4 et:
