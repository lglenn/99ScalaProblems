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

  def encodeDirect[A](l: List[A]): List[(Int,A)] = l match {
    case Nil => List[(Int,A)]()
    case x :: _ => {
      val (packed,next) = l.span(_ == x)
        (packed.size, x) :: encodeDirect(next)
    }
  }

  def encodeDirectTail[A](l: List[A]): List[(Int,A)] = {
    @tailrec def myEncodeDirectTail(l: List[A], acc: List[(Int,A)]): List[(Int,A)] = l match {
      case Nil => acc
      case x :: _ => {
        val (packed,next) = l.span(_ == x)
          myEncodeDirectTail(next,(packed.size, x) :: acc)
      }
    }
    myEncodeDirectTail(l,Nil).reverse
  }

  def encodeDirectFunc[A](l: List[A]): List[(Int,A)] = l.foldRight(List[(Int,A)]()) {
    case (e, ((count,value) :: xs)) if e == value => (count + 1, e) :: xs
    case (e,acc) => (1,e) :: acc
  }

  def encodeDirectCompact[A](l: List[A]): List[Any] = encodeDirectFunc(l) map {
    case (1,a) => a
    case a => a
  }

}

// vim: set ts=2 sw=2 et:
