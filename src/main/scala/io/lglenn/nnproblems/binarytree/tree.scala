package io.lglenn.nnproblems.binarytree

sealed abstract class Tree[+T] {
  def isMirrorOf[A](other: Tree[A]): Boolean
  def isSymmetric: Boolean
  def addValue[U >: T <% Ordered[U]](v: U): Tree[U] 
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {

  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  def isMirrorOf[A](other: Tree[A]): Boolean = other match {
    case End => false
    case Node(_,l,r) => left.isMirrorOf(r) && right.isMirrorOf(l)
  }

  def isSymmetric: Boolean = left.isMirrorOf(right);

  def addValue[U >: T <% Ordered[U]](v: U): Tree[U] = {
    if(v < value) {
      Node(value,left.addValue(v),right)
    } else {
      Node(value,left,right.addValue(v))
    }
  }

}

case object End extends Tree[Nothing] {

  override def toString = "."

  def isMirrorOf[A](other: Tree[A]): Boolean = other match {
    case End => true
    case _ => false
  }

  def isSymmetric: Boolean = true

  def addValue[U <% Ordered[U]](v: U): Tree[U] = Node(v)
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End);
}

object Tree {

  // P55
  def cbalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case 0 => List(End)
    case n if n % 2 == 1 => {
      // left and right subtrees contain the same number of nodes
      val trees = cbalanced(nodes / 2,value);
      for {
        a <- trees
        b <- trees
      } yield Node(value,a,b)
    }
    case _ => {
      // one subtree will be one node larger than the other
      val smallTree = cbalanced((nodes / 2) - 1, value);
      val bigTree = cbalanced(nodes / 2, value);
      for {
        a <- bigTree
        b <- smallTree
        subtrees <- List((a,b),(b,a))
      } yield Node(value,subtrees._1,subtrees._2)
    }
  } 

}

// vim: set ts=2 sw=2 et:
