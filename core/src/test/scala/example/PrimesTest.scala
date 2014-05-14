

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest.example

import com.github.okomok.sing._
import Dense._

class PrimesTest extends org.scalatest.junit.JUnit3Suite {

    final class Sieve extends AsFunction1 {
        override type self = Sieve
        override  def apply[ns <: Any](ns: ns): apply[ns] = ns.asList.tail.filter(NonDiv(ns.asList.head.asNat))
        override type apply[ns <: Any]                    = ns#asList#tail#filter[NonDiv[ns#asList#head#asNat]]
    }
    val Sieve: Sieve = new Sieve

    final case class NonDiv[n <: Nat](n: n) extends AsFunction1 {
        override type self = NonDiv[n]
        override  def apply[x <: Any](x: x): apply[x] = x.asNat.rem(n).nequal(_0)
        override type apply[x <: Any]                 = x#asNat#rem[n]#nequal[_0]
    }

    final class Head extends AsFunction1 {
        override type self = Head
        override  def apply[x <: Any](x: x): apply[x] = x.asList.head
        override type apply[x <: Any]                 = x#asList#head
    }
    val Head: Head = new Head

     val primes: primes = List.iterate( List.rangeFrom(_2), Sieve ).map(Head)
    type primes         = List.iterate[ List.rangeFrom[_2], Sieve ]#map[Head]

    def testMe {
         val some: some = primes.take(_10).force
        type some       = primes#take[_10]#force

        Test.assertEq(some, _2 :: _3 :: _5 :: _7 :: _11 :: _13 :: _17 :: _19 :: _23 :: _29 :: Nil)
        Test.assertEq[some, _2 :: _3 :: _5 :: _7 :: _11 :: _13 :: _17 :: _19 :: _23 :: _29 :: Nil]
    }

    def testBench {
//        makro.Benchmark { dummy[primes#take[_10]#force] } // memoized (nearly 0msec)
//        makro.Benchmark { dummy[primes#take[_12]#force] } // about 4000msec
    }
}
