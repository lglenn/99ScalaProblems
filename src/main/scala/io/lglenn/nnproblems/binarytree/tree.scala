package io.lglenn.nnproblems.binarytree

import scala.annotation.tailrec

sealed abstract class Tree[+T] {
  def isMirrorOf[A](other: Tree[A]): Boolean
  def isSymmetric: Boolean
  def addValue[U >: T](v: U)(implicit ev: U => Ordered[U]): Tree[U] 
  def isHeightBalanced: Boolean
  def height: Int
  def size: Int
  def leafCount: Int
  def leafList: List[T]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {

  import scala.math.{abs,max}

  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  def isMirrorOf[A](other: Tree[A]): Boolean = other match {
    case End => false
    case Node(_,l,r) => left.isMirrorOf(r) && right.isMirrorOf(l)
  }

  def isSymmetric: Boolean = left.isMirrorOf(right);

  def addValue[U >: T](v: U)(implicit ev: U => Ordered[U]): Tree[U] = {
    if(v < value) {
      Node(value,left.addValue(v),right)
    } else {
      Node(value,left,right.addValue(v))
    }
  }

  def isHeightBalanced: Boolean =
    left.isHeightBalanced && right.isHeightBalanced && abs(left.height - right.height) < 2

  def height: Int = max(left.height,right.height) + 1

  def size: Int = left.size + right.size + 1

  def leafCount: Int = (left,right) match {
    case(End,End) => 1
    case _ => left.leafCount + right.leafCount
  }

  def leafList: List[T] = (left,right) match {
    case (End, End) => List(value)
    case _ => left.leafList ::: right.leafList
  }

}

case object End extends Tree[Nothing] {

  override def toString = "."

  def isMirrorOf[A](other: Tree[A]): Boolean = other match {
    case End => true
    case _ => false
  }

  def isSymmetric: Boolean = true

  def addValue[U](v: U)(implicit ev: U => Ordered[U]): Tree[U] = Node(v);

  def isHeightBalanced = true

  def height = 0
  
  def size = 0

  def leafCount = 0

  def leafList = Nil

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

  def fromList[T](ls: List[T])(implicit ev: T => Ordered[T]): Tree[T] =
    ls.foldLeft(End: Tree[T])((a,e) => a.addValue(e))

  def symmetricBalancedTrees[T](nodes: Int, value: T): List[Tree[T]] = 
    cbalanced(nodes,value) filter (_.isSymmetric)

  def minHbalNodes(h: Int): Int = h match {
    case 1 => 1
    case 2 => 2
    case _ => minHbalNodes(h - 1) + minHbalNodes(h - 2) + 1
  }

  def minHbalHeight(nodes: Int): Int = ((scala.math.log(nodes) / scala.math.log(2) + 1)).toInt;

  def maxHbalHeight(nodes: Int): Int = {
    def f(h: Int): Int = if (minHbalNodes(h + 1) > nodes) h else f(h + 1)
    f(1)
  }

  def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] = {
    val height = maxHbalHeight(nodes);
    val trees = (minHbalHeight(nodes) to maxHbalHeight(nodes)) flatMap (hbalTrees(_,value) filter (_.size == nodes))
    trees.toList
  }

  def hbalTrees[T](h: Int, value: T): List[Tree[T]] = { 

    def permute(t: List[Tree[T]], u: List[Tree[T]]): List[Tree[T]] = for { a <- t; b <- u } yield Node(value,a,b)

    h match {
      case 0 => List(End)
      case 1 => List(Node(value))
      case _ => {
        val subtrees = hbalTrees(h - 1, value);
        val smaller = hbalTrees(h - 2,value);
        permute(subtrees,subtrees) ::: permute(subtrees,smaller) ::: permute(smaller,subtrees)
      }
    }

  }

}

// vim: set ts=2 sw=2 et:
