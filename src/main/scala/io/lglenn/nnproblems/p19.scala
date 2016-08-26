package io.lglenn.nnproblems

/* 
* P19 (**) Rotate a list N places to the left.
* Examples:
* scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
* res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
*
* scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
* res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
*/

object P19 {

  def rotate[T](n: Int, l: List[T]): List[T] = l match {
    case Nil => Nil
    case _ => {
      val places = (n + l.size) % l.size
      l.drop(places) ::: l.take(places)
    }
  }

}

// vim: set ts=2 sw=2 et:
