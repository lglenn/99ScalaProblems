package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P56Spec extends NNPSpec {

  markup { """

  P56 (**) Symmetric binary trees.

  Let us call a binary tree symmetric if you can draw a vertical line
  through the root node and then the right subtree is the mirror image
  of the left subtree. Add an isSymmetric method to the Tree class
  to check whether a given binary tree is symmetric. Hint: Write an
  isMirrorOf method first to check whether one tree is the mirror
  image of another. We are only interested in the structure, not in
  the contents of the nodes.

    scala> Node('a', Node('b'), Node('c')).isSymmetric
    res0: Boolean = true

  """ }

  describe("Tree.isSymmetric") (pending)

}

// vim: set ts=2 sw=2 et:
