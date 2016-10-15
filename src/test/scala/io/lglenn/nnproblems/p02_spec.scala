package io.lglenn.nnproblems

import org.scalatest._

class P02Spec extends NNPSpec {

  markup { """

  P02 (*) Find the last but one element of a list.

  Example:

      scala> penultimate(List(1, 1, 2, 3, 5, 8))
      res0: Int = 5

  """ }


  describe("penultimate") {

    def aPenultimateFunc(func: List[Symbol] => Symbol): Unit = {

      val raw = List('a,'b,'c,'d);
      val expected = 'c;

      it("finds the penultimate element of the list") {
        val result = func(raw);
        assert(result == expected, "Expected : " + expected + ", Got: " + result)
      }

    }

    describe("penultimate") {
      it should behave like aPenultimateFunc(P02.penultimate)
    }

  }

}


// vim: set ts=2 sw=2 et:
