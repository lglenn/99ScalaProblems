package io.lglenn.nnproblems.logic

object S99Logic {

  type UnaryLogicalOperator = Boolean => Boolean
  type BinaryLogicalOperator = (Boolean,Boolean) => Boolean

  def and: BinaryLogicalOperator = (a, b) => if (a) b else false

  def not: UnaryLogicalOperator = (a) => if (a) false else true

  def or: BinaryLogicalOperator = (a, b) => not(nor(a,b));

  def nand: BinaryLogicalOperator = (a,b) => not(and(a,b));

  def nor: BinaryLogicalOperator = (a,b) => and(not(a),not(b));

  def xor: BinaryLogicalOperator = (a,b) => and(nand(a,b),or(a,b));

  def impl: BinaryLogicalOperator = (a,b) => not(and(a,not(b)));
  
  def equ: BinaryLogicalOperator = (a,b) => or(and(a,b),nor(a,b));

  def table2(f: (Boolean, Boolean) => Boolean): List[String] = {
    val bools = List(true,false);
    val header = "A      B      result";
    val body = for {
      a <- bools
      b <- bools
    } yield f"$a%-6s $b%-6s ${f(a,b)}"
    header :: body
  }

}

// vim: set ts=2 sw=2 et:
