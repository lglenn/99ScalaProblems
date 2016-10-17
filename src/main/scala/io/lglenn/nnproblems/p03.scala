package io.lglenn.nnproblems

// p03: kth element of list

object P03 {

    def kth[A](l: List[A],k: Int): A = if (k == 1) l.head else kth(l.tail,k-1)

}

// vim: set ts=4 sw=4 et:
