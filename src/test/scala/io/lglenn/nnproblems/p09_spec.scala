package io.lglenn.nnproblems

import org.scalatest._

class P09Spec extends NNPSpec {

  markup { """

  Pack consecutive duplicates of list elements into sublists.

  If a list contains repeated elements they should be placed in separate sublists.
  Example:

    scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

  """ }

  type A = Symbol

  type Packer = (List[A]) => List[List[A]]

  def aPacker(func: Packer) = {

    val unpacked = List('a,'b,'c,'c,'d,'e,'e,'e,'f);
    val packed = List(List('a),List('b),List('c,'c),List('d),List('e,'e,'e),List('f));

    it("packs a list with dupes") {
      assert(func(unpacked) == packed)
    }
    it("returns an empty list when given an empty list") {
      assert(func(Nil) == Nil)
    }
  }

  describe("pack") {
    it should behave like aPacker(P09.pack[A])
  }

}

// vim: set ts=2 sw=2 et:
