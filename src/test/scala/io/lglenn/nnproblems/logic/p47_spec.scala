package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.logic.S99Logic
import io.lglenn.nnproblems.logic.S99Logic._

import org.scalatest._

class P47Spec extends NNPSpec {

  markup { """

  P47 (*) Truth tables for logical expressions (2).

  Continue problem P46 by redefining and, or, etc as operators. (i.e. make them
  methods of a new class with an implicit conversion from Boolean.) not will have
  to be left as a object method.

      scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
      A     B     result
      true  true  true
      true  false true
      false true  false
      false false false

  """ }

  describe("and") {
    it("is true for true true") {
      assert(true and true)
    }
    it("is false for true false") {
      assert(!(true and false))
    }
    it("is false for false true") {
      assert(!(false and true))
    }
    it("is false for false false") {
      assert(!(false and false))
    }
  }

  describe("or") {
    it("is true for true true") {
      assert((true or true))
    }
    it("is true for true false") {
      assert((true or false))
    }
    it("is true for false true") {
      assert((false or true))
    }
    it("is false for false false") {
      assert(!(false or false))
    }
  }

  describe("nand") {
    it("is false for true true") {
      assert(!(true nand true))
    }
    it("is true for true false") {
      assert((true nand false))
    }
    it("is true for false true") {
      assert((false nand true))
    }
    it("is true for false false") {
      assert((false nand false))
    }
  }

  describe("nor") {
    it("is false for true true") {
      assert(!(true nor true))
    }
    it("is false for true false") {
      assert(!(true nor false))
    }
    it("is false for false true") {
      assert(!(false nor true))
    }
    it("is true for false false") {
      assert((false nor false))
    }
  }

  describe("xor") {
    it("is false for true true") {
      assert(!(true xor true))
    }
    it("is true for true false") {
      assert((true xor false))
    }
    it("is true for false true") {
      assert((false xor true))
    }
    it("is false for false false") {
      assert(!(false xor false))
    }
  }

  describe("impl") {
    it("is true for true true") {
      assert((true impl true))
    }
    it("is false for true false") {
      assert(!(true impl false))
    }
    it("is true for false true") {
      assert((false impl true))
    }
    it("is true for false false") {
      assert((false impl false))
    }
  }

  describe("equ") {
    it("is true for true true") {
      assert((true equ true))
    }
    it("is false for true false") {
      assert(!(true equ false))
    }
    it("is false for false true") {
      assert(!(false equ true))
    }
    it("is true for false false") {
      assert((false equ false))
    }
  }

}

// vim: set ts=2 sw=2 et:
