package io.lglenn.nnproblems

import org.scalatest._
import io.lglenn.nnproblems.P03._

// def kth[A](l: List[A],k: Int): A 

class P03Spec extends NNPSpec {

  markup { """

  Find the Kth element of a list.

  By convention, the first element in the list is element 0.

  Example:

    scala> nth(2, List(1, 1, 2, 3, 5, 8))
    res0: Int = 2

  """ }


  describe("kth") {

    val l = List('a,'b,'c,'d)

    it("should return the kth element") {
      kth(l,3) should equal ('c)
    }

    it("gets the first element") {
      kth(l,1) should equal ('a)
    }

    it("gets the last element") {
      kth(l,4) should equal ('d)
    }

  }

}


// vim: set ts=2 sw=2 et:
