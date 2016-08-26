package io.lglenn.nnproblems

import org.scalatest._

class P10Spec extends NNPSpec {

  markup { """

  Run-length encoding of a list.

  Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.

  Example:

  scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  """ }

  val raw = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e);
  val encoded = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e));

  describe("encode") {
    it("run-length encodes a list") {
      P10.encode(raw) should equal (encoded)
    }
    it("returns an empty list when given an empty list") {
      P10.encode(Nil) should equal (Nil)
    }
  }

}

// vim: set ts=2 sw=2 et:
