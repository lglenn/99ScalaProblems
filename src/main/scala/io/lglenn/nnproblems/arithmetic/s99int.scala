package io.lglenn.nnproblems.arithmetic     

import scala.Stream
import scala.math.sqrt
import S99Int._
import io.lglenn.nnproblems.P10

class S99Int(val start: Int) {

  override def toString = start.toString

  def isPrime: Boolean = (start > 1 ) && (primes.takeWhile { _ <= sqrt(start) } forall { start % _ != 0 });

  def isCoprimeTo(other: Int): Boolean = gcd(start,other) == 1

  def totient: Int = (1 to start).filter( _.isCoprimeTo(start)).takeWhile(_ <= start).length

  def primeFactors: List[Int] = (2 to start / 2) filter (start % _ == 0) filter (_.isPrime) toList

  def primeFactorMultiplicity: List[(Int,Int)] = {
    def myPFM(n: Int): List[Int] = {
      if (n == 1) Nil
      else {
        val p = primes.filter(n % _ == 0).head
        p :: myPFM(n / p)
      }
    }
    P10.encode(myPFM(start)) map ((e) => (e._2,e._1))
  }

}

object S99Int {

  implicit def int2S99Int(i: Int): S99Int = new S99Int(i);

  val primes = Stream.cons(2,Stream.from(3,2) filter { _.isPrime });

  def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b,a % b); 

}


// vim: set ts=2 sw=2 et:
