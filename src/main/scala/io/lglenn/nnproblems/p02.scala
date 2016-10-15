package io.lglenn.nnproblems

import scala.annotation.tailrec

object P02 {

  @tailrec
  def penultimate[A](l: List[A]): A = l match {
      case x :: _ :: Nil => x
      case _ :: xs => penultimate(xs)
      case Nil => throw new Exception
  }

}

// vim: set ts=4 sw=4 et:
