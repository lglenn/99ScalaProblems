package io.lglenn.nnproblems

// P10 (*) Run-length encoding of a list.

object P10 {

    import io.lglenn.nnproblems.P09.pack

    def encode[T](l: List[T]): List[(Int,T)] =  pack(l) map { e => (e.size,e.head) }

}

// vim: set ts=4 sw=4 et:
