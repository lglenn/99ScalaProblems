package io.lglenn.nnproblems

// p06: see if a list is a palindrome

object P06 {

    def isPalindrome[T](l: List[T]): Boolean = l == l.reverse

}

// vim: set ts=4 sw=4 et:
