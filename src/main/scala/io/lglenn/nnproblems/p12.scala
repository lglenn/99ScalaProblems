package io.lglenn.nnproblems

// P12 (**) Decode a run-length encoded list.
// Given a run-length code list generated as specified in problem P10, construct its uncompressed version.

object P12 {

    def decode[A](l: List[(Int,A)]): List[A] = l flatMap { case (times,value) => List.fill(times)(value) }

}

// vim: set ts=4 sw=4 et:
