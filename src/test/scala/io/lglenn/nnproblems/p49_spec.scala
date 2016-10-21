package test.scala.io.lglenn.nnproblems

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.P49._

import org.scalatest._

class P49Spec extends NNPSpec {

  markup { """

  P49 (**) Gray code.

  An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,

  n = 1: C(1) = ("0", "1").
  n = 2: C(2) = ("00", "01", "11", "10").
  n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").

  Find out the construction rules and write a function to generate Gray codes.

      scala> gray(3)
      res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)

  See if you can use memoization to make the function more efficient.

  """ }

  type GrayEncoder = Int => List[String]

  def aGrayEncoder(func: GrayEncoder): Unit = {

    it("calculates the Gray codes for all n-bit numbers") {
      val expected = List("0000","0001","0011","0010","0110","0111","0101","0100","1100","1101","1111","1110","1010","1011","1001","1000");
      val n = 4;
      assert(func(n) == expected)
    }
    it("returns \"0\",\"1\" for n == 1") {
      assert(func(1) == List("0","1"))
    }
    it("returns \"\" for the base case n == 0") {
      assert(func(0) == List(""))
    }
    it("throws an IllegalArgumentException if n < 1") {
      an [IllegalArgumentException] should be thrownBy { func(-1) }
    }

  }

  describe("gray") {
    it should behave like aGrayEncoder(gray)
  }

  describe("grayMemoized") {
    it should behave like aGrayEncoder(grayMemoized)
  }

}

// vim: set ts=2 sw=2 et:
