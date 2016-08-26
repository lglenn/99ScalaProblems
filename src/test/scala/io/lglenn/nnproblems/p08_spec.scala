package io.lglenn.nnproblems

import org.scalatest._

class P08Spec extends NNPSpec {

  type A = Symbol

  type DeDuper = (List[A]) => List[A]

  def aDeDuper(func: DeDuper) = {

    val duped = List('a,'b,'c,'c,'d,'e,'e,'f);
    val deduped = List('a,'b,'c,'d,'e,'f);

    it("de-dupes a list with dupes") {
      assert(func(duped) == deduped)
    }
    it("leaves a list with no dupes alone") {
      assert(func(deduped) == deduped)
    }
    it("returns an empty list when given an empty list") {
      assert(func(Nil) == Nil)
    }
  }

  describe("dedupe") {
    it should behave like aDeDuper(P08.dedupe[A])
  }

  describe("dedupeFunc") {
    it should behave like aDeDuper(P08.dedupeFunc[A])
  }

  describe("dedupeTail") {
    it should behave like aDeDuper(P08.dedupeTail[A])
  }

}

// vim: set ts=2 sw=2 et:
