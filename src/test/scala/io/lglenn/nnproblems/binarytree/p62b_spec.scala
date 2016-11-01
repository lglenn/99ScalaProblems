package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P62BSpec extends NNPSpec {

  markup { """

  P62B (*) Collect the nodes at a given level in a list.

  A node of a binary tree is at level N if the path from the root
  to the node has length N-1. The root node is at level 1. Write a
  method atLevel to collect all nodes at a given level in a list.

      scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
      res0: List[Char] = List(b, c)

  Using atLevel it is easy to construct a method levelOrder which
  creates the level-order sequence of the nodes. However, there are
  more efficient ways to do that.

  """ }

  describe("atLevel") {
    val tree = Node('a', Node('b'), Node('c', Node('d'), Node('e')));
    it("gets the node values at a given level") {
      tree.atLevel(2) should contain only ('b','c')
    }
    it("handles the root node properly") {
      tree.atLevel(1) should contain only ('a')
    }
    it("returns the empty list when the leveles parameter is larger than the tree height") {
      tree.atLevel(120) should be (Nil)
    }
    it("returns the empty list when the leveles parameter is less than 1") {
      tree.atLevel(-120) should be (Nil)
    }
    it("returns the empty list when called on End") {
      End.atLevel(1) should be (Nil)
    }
  }

}

// vim: set ts=2 sw=2 et:
