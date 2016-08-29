package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._
import concurrent.Future
import scala.util.{Success,Failure}
import concurrent.ExecutionContext.Implicits.global

import org.scalatest._

class PrimeSpec extends NNPSpec {

  markup { """

  get the nth prime

  """ }

  describe("prime") {
    it("gets the nth prime") {
      whenReady(prime(6)) { result =>
        assert(result == 13)
      }
    }
  }


}


// vim: set ts=2 sw=2 et:
