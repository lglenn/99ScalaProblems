package io.lglenn.nnproblems

import org.scalatest._

class P23Spec extends NNPSpec {

  markup { """

  P23 (**) Extract a given number of randomly selected elements from a list.

  Example:

    scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
    res0: List[Symbol] = List('e, 'd, 'a)

  Hint: Use the solution to problem P20

  """ }

  val raw = List('a, 'b, 'c, 'd, 'f, 'g, 'h);

  def containsAllOf[A](l: List[A], sl: List[A]): Boolean = sl match {
    case Nil => true
    case x :: xs => if(l.contains(x)) containsAllOf(l,xs) else false
  }

  def containsUniqueValues[A](l: List[A]): Boolean = l match {
    case Nil => true
    case x :: xs => if(xs.contains(x)) false else containsUniqueValues(xs)
  }

  describe("randomSelect") {
    val rands = P23.randomSelect(3,raw);
    it("returns a list of the proper length") {
      assert(rands.size == 3)
    }
    it("returns a list composed of elements in the input list") {
      assert(containsAllOf(raw,rands))   
    }
    it("only chooses each value at most once") {
      // The odds of picking 6 unique values from a static list of 6 numbers,
      // 7 times in a row, are about 1 in 4.7 trillion.
      // In other words, if this test passes seven times in a row, you can be
      // pretty sure it's valid.
      val result = (1 to 7) map { _ => containsUniqueValues(P23.randomSelect(raw.size,raw)) } reduce { _ && _ }
      assert(result)
    }
  }

}

// vim: set ts=2 sw=2 et:
