package io.lglenn.nnproblems

import org.scalatest._

class P12Spec extends NNPSpec {

  markup { """

  Decode a run-length encoded list.

  Given a run-length code list generated as specified in problem P10, construct its uncompressed version.

  """ }

  val encoded = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e));
  val raw = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e);

  describe("decode") {
    it("decodes a run-length-encoded list") {
      val result = P12.decode(encoded);
      assert(result == raw, "Expected : " + raw + ", Got: " + result)
    }
    it("returns an empty list when given an empty list") {
      P12.decode(Nil) should equal (Nil)
    }
  }

}

// vim: set ts=2 sw=2 et:
