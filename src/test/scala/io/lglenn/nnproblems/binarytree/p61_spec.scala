package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P61Spec extends NNPSpec {

  markup { """

  P61 (*) Count the leaves of a binary tree.

  A leaf is a node with no successors. Write a method leafCount to count them.

      scala> Node('x', Node('x'), End).leafCount
      res0: Int = 1

  """ }

  describe("leafCount") {
    it("counts the leaves") {
      Node('x').leafCount should be (1)
      Node('x', Node('x'), End).leafCount should be (1)
      Node('x', Node('x'), Node('x')).leafCount should be (2)
      Node('x', Node('x',Node('x'),End), Node('x')).leafCount should be (2)
    }
  }


}

// vim: set ts=2 sw=2 et:
