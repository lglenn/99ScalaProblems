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

  describe("Tree.cbalancd") (pending)

}

// vim: set ts=2 sw=2 et:
