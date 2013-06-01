

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.Peano.Literal._
import junit.framework.Assert._


class PolyFunctionTest extends org.scalatest.junit.JUnit3Suite {


    object Inc extends Macros.New with Function1 {
        override  def apply[x <: Any](x: x): apply[x] = x.asNat.increment
        override type apply[x <: Any] = x#asNat#increment
    }

    object Not extends Macros.New with Function1 {
        override  def apply[x <: Any](x: x): apply[x] = x.asBoolean.not
        override type apply[x <: Any] = x#asBoolean#not
    }

    val poly = Map.sorted1(Nat.kindId, Inc).put(Boolean.kindId, Not)

    val xs = _0 :: _2 :: `true` :: _3 :: `false` :: Nil

    object Ap extends Macros.New with Function1 {
        override  def apply[x <: Any](x: x): apply[x] = poly.get(x.kindId).get.asFunction1.apply(x).asInstanceOf[apply[x]]
        override type apply[x <: Any] = poly.get[x#kindId]#get#asFunction1#apply[x]
    }


    def testTrivial() {

        `true`.kindId
        Peano._3.kindId
        Dense._3.kindId
        Nil.kindId
        (`true` :: `false` :: Nil).kindId


        val res: _1 :: _3 :: `false` :: _4 :: `true` :: Nil = xs.map(Ap).force

        val k1: _3 = res.nth(_1)
        expectResult(k1)(_3)

        val k4: `true` = res.nth(_4)

        ()
    }

}


