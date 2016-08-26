package io.lglenn.nnproblems

import org.scalatest._

class P15Spec extends NNPSpec {

  markup { """

  P15 (**) Duplicate the elements of a list a given number of times.

  Example:

  scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

  """ }

  val times = 3;
  val raw = List('a, 'b, 'c, 'c, 'd);
  val duped = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd);

  describe("dupeN") {

    it("duplicates each element of a list n times") {
      val result = P15.dupeN(times,raw);
      assert(result == duped, "Expected : " + duped + ", Got: " + result)
    }

    it("returns an empty list when given an empty list") {
      P15.dupeN(times,Nil) should equal (Nil)
    }

  }

}

// vim: set ts=2 sw=2 et:
