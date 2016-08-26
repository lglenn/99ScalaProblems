package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P33Spec extends NNPSpec {

  markup { """

  P33 (*) Determine whether two positive integer numbers are coprime.
  Two numbers are coprime if their greatest common divisor equals 1.

    scala> 35.isCoprimeTo(64)
    res0: Boolean = true

  """ }

  describe("isCoprimeTo") {
    it("returns true if two integers are coprime") {
      assert(35.isCoprimeTo(64))
    }
    it("returns false if two integers are not coprime") {
      assert(!24.isCoprimeTo(15))
    }
    it("knows that 1 and 1 are coprime") {
      assert(1.isCoprimeTo(1))
    }
    it("knows that 1 and 0 are coprime") {
      assert(1.isCoprimeTo(0))
    }
    it("knows that 1 is coprime with everythinng") {
      assert(10.isCoprimeTo(1))
    }
  }


}


// vim: set ts=2 sw=2 et:
