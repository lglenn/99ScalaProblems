package test.scala.io.lglenn.nnproblems.arithmetic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.arithmetic.S99Int
import io.lglenn.nnproblems.arithmetic.S99Int._

import org.scalatest._

class P41Spec extends NNPSpec {

  markup { """

  P41 (**) A list of Goldbach compositions.

  Given a range of integers by its lower and upper limit, print a list of all
  even numbers and their Goldbach composition.

      scala> printGoldbachList(9 to 20)
      10 = 3 + 7
      12 = 5 + 7
      14 = 3 + 11
      16 = 3 + 13
      18 = 5 + 13
      20 = 3 + 17

  In most cases, if an even number is written as the sum of two prime numbers,
  one of them is very small. Very rarely, the primes are both bigger than, say,
  50. Try to find out how many such cases there are in the range 2..3000.

  Example (minimum value of 50 for the primes):

      scala> printGoldbachListLimited(1 to 2000, 50)
      992 = 73 + 919
      1382 = 61 + 1321
      1856 = 67 + 1789
      1928 = 61 + 1867

  """ }

  describe("getGoldbachList") {
    it("gets the Goldbach compositions of all even numbers in the range as pretty strings") {
      val raw = 9 to 20;
      val expected = List( "10 = 3 + 7", "12 = 5 + 7", "14 = 3 + 11", "16 = 3 + 13", "18 = 5 + 13", "20 = 3 + 17");
      assert(getGoldbachList(raw) == expected,s"input was '$raw'")
    }
  }

  describe("goldbachListLimmited") {
    it("gets the Goldbach compositions of all even numbers in the range as pretty strings, limiting output to pairs that are both greater than a threshold value") {
      val raw = 1 to 2000;
      val threshold = 50;
      val expected = List("992 = 73 + 919", "1382 = 61 + 1321", "1856 = 67 + 1789", "1928 = 61 + 1867");
      assert(goldbachListLimited(raw,threshold) == expected, s"input was '$raw'")
    }
  }

}

// vim: set ts=2 sw=2 et:
