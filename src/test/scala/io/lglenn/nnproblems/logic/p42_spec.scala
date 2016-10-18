package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.logic.S99Logic
import io.lglenn.nnproblems.logic.S99Logic._

import org.scalatest._

class P42Spec extends NNPSpec {

  markup { """

  P46 (**) Truth tables for logical expressions.

  Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return
  true or false according to the result of their respective operations; e.g. and(A, B) is true if
  and only if both A and B are true.

      scala> and(true, true)
      res0: Boolean = true

      scala> xor(true. true)
      res1: Boolean = false

  A logical expression in two variables can then be written as an function of two variables, e.g:
  (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))

  Now, write a function called table2 which prints the truth table of a given logical expression
  in two variables.

      scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
      A     B     result
      true  true  true
      true  false true
      false true  false
      false false false

  """ }

  describe("and") {
    it("is true for true true") {
      assert(and(true,true))
    }
    it("is false for true false") {
      assert(!and(true,false))
    }
    it("is false for false true") {
      assert(!and(false,true))
    }
    it("is false for false false") {
      assert(!and(false,false))
    }
  }

  describe("or") {
    it("is true for true true") {
      assert(or(true,true))
    }
    it("is true for true false") {
      assert(or(true,false))
    }
    it("is true for false true") {
      assert(or(false,true))
    }
    it("is false for false false") {
      assert(!or(false,false))
    }
  }

  describe("nand") {
    it("is false for true true") {
      assert(!nand(true,true))
    }
    it("is true for true false") {
      assert(nand(true,false))
    }
    it("is true for false true") {
      assert(nand(false,true))
    }
    it("is true for false false") {
      assert(nand(false,false))
    }
  }

  describe("nor") {
    it("is false for true true") {
      assert(!nor(true,true))
    }
    it("is false for true false") {
      assert(!nor(true,false))
    }
    it("is false for false true") {
      assert(!nor(false,true))
    }
    it("is true for false false") {
      assert(nor(false,false))
    }
  }

  describe("xor") {
    it("is false for true true") {
      assert(!xor(true,true))
    }
    it("is true for true false") {
      assert(xor(true,false))
    }
    it("is true for false true") {
      assert(xor(false,true))
    }
    it("is false for false false") {
      assert(!xor(false,false))
    }
  }

  describe("impl") {
    it("is true for true true") {
      assert(impl(true,true))
    }
    it("is false for true false") {
      assert(!impl(true,false))
    }
    it("is true for false true") {
      assert(impl(false,true))
    }
    it("is true for false false") {
      assert(impl(false,false))
    }
  }

  describe("equ") {
    it("is true for true true") {
      assert(equ(true,true))
    }
    it("is false for true false") {
      assert(!equ(true,false))
    }
    it("is false for false true") {
      assert(!equ(false,true))
    }
    it("is true for false false") {
      assert(equ(false,false))
    }
  }

  describe("table2") {
    val f: (Boolean, Boolean) => Boolean = (a,b) => and(a, or(a,b));
    val table = table2(f)
    it("has a proper header") {
      assert(table.head == "A      B      result")
    }
    it("has the right value for inputs true, true") {
      assert(table.drop(1).head == "true   true   true")
    }
    it("has the right value for inputs true, false") {
      assert(table.drop(2).head == "true   false  true")
    }
    it("has the right value for inputs false, true") {
      assert(table.drop(3).head == "false  true   false")
    }
    it("has the right value for inputs false, false") {
      assert(table.drop(4).head == "false  false  false")
    }
  }

}

// vim: set ts=2 sw=2 et:
