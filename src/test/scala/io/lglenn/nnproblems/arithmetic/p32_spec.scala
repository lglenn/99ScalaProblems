package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P32Spec extends NNPSpec {

  markup { """

  P32 (**) Determine the greatest common divisor of two positive integer numbers.
  Use Euclid's algorithm.

    scala> gcd(36, 63)
    res0: Int = 9

  """ }

  describe("gcd") {
    it("finds the gcd of two integeres") {
      assert(gcd(9,15) == 3)
    }
    it("works regardless of the ordering of the parameters") {
      assert(gcd(15,9) == 3)
    }
    it("works when given equal parameters") {
      assert(gcd(24,24) == 24)
    }
    it("returns 1 when the parameters are coprime") {
      assert(gcd(20,9) == 1)
    }
    it("properly handles gcd of 0 and something else") {
      assert(gcd(20,0) == 20)
    }
    it("returns 0 for gcd(0,0)") {
      assert(gcd(0,0) == 0)
    }
  }


}


// vim: set ts=2 sw=2 et:
