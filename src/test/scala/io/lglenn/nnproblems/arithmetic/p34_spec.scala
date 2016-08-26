package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P34Spec extends NNPSpec {

  markup { """

  P34 (**) Calculate Euler's totient function phi(m).

  Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.

  scala> 10.totient
  res0: Int = 4

  """ }

  describe("totient") {
    it("calculates the totient") {
      val result = 10.totient
      assert(result == 4,"10.totient should be 4, but we got " + result)
    }
  }


}


// vim: set ts=2 sw=2 et:
