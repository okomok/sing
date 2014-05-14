

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singtest


import com.github.okomok.sing._
import Dense._


object EnsureTestImpl {

    class IsZero extends AsFunction1 {
        override type self = IsZero
        override  def apply[x <: Any](x: x): apply[x] = x.equal(Zero)
        override type apply[x <: Any]                 = x#equal[Zero]
    }
    val IsZero: IsZero = new IsZero

    class ShallBeZero
    val ShallBeZero : ShallBeZero = new ShallBeZero

     def assertZero[n <: Nat](n: n): assertZero[n] = Ensure(n, IsZero, ShallBeZero).apply
    type assertZero[n <: Nat]                      = Ensure[n, IsZero, ShallBeZero]#apply
}


class EnsureTest extends org.scalatest.junit.JUnit3Suite {

    import EnsureTestImpl._

    def testTrivial {
        type res1 = assertZero[Zero]
//    type res2 = assertZero[_3]
    }
}
