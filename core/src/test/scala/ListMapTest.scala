

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class ListMapTest extends org.scalatest.junit.JUnit3Suite {

    def testPut {
        type m = ListMap.put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = ListMap.put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Test.assertSame[Dense._3, m#size]

        type v8 = m#get[_8]
        val v8: v8 = m.get(_8)
        Test.assertSame[None, v8]

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        Test.assertSame[_Box[Char], v5]
        assertEquals('c', v5.unsing)
    }

    def testContains {
        type m = ListMap.put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = ListMap.put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Test.assertSame[`false`, m#contains[_9]]
        Test.assertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = ListMap.put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = ListMap.put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Test.assertSame[`false`, m#contains[_9]]
        Test.assertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type m   = ListMap.put[_3, _4]#put[_1, _2]#put[_5, _6]
        val m: m = ListMap.put(_3, _4).put(_1, _2).put(_5, _6)
        assertEquals(scala.collection.immutable.ListMap(1 -> 2, 3 -> 4, 5 -> 6), m.unsing)
    }

    def testDupePut {

        type m = ListMap.put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = ListMap.put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        Test.assertSame[_Box[Char], v5]
        assertEquals('c', v5.unsing)

        type m2 = m.put[_5, _Box[String]]
        val m2: m2 = m.put(_5, _Box("hw"))
        Test.assertSame[`true`, m2#size#equal[m#size]]
        Test.assertSame[_Box[String], m2#get[_5]#get]
        assertEquals("hw", m2.get(_5).get.unsing)
    }

}
