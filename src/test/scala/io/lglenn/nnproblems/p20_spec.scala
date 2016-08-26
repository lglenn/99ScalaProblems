package io.lglenn.nnproblems

import org.scalatest._

class P20Spec extends NNPSpec {

  markup { """

  P20 (*) Remove the Kth element from a list.
  Return the list and the removed element in a Tuple. Elements are numbered from 0.

  Example:

    scala> removeAt(1, List('a, 'b, 'c, 'd))
    res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

  """ }

  val raw = List('a, 'b, 'c, 'd);
  val removed = (List('a, 'c, 'd),'b);

  describe("removeAt") {
    it("removes the element at position p") {
      assert(P20.removeAt(1,raw) == removed)
    }
  }

}

// vim: set ts=2 sw=2 et:
