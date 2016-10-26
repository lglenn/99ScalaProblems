package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P57Spec extends NNPSpec {

  markup { """

  P57 (**) Binary search trees (dictionaries).

  Write a function to add an element to a binary search tree.

      scala> End.addValue(2)
      res0: Node[Int] = T(2 . .)

      scala> res0.addValue(3)
      res1: Node[Int] = T(2 . T(3 . .))

      scala> res1.addValue(0)
      res2: Node[Int] = T(2 T(0 . .) T(3 . .))

  Hint: The abstract definition of addValue in Tree should be def
  addValue[U >: T <% Ordered[U]](x: U): Tree[U]. The >: T is
  because addValue's parameters need to be contravariant in T.
  (Conceptually, we're adding nodes above existing nodes. In order
  for the subnodes to be of type T or any subtype, the upper nodes
  must be of type T or any supertype.) The <% Ordered[U] allows us
  to use the < operator on the values in the tree.

  Use that function to construct a binary tree from a list of
  integers.

      scala> Tree.fromList(List(3, 2, 5, 7, 1))
      res3: Node[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))

  Finally, use that function to test your solution to P56.

      scala> Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric
      res4: Boolean = true

      scala> Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric
      res5: Boolean = false

  """ }

  describe("Tree.addValue") {
    val a = End.addValue(2);
    val b = a.addValue(3);
    val c = b.addValue(0);
    it("handles the first insert in an empty tree") {
      assert(a == Node(2))
    }
    it("handles adding a right leaf") {
      assert(b == Node(2,End,Node(3)))
    }
    it("handles adding a left leaf") {
      assert(c == Node(2,Node(0),Node(3)))
    }
  }

}

// vim: set ts=2 sw=2 et:
