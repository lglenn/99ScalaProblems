package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P62Spec extends NNPSpec {

  markup { """

  P62 (*) Collect the internal nodes of a binary tree in a list.

  An internal node of a binary tree has either one or two non-empty
  successors. Write a method internalList to collect them in a list.

      scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
      res0: List[Char] = List(a, c)

  """ }

  describe("internalList") {
    val tree = Node("root",Node("leaf1"),Node("node1",Node("leaf2"),Node("node2",Node("leaf3"),Node("leaf4"))))
    it("collects the values of internal nodes of a binary tree in a list") {
    tree.internalList should contain only ("root","node1","node2")
  }
  it("handles nodes with one child") {
    Node("root",Node("leaf"),End).internalList should contain only ("root")
  }
  it("handles a one-node tree") {
    Node("root").internalList should be (Nil)
  }
  it("handles the empty tree") {
    End.internalList should be (Nil)
  }
}

}

// vim: set ts=2 sw=2 et:
