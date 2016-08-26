package io.lglenn.nnproblems

import org.scalatest._

class P22Spec extends NNPSpec {

  markup { """

  P22 (*) Create a list containing all integers within a given range.

  Example:

    scala> range(4, 9)
    res0: List[Int] = List(4, 5, 6, 7, 8, 9)

  """ }

  type RangeFunc = (Int,Int) => List[Int]

  def aRangeFunc(f: RangeFunc): Unit = {
    val low = 4
    val high = 9
    val expected = List(4,5,6,7,8,9);

    it("generates an ordered list containing low..high") {
      assert(f(low,high) == expected)
    }

    it("contains one element when low and high are the same") {
      assert(f(low,low) == List(low))
    }

    it("returns an empty list when start > end") {
      assert(f(high,low) == Nil)
    }

  }

  describe("range") {
    it should behave like aRangeFunc(P22.range)
  }

  describe("rangeBuiltin") {
    it should behave like aRangeFunc(P22.rangeBuiltin)
  }

  describe("rangeRec") {
    it should behave like aRangeFunc(P22.rangeRec)
  }

  describe("rangeTail") {
    it should behave like aRangeFunc(P22.rangeTail)
  }

}

// vim: set ts=2 sw=2 et:
