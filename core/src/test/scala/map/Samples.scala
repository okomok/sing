

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


object Samples {
    type o = nat.naturalOrdering
    val o: o = nat.naturalOrdering

    type map_single[k <: Any, v <: Any, o <: Ordering] = map.bstree.Nil[o]#put[k, v]
    def map_single[k <: Any, v <: Any, o <: Ordering](k: k, v: v, o: o) = map.bstree.Nil(o).put(k, v)

    type m1 =    map_single[_1, Box[scala.Int], o]
    val m1: m1 = map_single(_1, Box(1), o)

    type m4 =    map_single[_4, Box[scala.Char], o]
    val m4: m4 = map_single(_4, Box('4'), o)

    type m7 =    map_single[_7, Box[String], o]
    val m7: m7 = map_single(_7, Box("seven"), o)

    type m6 =    map.bstree.Node[_6, Box[scala.Double], m4, m7]
    val m6: m6 = map.bstree.Node(_6, Box(3.4f), m4, m7)

    type m3 =    map.bstree.Node[_3, Box[scala.Boolean], m1, m6]
    val m3: m3 = map.bstree.Node(_3, Box(true), m1, m6)

    type m13 =    map_single[_13, Box[scala.Char], o]
    val m13: m13 = map_single(_13, Box('k'), o)

    type m14 =     map.bstree.Node[_14, Box[scala.Int], m13, map.bstree.Nil[o]]
    val m14: m14 = map.bstree.Node(_14, Box(14), m13, map.bstree.Nil(o))

    type m10 =     map.bstree.Node[_10, Box[String], map.bstree.Nil[o], m14]
    val m10: m10 = map.bstree.Node(_10, Box("10"), map.bstree.Nil(o), m14)

    type m8 =    map.bstree.Node[_8, Box[scala.Boolean], m3, m10]
    val m8: m8 = map.bstree.Node(_8, Box(false), m3, m10)

}

class SamplesTest extends org.scalatest.junit.JUnit3Suite {
    def testTrivial {
        AssertInvariant(Samples.m8)
    }
}
