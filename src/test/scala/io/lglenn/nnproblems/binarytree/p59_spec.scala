package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P59Spec extends NNPSpec {

  markup { """

    P59 (**) Construct height-balanced binary trees.
    
    In a height-balanced binary tree, the following property holds
    for every node: The height of its left subtree and the height
    of its right subtree are almost equal, which means their
    difference is not greater than one.

    Write a method Tree.hbalTrees to construct height-balanced
    binary trees for a given height with a supplied value for the
    nodes. The function should generate all solutions.

        scala> Tree.hbalTrees(3, "x")
        res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...

    """ }


    describe("Tree.hbalTrees") {
      val v: String = "x";
      val leftLeaf = Node(v,Node(v),End);
      val rightLeaf = Node(v,End,Node(v));
      val both = Node(v,Node(v),Node(v));
      val node = Node(v);

      def threeTree(left: Tree[String], right: Tree[String]): Tree[String] = Node(v,left,right);

      def extraTrees[T](expected: List[Tree[T]],result: List[Tree[T]]): List[Tree[T]] = 
        result filter { e => !expected.contains(e) }

      val elements = List(
        threeTree(both,both),
        threeTree(both,leftLeaf),
        threeTree(both,rightLeaf),
        threeTree(leftLeaf,both),
        threeTree(leftLeaf,leftLeaf),
        threeTree(leftLeaf,rightLeaf),
        threeTree(rightLeaf,both),
        threeTree(rightLeaf,leftLeaf),
        threeTree(rightLeaf,rightLeaf),
        threeTree(both,node),
        threeTree(leftLeaf,node),
        threeTree(rightLeaf,node),
        threeTree(node,both),
        threeTree(node,leftLeaf),
        threeTree(node,rightLeaf));

      it("contains every height-balanced binary tree for a given depth") {
        val result = Tree.hbalTrees(3,v);
        elements foreach { elem => result should contain (elem) }
        assert(result.size == elements.size,s"Result contained unexpected trees: ${extraTrees(elements,result)}")
      }

      it("works with height 2") {
        Tree.hbalTrees(2,v) should contain only (leftLeaf,rightLeaf,both)
      }

      it("works with height 1") {
        Tree.hbalTrees(1,v) should contain only (node)
      }

      it("works with height 0") {
        Tree.hbalTrees(0,v) should be (empty)
      }

    }

  }

  // vim: set ts=2 sw=2 et:
