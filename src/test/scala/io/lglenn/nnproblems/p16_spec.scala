package io.lglenn.nnproblems

import org.scalatest._

class P16Spec extends NNPSpec {

  markup { """

  P16 (**) Drop every Nth element from a list.

  Example:

  scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

  """ }

  type A = Symbol
  type Dropper = (Int,List[A]) => List[A]

  def aDropper(func: Dropper): Unit = {

    val n = 3;
    val raw = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k);
    val dropped = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k);

    it("drops every nth element") {
      val result = func(n,raw)
      assert(result == dropped, "Expected: " + dropped + " Got: " + result)
    }

    it("does nothing when n is greater than the size of the list") {
      val result = func(raw.length + 1,raw)
      assert(result == raw, "Expected: " + raw + " Got: " + result)
    }

    it("returns an empty list when given an empty list") {
      assert(func(n,Nil) == Nil)
    }

  }

  describe("drop") {
    it should behave like aDropper(P16.drop[A])
  }

  describe("dropTail") {
    it should behave like aDropper (P16.dropTail[A])
  }

}

// vim: set ts=2 sw=2 et:
