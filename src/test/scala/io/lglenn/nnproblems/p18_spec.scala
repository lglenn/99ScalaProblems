package io.lglenn.nnproblems

import org.scalatest._

class P18Spec extends NNPSpec {

  markup { """

  P18 (**) Extract a slice from a list.

  Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.

  Example:

    scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res0: List[Symbol] = List('d, 'e, 'f, 'g)

  """ }

  val n = 3
  val raw = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k);
  val split = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k));

  describe("split") {
    it("splits a list in two at n") {
      val result = P17.split(n,raw);
      assert(result == split,"Expected: " + split + " Got: " + result)
    }
    it("returns the input list and Nil when n is greater than the list length") {
      val expected = (raw,Nil)
      val result = P17.split(raw.length + 1,raw);
      assert(result == expected,"Expected: " + expected +  " Got: " + result)
    }
    it("Returns two empty lists when run on an empty list") {
      val expected = (Nil,Nil);
      val result = P17.split(n,Nil);
      assert(result == expected, "Expected: " + expected + " Got: " + result)
    }
  }

}

// vim: set ts=2 sw=2 et:
