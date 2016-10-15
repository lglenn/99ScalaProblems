package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P37Spec extends NNPSpec {

  markup { """

  P37 (**) Calculate Euler's totient function phi(m) (improved).

  See problem P34 for the definition of Euler's totient function. If the list of the
  prime factors of a number m is known in the form of problem P36 then the function
  phi(m>) can be efficiently calculated as follows:
  
  Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their
  multiplicities) of a given number m. Then phi(m) can be calculated with the following formula:

      phi(m) = (p1^-1)*p1^(m1-1) * (p2^-1)*p2^(m2-1) * (p3^-1)*p3^(m3-1) * ...

  Note that a^b stands for the bth power of a.

  """ }

  describe("totientImproved") {
    it("calculates the totient") {
      val result = 10.totientImproved
      assert(result == 4,"10.totient should be 4, but we got " + result)
    }
  }

}

// vim: set ts=2 sw=2 et:
