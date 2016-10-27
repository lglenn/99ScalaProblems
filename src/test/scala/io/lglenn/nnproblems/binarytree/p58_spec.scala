package test.scala.io.lglenn.nnproblems.logic

import io.lglenn.nnproblems.NNPSpec
import io.lglenn.nnproblems.binarytree._

import org.scalatest._

class P58Spec extends NNPSpec {

  markup { """

  P58 (**) Generate-and-test paradigm.

  Apply the generate-and-test paradigm to construct all symmetric,
  completely balanced binary trees with a given number of nodes.

      scala> Tree.symmetricBalancedTrees(5, "x")
      res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))

  """ }

  describe("Tree.symmetricBalancedTrees") {
    it("returns a list of all symmetric completely balanced trees buildable with n nodes") {
      val a = "T(x T(x . T(x . .)) T(x T(x . .) .))";
      val b = "T(x T(x T(x . .) .) T(x . T(x . .)))";
      val result = Tree.symmetricBalancedTrees(5, "x") map (_.toString);
      result should contain only (a,b)
    }
  }

}

// vim: set ts=2 sw=2 et:
