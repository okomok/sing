

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.nat.peano.Literal._
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

    val poly = map.sorted1(Nat.typeId, Inc).put(Boolean.typeId, Not)

    val xs = _0 :: _2 :: `true` :: _3 :: `false` :: Nil

    object Ap extends Macros.New with Function1 {
        override  def apply[x <: Any](x: x): apply[x] = poly.get(x.typeId).get.asFunction1.apply(x).asInstanceOf[apply[x]]
        override type apply[x <: Any] = poly.get[x#typeId]#get#asFunction1#apply[x]
    }


    def testTrivial() {

        `true`.typeId
        nat.peano._3.typeId
        nat.dense._3.typeId
        Nil.typeId
        (`true` :: `false` :: Nil).typeId


        val res: _1 :: _3 :: `false` :: _4 :: `true` :: Nil = xs.map(Ap).force

        val k1: _3 = res.nth(_1)
        expectResult(k1)(_3)

        val k4: `true` = res.nth(_4)

        ()
    }

}


