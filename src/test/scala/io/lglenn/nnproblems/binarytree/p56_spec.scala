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

  val x = "x"
  val leaf = Node(x);

  describe("Tree.isMirrorOf") {
    describe("when the tree is empty") {
      it("is true when the other tree is empty") {
        assert(End.isMirrorOf(End))
      }
      it("is false when the other tree is not empty") {
        assert(!End.isMirrorOf(leaf))
      }
    }
    describe("when the tree consists of a single leaf") {
      it("is true when the other tree also consists of a single leaf") {
        assert(leaf.isMirrorOf(leaf))
      }
      it("is false when the other tree is empty") {
        assert(!leaf.isMirrorOf(End))
      }
      it("is false when the other tree does not consist of a single leaf") {
        assert(!leaf.isMirrorOf(Node(x,leaf,leaf)))
      }
    }
    describe("when the tree is complex") {
      it("is true when the other is a mirror") {
        assert(Node(x,Node(x,End,leaf)).isMirrorOf(Node(x,Node(x,leaf,End))))
      }
      it("is false when the other is not a mirror") {
        assert(Node(x,Node(x,End,leaf)).isMirrorOf(Node(x,Node(x,Node(x,leaf,leaf),End))))
      }
    }
  }

  describe("Tree.isSymmetric") {
    it("is true when the tree is empty") {
      assert(End.isSymmetric)
    }
    it("is true when the tree contains a single node") { 
      assert(leaf.isSymmetric)
    }
    it("is true when a complex tree is symmetric") {
      assert(Node('a', Node('b'), Node('c')).isSymmetric)
    }
    it("is false when a complex tree is not symmetric") {
      assert(!Node('a', Node('b'), Node('c',leaf,End)).isSymmetric)
    }
  }

}

// vim: set ts=2 sw=2 et:
