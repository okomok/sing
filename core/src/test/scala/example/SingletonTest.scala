

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package example

    import com.github.okomok.sing
    import sing.::
    import sing.Dense.Literal._

    class Singletonest extends org.scalatest.junit.JUnit3Suite {
        // Define 0-ary dualmethod `not2`.
        final class not2 extends sing.AsFunction1 { // No meta-generics. `Function1` isn't parameterized.
            override type self = not2 // `self` is the sing version of `this` reference. Manual setup is needed.
            // Again no meta-generics. Downcast is needed as you did in 90s.
            override  def apply[x <: sing.Any](x: x): apply[x] = x.asNat.equal(_2).not
            override type apply[x <: sing.Any]                 = x#asNat#equal[_2]#not
        }
        val not2 = new not2

        def testTrivial {
            // Filter a heterogeneous List.
            val xs = _2 :: _3 :: _4 :: _2 :: _5 :: _6 :: _2 :: sing.Nil
            val ys = _3 :: _4 :: _5 :: _6 :: sing.Nil
            sing.Test.assertTrue(xs.filter(not2).equal(ys)) // checked in compile-time thanks to the singleton.
        }
    }
