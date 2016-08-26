package io.lglenn.nnproblems

// P11 (*) Modified run-length encoding.
// Modify the result of problem P10 in such a way that if an element has
// no duplicates it is simply copied into the result list. Only elements
// with duplicates are transferred as (N, E) terms.

object P11 {

  import io.lglenn.nnproblems.P10.encode

  def encodeModified[T](l: List[T]): List[Any] = encode(l) map {
      case (1,x) => x
      case y => y
  }
    
}

// vim: set ts=4 sw=4 et:
