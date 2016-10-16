package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P40Spec extends NNPSpec {

  markup { """

  P40 (**) Goldbach's conjecture.

  Goldbach's conjecture says that every positive even number greater than 2 is the sum of
  two prime numbers. E.g. 28 = 5 + 23. It is one of the most famous facts in number theory
  that has not been proved to be correct in the general case. It has been numerically
  confirmed up to very large numbers (much larger than Scala's Int can represent). Write a
  function to find the two prime numbers that sum up to a given even integer.

      scala> 28.goldbach
      res0: (Int, Int) = (5,23)

  """ }

  describe("goldbach") {
    it("finds two primes that sum to a given even int") {
      assert(12.goldbach == (5,7),"input was 12")
    }
    it("throws an IllegalArgumentException when given an odd number") {
      an [IllegalArgumentException] should be thrownBy { 11.goldbach }
    }
    it("throws an IllegalArgumentException when given an even integer smaller than 4") {
      an [IllegalArgumentException] should be thrownBy { 2.goldbach }
    }

  }

}

// vim: set ts=2 sw=2 et:
