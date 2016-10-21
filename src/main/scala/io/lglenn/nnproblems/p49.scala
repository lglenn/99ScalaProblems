package io.lglenn.nnproblems

import scala.collection.mutable

object P49 {

  private val grayCodes = mutable.Map(0 -> List(""))

  def gray(n: Int): List[String] = n match {
    case a if a < 0 => throw new IllegalArgumentException("n must be positive")
    case 0 => List("")
    case _ => {
      val g = gray(n - 1);
      (g map { a => s"0$a" }) ::: (g.reverse map { a => s"1$a" })
    }
  }

  def grayMemoized(n: Int): List[String] = {
    if(!grayCodes.contains(n)) n match {
      case a if a < 0 => throw new IllegalArgumentException("n must be positive")
      case _ => {
        val g = grayMemoized(n - 1);
        grayCodes.put(n,(g map { a => s"0$a" }) ::: (g.reverse map { a => s"1$a" }))
      }
    }
    grayCodes(n)
  }

}

// vim: set ts=4 sw=4 et:
