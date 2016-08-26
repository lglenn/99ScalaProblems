package io.lglenn.nnproblems

import org.scalatest._

class P05Spec extends NNPSpec {

  describe("reverse") {

    val l = List('a,'b,'c,'d)

    it("should reverse the list") {
      P05.reverse(l) should equal (List('d,'c,'b,'a))
    }

    it("should be an empty list for an empty list") {
      P05.reverse(List()) should equal (List())
    }

  }

}


// vim: set ts=2 sw=2 et:
