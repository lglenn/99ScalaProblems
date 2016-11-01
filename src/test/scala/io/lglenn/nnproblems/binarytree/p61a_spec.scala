package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P61ASpec extends NNPSpec {

  markup { """

  61A (*) Collect the leaves of a binary tree in a list.

  A leaf is a node with no successors. Write a method leafList to collect them in a list.

      scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
      res0: List[Char] = List(b, d, e)

  """ }

  describe("leafList") {
    val tree = Node("n",Node("leaf1"),Node("n",Node("leaf2"),Node("n",Node("leaf3"),Node("leaf4"))))
    it("collects the leaves of a binary tree in a list") {
      tree.leafList should contain only ("leaf1","leaf2","leaf3","leaf4")
    }
    it("handles nodes with one child") {
      Node("n",Node("leaf"),End).leafList should contain only ("leaf")
    }
    it("handles a one-node tree") {
      Node("leaf").leafList should contain only ("leaf")
    }
    it("handles the empty tree") {
      End.leafList should be (Nil)
    }
  }

}

// vim: set ts=2 sw=2 et:
