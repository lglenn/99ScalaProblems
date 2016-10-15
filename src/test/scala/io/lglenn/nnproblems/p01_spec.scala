package io.lglenn.nnproblems

import org.scalatest._
import io.lglenn.nnproblems.P03._

class P01Spec extends NNPSpec {

  markup { """

  P01 (*) Find the last element of a list.

  Example:

     scala> last(List(1, 1, 2, 3, 5, 8))
     res0: Int = 8

  """ }


  describe("last") {

    def aLastFunc(func: List[Symbol] => Symbol): Unit = {

      val raw = List('a,'b,'c,'d);
      val expected = 'd;

      it("finds the last element of the list") {
        val result = func(raw);
        assert(result == expected, "Expected : " + expected + ", Got: " + result)
      }

    }

    describe("lastDirect") {
      it should behave like aLastFunc(P01.lastDirect)
    }

    describe("lastRecursive") {
      it should behave like aLastFunc(P01.lastRecursive)
    }


  }

}


// vim: set ts=2 sw=2 et:
