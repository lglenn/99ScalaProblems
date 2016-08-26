package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P21Spec extends NNPSpec {

  markup { """

  P31 (**) Determine whether a given integer number is prime.

  scala> 7.isPrime
  res0: Boolean = true

  """ }

  val primes = List(2,3,5,7,11,13)

  describe("isPrime") {
    it("returns true if n is prime") {
      primes.find(!_.isPrime) match {
        case None => assert(true)
        case Some(p) => assert(false,"isPrime thinks that " + p + " is not prime")
      }
    }
    it("knows that 1 is not prime") {
      assert(!1.isPrime,"isPrime thinks 1 is prime.")
    }
    it("returns false if n is not prime") {
      val candidates = (1 to 14) 
        candidates.filter(!primes.contains(_)).find(_.isPrime) match {
        case None => assert(true)
        case Some(candidate) => assert(false,candidate + " is not prime but isPrime says it is.")
      }
    }
  }


}


// vim: set ts=2 sw=2 et:
