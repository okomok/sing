

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.Peano.Literal._
import junit.framework.Assert._


import scala.language.existentials


class BoxTest extends org.scalatest.junit.JUnit3Suite {


    def testTrivial() {

        class MMM
        val mmm = new MMM

        val bi = Box(mmm)
        val k = Box.empty[MMM]
        type bi = typeOf(bi)
        type k = typeOf(k)

        Test.assertSame[`true`, bi#equal[k]]

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

        val IntBox = Box.empty[Int]
        val StringBox = Box.empty[String]
        val BooleanBox = Box.empty[scala.Boolean]

        object c
        val cBox = Box.empty[c.type]

        val poly = SortedMap.put(IntBox, Function.lift1((x: Int) => x + 1)).
            put(StringBox, Function.lift1((x: String) => x.reverse)).
            put(BooleanBox, Function.lift1((x: scala.Boolean) => c))

        val xs = Box(0) :: Box("hello") :: Box(10) :: Box(true) :: Nil

        object Ap extends New[Function1] {
            override  def apply[x <: Any](x: x): apply[x] = poly.get(x).get.asFunction1.apply(x).asInstanceOf[apply[x]]
            override type apply[x <: Any]                 = poly.get[x]#get#asFunction1#apply[x]
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


