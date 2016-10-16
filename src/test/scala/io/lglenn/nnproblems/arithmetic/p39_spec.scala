package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P39Spec extends NNPSpec {

  markup { """

  P39 (*) A list of prime numbers.

  Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.

      scala> listPrimesinRange(7 to 31)
      res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

  """ }

  describe("listPrimesinRange") {
    it("gets the primes in the range") {
      val raw = 7 to 31;
      val expected = List(7, 11, 13, 17, 19, 23, 29, 31);
      val result = listPrimesinRange(raw);
      assert(result == expected,s"input was $raw")
    }
    it("returns the empty list when there are no primes in the range") {
      val raw = (24 to 28);
      assert(listPrimesinRange(raw) == Nil,s"input was $raw")
    }
  }

}

// vim: set ts=2 sw=2 et:
