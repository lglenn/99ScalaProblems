package io.lglenn.nnproblems

import org.scalatest._

class P11Spec extends NNPSpec {

  markup { """

  Modified run-length encoding.

  Modify the result of problem P10 in such a way that if an element has
  no duplicates it is simply copied into the result list. Only elements
  with duplicates are transferred as (N, E) terms.

  """ }

  val raw = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e);
  val encoded = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e));

  describe("encodeModified") {
    it("run-length encodes a list") {
      val result = P11.encodeModified(raw);
      assert(result == encoded, "Expected : " + encoded + ", Got: " + result)
    }
    it("returns an empty list when given an empty list") {
      P11.encodeModified(Nil) should equal (Nil)
    }
  }

}

// vim: set ts=2 sw=2 et:
