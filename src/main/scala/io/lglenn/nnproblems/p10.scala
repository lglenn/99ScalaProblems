package io.lglenn.nnproblems

// P10 (*) Run-length encoding of a list.

object P10 {

    import io.lglenn.nnproblems.P09.pack

    def rle[T](l: List[T]): List[(T,Int)] =  pack(l) map { e => (e.head,e.size) }

}

// vim: set ts=4 sw=4 et:
