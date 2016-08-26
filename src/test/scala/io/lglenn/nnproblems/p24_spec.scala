package io.lglenn.nnproblems

import org.scalatest._

class P24Spec extends NNPSpec {

  markup { """

  P24 (*) Lotto: Draw N different random numbers from the set 1..M.

  Example:

    scala> lotto(6, 49)
    res0: List[Int] = List(23, 1, 17, 33, 21, 37)

  """ }

  describe("lotto") {
    it("gets the right number of values") {
      assert(P24.lotto(5,10).size == 5)
    }
    it("only returns numbers between 1 and n") {
      val result = (1 to 10) map { _ => List(1,2).contains(P24.lotto(1,2).head) } reduce { _ && _ }
      assert(result)
    }
  }

}

// vim: set ts=2 sw=2 et:
