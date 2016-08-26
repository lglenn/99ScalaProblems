package io.lglenn.nnproblems

import org.scalatest._

class P14Spec extends NNPSpec {

  markup { """

  P14 (*) Duplicate the elements of a list.

  Example:

    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
    res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  """ }

  type A = Symbol

  type Duper = List[A] => List[A]

  def aDuper(func: Duper): Unit = {

    val raw = List('a, 'b, 'c, 'c, 'd)
    val duped = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

    it("duplicates each element of a list") {
      val result = func(raw);
      assert(result == duped, "Expected : " + duped + ", Got: " + result)
    }

    it("returns an empty list when given an empty list") {
      func(Nil) should equal (Nil)
    }

  }

  describe("dupe") {
    it should behave like aDuper(P14.dupe[A])
  }

  describe("tailRecDupe") {
    it should behave like aDuper(P14.tailRecDupe[A])
  }

}

// vim: set ts=2 sw=2 et:
