

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.nat.peano.Literal._
import junit.framework.Assert._


import scala.language.existentials


class BoxTest extends org.scalatest.junit.JUnit3Suite {


    def testTrivial() {

        class MMM
        val mmm = new MMM

        val bi = Box(mmm)
        val k = Box.kindOf[MMM]
        val id = Box.kindIdOf[MMM]
        type id = weak.typeOf(id)

        weak.assertSame[bi.kindId, k.kindId]
        weak.assertSame[k.kindId, id.self] // id.type fails.
        weak.assertSame[k.kindId, id]
        weak.assertSame[id.self, bi.kindId]

        ()
    }

    def testOrdering {
        class A
        val a = new A

        val ax = Box(a)

        class B
        val b = new B

        val bx = Box(b)

        val x: `false` = ax.equal(bx)
        val y: `true` = ax.equal(ax)

    }

    def testPoly {

        val IntKind = Box.kindOf[Int]
        val StringKind = Box.kindOf[String]
        val BooleanKind = Box.kindOf[scala.Boolean]

        object c
        val cKind = Box.kindOf[c.type]

        val poly = map.sorted1(IntKind.kindId, function.lift1((x: Int) => x + 1)).
            put(StringKind.kindId, function.lift1((x: String) => x.reverse)).
            put(BooleanKind.kindId, function.lift1((x: scala.Boolean) => c))

        val xs = Box(0) :: Box("hello") :: Box(10) :: Box(true) :: Nil

        object Ap extends Macros.New with Function1 {
            override  def apply[x <: Any](x: x): apply[x] = poly.get(x.kindId).get.asFunction1.apply(x).asInstanceOf[apply[x]]
            override type apply[x <: Any] = poly.get[x#kindId]#get#asFunction1#apply[x]
        }

        val res = xs.map(Ap).force
        val a0: Int = res.nth(_0).unsing
        expectResult(1)(a0)
        val a1: String = res.nth(_1).unsing
        expectResult("olleh")(a1)
        val a2: Int = res.nth(_2).unsing
        expectResult(11)(a2)
        val a3: c.type = res.nth(_3).unsing
        expectResult(c)(a3)

    }

}


