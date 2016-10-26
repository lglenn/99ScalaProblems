package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P55Spec extends NNPSpec {

  markup { """

  P55 (**) Construct completely balanced binary trees.

  In a completely balanced binary tree, the following property holds for every node: The number
  of nodes in its left subtree and the number of nodes in its right subtree are almost equal,
  which means their difference is not greater than one.

  Define an object named Tree. Write a function Tree.cBalanced to construct completely balanced
  binary trees for a given number of nodes. The function should generate all solutions. The
  function should take as parameters the number of nodes and a single value to put in all of
  them.

      scala> Tree.cBalanced(4, "x")
      res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...

  """ }

  describe("Tree.cbalancd") {

    val x = "x";
    val leftLeg = Node(x,Node(x),End);
    val rightLeg = Node(x,End,Node(x));
    val leaf = Node(x)

    describe("when there are 0 nodes") {
      it("returns a list containing only the empty tree") {
        assert(Tree.cbalanced(0,x) == List(End))
      }
    }
    describe("when there is 1 node") {
      it("returns a list containing a single node with no children") {
        assert(Tree.cbalanced(1,x) == List(leaf))
      }
    }
    describe("when there are 2 nodes") {
      it("returns a list containing the two possible trees") {
        val result = Tree.cbalanced(2,x);
        result should contain only (leftLeg,rightLeg)
      }
    }
    describe("when there is some larger even number of nodes") {
      val result = Tree.cbalanced(4,x);
      val a = Node(x,leftLeg,leaf)
      val b = Node(x,rightLeg,leaf)
      val c = Node(x,leaf,leftLeg)
      val d = Node(x,leaf,rightleg)
      result should contain only (a,b,c,d)
    }
    describe("when there is some larger odd number of nodes") {
      val result = Tree.cbalanced(5,x);
      val e = Node(x,leftLeg,leftLeg)
      val f = Node(x,leftLeg,rightLeg)
      val g = Node(x,rightLeg,leftLeg)
      val h = Node(x,rightLeg,rightLeg)
      result should contain only (e,f,g,h)
    }

  }

}

// vim: set ts=2 sw=2 et:
