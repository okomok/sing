

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


object Samples {
    type o = Nat.naturalOrdering
    val o: o = Nat.naturalOrdering

    type map_single[k <: Any, v <: Any, o <: Ordering] = BSNil[o]#put[k, v]
    def map_single[k <: Any, v <: Any, o <: Ordering](k: k, v: v, o: o) = BSNil(o).put(k, v)

    type m1 =    map_single[_1, _Box[scala.Int], o]
    val m1: m1 = map_single(_1, _Box(1), o)

    type m4 =    map_single[_4, _Box[scala.Char], o]
    val m4: m4 = map_single(_4, _Box('4'), o)

    type m7 =    map_single[_7, _Box[String], o]
    val m7: m7 = map_single(_7, _Box("seven"), o)

    type m6 =    BSNode[_6, _Box[scala.Double], m4, m7]
    val m6: m6 = BSNode(_6, _Box(3.4f), m4, m7)

    type m3 =    BSNode[_3, _Box[scala.Boolean], m1, m6]
    val m3: m3 = BSNode(_3, _Box(true), m1, m6)

    type m13 =    map_single[_13, _Box[scala.Char], o]
    val m13: m13 = map_single(_13, _Box('k'), o)

    type m14 =     BSNode[_14, _Box[scala.Int], m13, BSNil[o]]
    val m14: m14 = BSNode(_14, _Box(14), m13, BSNil(o))

    type m10 =     BSNode[_10, _Box[String], BSNil[o], m14]
    val m10: m10 = BSNode(_10, _Box("10"), BSNil(o), m14)

    type m8 =    BSNode[_8, _Box[scala.Boolean], m3, m10]
    val m8: m8 = BSNode(_8, _Box(false), m3, m10)

}

class SamplesTest extends org.scalatest.junit.JUnit3Suite {
    def testTrivial {
        AssertInvariant(Samples.m8)
    }
}
