package io.lglenn.nnproblems

// P11 (*) Modified run-length encoding.
// Modify the result of problem P10 in such a way that if an element has
// no duplicates it is simply copied into the result list. Only elements
// with duplicates are transferred as (N, E) terms.

object P11 {

  import io.lglenn.nnproblems.P10.rle

  def mrle[T](l: List[T]): List[Any] = rle(l) map {
      case (x,1) => x
      case y => y
  }
    
}

// vim: set ts=4 sw=4 et:
