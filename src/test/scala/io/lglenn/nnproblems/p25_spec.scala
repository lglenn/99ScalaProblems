package io.lglenn.nnproblems

import org.scalatest._
import scala.Stream._

class P25Spec extends NNPSpec {

  markup { """

  P25 (*) Generate a random permutation of the elements of a list.
  Hint: Use the solution of problem P23.

  Example:

    scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
    res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

  """ }

  val raw = List('a, 'b, 'c, 'd, 'e, 'f);

  def containsUniqueValues[A](l: List[A]): Boolean = l match {
    case Nil => true
    case x :: xs => if(xs.contains(x)) false else containsUniqueValues(xs)
  }

  def generate(f: () => Option[String]): Stream[Option[String]] = cons(f(),generate(f))

  describe("randomPermute") {
    it("returns a list of the same length as the input list") {
      assert(P25.randomPermute(raw).size == raw.size)
    }
    it("contains only elements from the input list") {
      val result = P25.randomPermute(raw) map { e => raw.contains(e) } reduce { _ && _ }
      assert(result)
    }
    it("only draws an element from the input list once") {
      val test = () => {
        val l = P25.randomPermute(raw);
        if(containsUniqueValues(l)) None else Some(l + " does not contain unique values");
      }
      generate(test).take(100).find(_.isDefined).flatten match {
        case None => assert(true)
        case Some(reason) => assert(false,reason)
      }
    }
  }

}

// vim: set ts=2 sw=2 et:
