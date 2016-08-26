package io.lglenn.nnproblems

import scala.annotation.tailrec

/*
* P22 (*) Create a list containing all integers within a given range.
* Example:
* scala> range(4, 9)
* res0: List[Int] = List(4, 5, 6, 7, 8, 9)
*/

object P22 {

  def range(start: Int, finish: Int): List[Int] = 
    List.iterate(start,finish - start + 1) { _ + 1 }

  def rangeBuiltin(start: Int, finish: Int): List[Int] =
    List.range(start,finish + 1)

  def rangeRec(start: Int, finish: Int): List[Int] =
    if (start > finish) Nil else start :: rangeRec(start + 1,finish);

  def rangeTail(start: Int, finish: Int): List[Int] = {
    @tailrec def myRange(start: Int, acc: List[Int]): List[Int] = {
      if(start > finish) acc else myRange(start + 1, start :: acc);
    }
    myRange(start,Nil).reverse
  }


}
// vim: set ts=2 sw=2 et:
