package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P35Spec extends NNPSpec {

  markup { """

  P35 (**) Determine the prime factors of a given positive integer.
  Construct a flat list containing the prime factors in ascending order.

    scala> 315.primeFactors
    res0: List[Int] = List(3, 3, 5, 7)

  """ }

  describe("primeFactors") {
    it("calculates the prime factors") {
      assert(315.primeFactors == List(3,5,7))
    }
    it("knows that the prime factors of 0 is Nil") {
      assert(0.primeFactors == Nil)
    }
    it("knows that the prime factors of 1 is Nil") {
      assert(1.primeFactors == Nil)
    }
  }


}


// vim: set ts=2 sw=2 et:
