

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest


// See: http://apocalisp.wordpress.com/2010/10/15/type-level-programming-in-scala-part-6e-hlist%C2%A0apply/


import com.github.okomok
import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class LiftTest extends org.scalatest.junit.JUnit3Suite {

    // Define sing `Function2`.
    object Apply extends Function2 {
        override type self = Apply.type
        override  def apply[f <: Any, x <: Any](f: f, x: x): apply[f, x] = f.asFunction1.apply(x)
        override type apply[f <: Any, x <: Any]                          = f#asFunction1#apply[x]
    }

    def testTrivial {
        // Normal types are not first-class citizen in sing world.
        // `Box` turns them into sing ones.
        val y1 = 9.75 #:: 'x' #:: Nil // == Box(9.75) :: Box('x') :: Nil
        val y2 = -2.125 #:: 'X' #:: Nil

        // `Function` too is a kind of boxing, which turns a normal function into sing one.
        val z = Function((_: Double) + .5) :: Function((_: Char).isUpper) :: Nil

        // `zipBy` returns a view(unspecified type). `force` turns a view into a concrete list.
        val z1: Box[scala.Double] :: Box[scala.Boolean] :: Nil = z.zipBy(y1, Apply).force
        val Box(10.25) :: Box(false) :: Nil() = z1

        val z2: Box[scala.Double] :: Box[scala.Boolean] :: Nil = z.zipBy(y2, Apply).force
        val Box(-1.625) :: Box(true) :: Nil() = z2

        locally {
            // escape from the sing world using `unsing`.
            val :: = scala.::
            val 10.25 :: false :: scala.Nil = z1.unsing
            val -1.625 :: true :: scala.Nil = z2.unsing
        }
    }

    def testTrivial2 {
        val y1 = 9.75 #:: 'x' #:: Nil
        val z = Function((_: Double) + .5) :: Box(3) :: Nil
        z.zipBy(y1, Apply) // doesn't crash for now, because this is a view...
        ()
    }

}
