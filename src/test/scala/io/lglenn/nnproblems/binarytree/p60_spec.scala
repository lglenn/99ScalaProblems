package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P60Spec extends NNPSpec {

  markup { """

  P60 (**) Construct height-balanced binary trees with a given
  number of nodes.

  Consider a height-balanced binary tree of height H. What is the
  maximum number of nodes it can contain? Clearly, MaxN = 2H - 1.
  However, what is the minimum number MinN? This question is more
  difficult. Try to find a recursive statement and turn it into a
  function minHbalNodes that takes a height and returns MinN.

      scala> minHbalNodes(3)
      res0: Int = 4

  On the other hand, we might ask: what is the maximum height H a
  height-balanced binary tree with N nodes can have? Write a
  maxHbalHeight function.

      scala> maxHbalHeight(4)
      res1: Int = 3

  Now, we can attack the main problem: construct all the height-balanced
  binary trees with a given nuber of nodes.

      scala> Tree.hbalTreesWithNodes(4, "x")
      res2: List[Node[String]] = List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), ...

  Find out how many height-balanced trees exist for N = 15.

    """ }

    describe("Tree.minHbalNodes") {
      it("finds the minumum number of nodes required to build a height-balanced tree of height h") {
        Tree.minHbalNodes(1) should be(1)
        Tree.minHbalNodes(2) should be(2)
        Tree.minHbalNodes(5) should be(12)
      }
    }

    describe("Tree.maxHbalHeight") {
      it("finds the maximum height for a height-balanced tree with 1 node") {
        Tree.maxHbalHeight(1) should be(1)
      }
      it("finds the maximum height for a height-balanced tree with 2 nodes") {
        Tree.maxHbalHeight(2) should be(2)
      }
      it("finds the maximum height for a height-balanced tree with n nodes") {
        Tree.maxHbalHeight(4) should be(3)
      }
    }

    describe("Tree.hbalTreesWithNodes") {
      it("builds the right number of height-balanced binary trees with 1 node") {
        Tree.hbalTreesWithNodes(1,"x") should have size(1)
      }
      it("builds the right number of height-balanced binary trees with 2 nodes") {
        Tree.hbalTreesWithNodes(2,"x") should have size(2)
      }
      it("builds the right number of height-balanced binary trees with 3 nodes") {
        Tree.hbalTreesWithNodes(3,"x") should have size(1)
      }
      it("builds the right number of height-balanced binary trees with 4 nodes") {
        Tree.hbalTreesWithNodes(4,"x") should have size(4)
      }
      it("builds the right number of height-balanced binary trees with 15 nodes") {
        Tree.hbalTreesWithNodes(15,"x") should have size(1553)
      }
    }

  }

  // vim: set ts=2 sw=2 et:
