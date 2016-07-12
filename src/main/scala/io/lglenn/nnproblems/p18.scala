package io.lglenn.nnproblems

/* 
* P18 (**) Extract a slice from a list.
* Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
* Example:
*
* scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
* res0: List[Symbol] = List('d, 'e, 'f, 'g)
*/

object P18 {

  def slice[T](i: Int, k: Int, l: List[T]): List[T] = {
      l.drop(i).take(k-i)
  }

  def sliceRec[T](i: Int, k: Int, l: List[T]): List[T] = (i,k) match {
      case(0,0) => Nil
      case(0,_) => l.head :: sliceRec(i,k-1,l.tail)
      case _ => sliceRec(i-1,k-1,l.tail)
  }

}

// vim: set ts=4 sw=4 et:
