package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.P50._

import org.scalatest._

class P50Spec extends NNPSpec {

  markup { """

  P50 (***) Huffman code.

  First of all, consult a good book on discrete mathematics or algorithms for a
  detailed description of Huffman codes!

  We suppose a set of symbols with their frequencies, given as a list of (S, F)
  Tuples. E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).

  Our objective is to construct a list of (S, C) Tuples, where C is the Huffman
  code word for the symbol S.

      scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
      res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))

  """ }

  describe("huffman") {
    val raw = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5));
    val expected = List(("a","0"), ("b","101"), ("c","100"), ("d","111"), ("e","1101"), ("f","1100"));
    it("gets the huffman encoding") {
      assert(huffman(raw) == expected)
    }
  }

}

// vim: set ts=2 sw=2 et:
