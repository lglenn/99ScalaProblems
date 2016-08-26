package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P36Spec extends NNPSpec {

  markup { """

  P36 (**) Determine the prime factors of a given positive integer (2).
  Construct a list containing the prime factors and their multiplicity.

    scala> 315.primeFactorMultiplicity
    res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))

  Alternately, use a Map for the result.

    scala> 315.primeFactorMultiplicity
    res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

  """ }

  describe("primeFactorMultiplicity") {
    it("calculates the prime factors of an integer, and their multiplicity") {
      assert(315.primeFactorMultiplicity == List((3,2),(5,1),(7,1)))
    }
  }


}


// vim: set ts=2 sw=2 et:
