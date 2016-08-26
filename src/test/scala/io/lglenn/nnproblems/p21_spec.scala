package io.lglenn.nnproblems

import org.scalatest._

class P21Spec extends NNPSpec {

  markup { """

  P21 (*) Insert an element at a given position into a list.

  Example:

    scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
    res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

  """ }

  val pos = 1
  val v = 'new
  val raw = List('a, 'b, 'c, 'd);
  val inserted = List('a, 'new, 'b, 'c, 'd);

  type A = Symbol
  type Inserter = (A,Int,List[A]) => List[A]

  def anInserter(f: Inserter): Unit = {
    it("inserts an element at the right spot") {
      assert(f(v,pos,raw) == inserted)
    }
  }

  describe("insertAt") {
    it should behave like anInserter(P21.insertAt[A])
  }

  describe("insertAtSplit") {
    it should behave like anInserter(P21.insertAtSplit[A])
  }

}

// vim: set ts=2 sw=2 et:
