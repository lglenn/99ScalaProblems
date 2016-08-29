package io.lglenn.nnproblems

object FM {

  // for i < j < n, calculate all m such that m = i + j and m is divisible by p

  // make a list of all j's, then for each j, pair it with all i such that 1 <= i < j

  def basic(n: Int,p: Int): List[(Int,Int)] = {
    val pairs = List.range(1,n) map { j => List.range(1,j) map { i => (i,j) } }
    val flattened = pairs.foldRight(List[(Int,Int)]()) { (c,a) => c ::: a }
    flattened.filter { case (a,b) => (a + b) % p == 0 }
  }

  def fm(n: Int, p: Int): List[(Int,Int)] = {
    val pairs = List.range(1,n) flatMap { j => List.range(1,j) map { i => (i,j) } }
    pairs.filter { case (a,b) => (a + b) % p == 0 }
  }

  def comp(n: Int, p: Int): List[(Int,Int)] = {
    for {
      j <- List.range(1,n)
      i <- List.range(1,j)
      if (i + j) % p == 0
    } yield (i,j)
  }
  
}

// vim: set ts=2 sw=2 et:
