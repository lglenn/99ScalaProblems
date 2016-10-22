package io.lglenn.nnproblems

import scala.annotation.tailrec
import scala.collection.mutable

sealed trait Tree {
  def weight: Int
  def codes(code: String): List[(String,String)]
}

final case class Node(left: Tree, right: Tree) extends Tree {
  def weight: Int = left.weight + right.weight
  def codes(code: String): List[(String,String)] =
    List(left.codes(code + "0"),right.codes(code + "1")).flatten
}

final case class Leaf(weight: Int, symbol: String) extends Tree {
  def codes(code: String): List[(String,String)] =
    List((symbol,code))
}

object P50 {

  def huffman(ls: List[(String,Int)]): List[(String,String)] = {
    val tree = huffmanTree(ls);
    tree.codes("") sortBy { case (sym,code) => sym } 
  }

  def huffmanTree(ls: List[(String,Int)]): Tree = {
    val q = new mutable.PriorityQueue[Tree]()(Ordering.by[Tree, Int]( -_.weight ));
    ls foreach ((e) => e match { case (sym,weight) => q.enqueue(Leaf(weight,sym)) })
    @tailrec def makeTree: Unit = {
      if(q.size > 1) {
        val a = q.dequeue
        val b = q.dequeue
        val node = if(a.weight < b.weight) Node(a,b) else Node(b,a);
        q.enqueue(node)
        makeTree
      }
    }
    makeTree
    q.dequeue
  }

}

// vim: set ts=4 sw=4 et:
