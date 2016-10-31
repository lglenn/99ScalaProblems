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

      def threeTree(left: Tree[String], right: Tree[String]): Tree[String] = Node(v,left,right)

      val a = threeTree(both,both);
      val b = threeTree(both,leftLeaf);
      val c = threeTree(both,rightLeaf);
      val d = threeTree(leftLeaf,leftLeaf);
      val e = threeTree(leftLeaf,rightLeaf);
      val f = threeTree(rightLeaf,both);
      val g = threeTree(rightLeaf,leftLeaf);
      val h = threeTree(rightLeaf,rightLeaf);
      val i = threeTree(both,End);
      val j = threeTree(leftLeaf,End);
      val k = threeTree(rightLeaf,End);
      val l = threeTree(End,both);
      val m = threeTree(End,leftLeaf);
      val n = threeTree(End,rightLeaf);

      it("contains every height-balanced binary tree for a given depth") {
        Tree.hbalTrees(3,v) should contain only (a,b,c,d,e,f,g,h,i,j,k,l,m,n)
      }

  }

}

  // vim: set ts=2 sw=2 et:
