package io.lglenn.nnproblems

import org.scalatest._

class P04Spec extends NNPSpec {

  describe("size") {

    val l = List('a,'b,'c,'d)

    it("should return the size") {
      P04.size(l) should equal (4)
    }

    it("should be 0 for an empty list") {
      P04.size(List()) should equal (0)
    }

  }

}


// vim: set ts=2 sw=2 et:
