package io.lglenn.nnproblems

import org.scalatest._

class P07Spec extends NNPSpec {

  describe("flatten") {

    val nested = List('a,'b,'c,List('d,'e),'f,'g)
    val nested_flat = List('a,'b,'c,'d,'e,'f,'g)
    val flat = List('a,'b,'c,'d)

    it("flattens a nested list") {
      P07.flatten(nested) should equal (nested_flat)
    }

    it("leaves a flat list untouched") {
      P07.flatten(flat) should equal (flat)
    }

    it("returns an empty list when given an empty list") {
      P07.flatten(Nil) should equal (Nil)
    }

  }

}


// vim: set ts=2 sw=2 et:
