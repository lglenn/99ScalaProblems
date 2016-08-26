package io.lglenn.nnproblems

import org.scalatest._

class P19Spec extends NNPSpec {

  markup { """

  P19 (**) Rotate a list N places to the left.

  Examples:

    scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

    scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

  """ }

  val pos = 3
  val neg = -2
  val big = 12
  val raw = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k);
  val rotated_pos = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c);
  val rotated_neg = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i);
  val rotated_big = List('b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a);

  describe("rotate") {
    it("rotates the list to the left when given a positive number of places") {
      assert(P19.rotate(pos,raw) == rotated_pos)
    }
    it("rotates the list to the right when given a negative number of places") {
      assert(P19.rotate(neg,raw) == rotated_neg)
    }
    it("handles rotating by a number greater than the length of the list") {
      assert(P19.rotate(big,raw) == rotated_big)
    }
    it("returns an empty list when asked to rotate one to the right") {
      assert(P19.rotate(pos,Nil) == Nil)
    }
    it("returns an empty list when asked to rotate one to the left") {
      assert(P19.rotate(neg,Nil) == Nil)
    }
    it("returns the list when asked to rotate it by zero places") {
      assert(P19.rotate(0,raw) == raw)
    }
  }

}

// vim: set ts=2 sw=2 et:
