package io.lglenn.nnproblems

// P12 (**) Decode a run-length encoded list.
// Given a run-length code list generated as specified in problem P10, construct its uncompressed version.

object P12 {

    def decode[T](l: List[(T,Int)]): List[T] = l flatMap { e => List.fill(e._2)(e._1) }

}

// vim: set ts=4 sw=4 et:
