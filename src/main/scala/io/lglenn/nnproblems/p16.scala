package io.lglenn.nnproblems

import scala.annotation.tailrec

/* 
* P16 (**) Drop every Nth element from a list.
* Example:
* scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
* res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
*/

object P16 {

  def drop[T](n: Int, l: List[T]): List[T] = l match {
      case Nil => Nil
      case _ => l.take(n - 1) ::: drop(n,l.drop(n))
  }

  def dropTail[T](n: Int, l: List[T]): List[T] = {
      @tailrec def myDrop(o: Int, l: List[T], acc: List[T]): List[T] = l match {
          case Nil => acc
          case x :: xs => if (o == 1) myDrop(n,xs,acc) else myDrop(o-1,xs,x :: acc)
      }
      myDrop(n,l,Nil).reverse
  }

}

// vim: set ts=4 sw=4 et:
