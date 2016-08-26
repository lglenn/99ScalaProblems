package io.lglenn.nnproblems

// p03: kth element of list

object P03 {

    def kth[A](l: List[A],k: Int): A = k match {
        case 1 => l.head
        case _ => kth(l.tail,k-1)
    }

}

// vim: set ts=4 sw=4 et:
