package io.lglenn.nnproblems

import org.scalatest._

class P06Spec extends NNPSpec {

  describe("isPalindrome") {

    val l = List('a,'b,'c,'d,'c,'b,'a)

    it("should be true for a palindrome") {
      P06.isPalindrome(l) should be (true)
    }

    it("should be false for a non-palindrome") {
      P06.isPalindrome(l.tail) should be (false)
    }

    it("should be true for an empty list") {
      P06.isPalindrome(Nil) should be (true)
    }

  }

}


// vim: set ts=2 sw=2 et:
