package io.lglenn.nnproblems

import org.scalatest._

class P13Spec extends NNPSpec {

  markup { """

  P13 (**) Run-length encoding of a list (direct solution).

  Implement the so-called run-length encoding data compression method directly.
  I.e. don't use other methods you've written (like P09's pack); do all the work directly.

  Example:

    scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  """ }

  type A = Symbol

  type Encoder = (List[A]) => List[(Int,A)]

  def aDirectEncoder(func: Encoder): Unit = {

    val raw = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e);
    val encoded = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e));

    it("run-length encodes a list") {
      val result = func(raw);
      assert(result == encoded, "Expected : " + encoded + ", Got: " + result)
    }

    it("returns an empty list when given an empty list") {
      func(Nil) should equal (Nil)
    }

  }

  describe("encodeDirect") {
    it should behave like aDirectEncoder(P13.encodeDirect[A])
  }

  describe("encodeDirectTail") {
    it should behave like aDirectEncoder(P13.encodeDirectTail[A])
  }

  describe("encodeDirectFunc") {
    it should behave like aDirectEncoder(P13.encodeDirectFunc[A])
  }

  describe("encodeDirectCompact") {
    val raw = List('a,'a,'d,'c,'c,'d);
    val expected = List((2,'a),'d,(2,'c),'d);
    it("compacts elements with one occurrence") {
      assert(P13.encodeDirectCompact(raw) == expected)
    }
  }

}

// vim: set ts=2 sw=2 et:
