

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._


class TrivialTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testAt = {
        val i = new java.lang.Integer(10)
        val lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil
        val a1: _Box[Int] = lst.nth(_0)
        assertEquals(3, a1.unsing)
        val a2: _Box[String] = lst.nth(_1)
        assertEquals("hello", a2.unsing)
        val a3: _Box[java.lang.Integer] = lst.nth(_2)
        assertSame(i, a3.unsing)
        val a4: _Box[Char] = lst.nth(_3)
        assertEquals('a', a4.unsing)
        assertEquals(10, lst.nth(_2).unsing.intValue)
    }

    def testSize {
        val i = new java.lang.Integer(10)
        val lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil
        okomok.sing.assert(_4 equal lst.length)
        okomok.sing.assert(Nil.length equal _0)
    }

    def testTypeErase {
        val i = new java.lang.Integer(10)
        val lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil
        assertEquals("sing.List()", Nil.toString)
        assertEquals("sing.List(3, hello, 10, a)", lst.toString)
    }

    def testEquals {
        val i = new java.lang.Integer(10)
        val j = new java.lang.Integer(10)
        assertEquals(i, j)
        val lst1 = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil
        val lst2 = _Box(3) :: _Box("hello") :: _Box(j) :: _Box('a') :: Nil
        val lst3 = _Box(3) :: _Box("hello") :: _Box('b') :: Nil
        val lst4 = _Box(2) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil
        val lst5 = Nil
        assertEquals(lst1, lst2)
        AssertNotEquals(lst1, lst3)
        AssertNotEquals(lst1, lst4)
        assertEquals(lst5, lst5)
        AssertNotEquals(lst1, lst5)
    }

    def testIsEmpty {
        okomok.sing.assert(Nil.isEmpty)
        assertNot((_Box(3) :: _Box("hello") :: Nil).isEmpty)
    }
/*
    def testTyped {
        import mada.sequence
        val i = new java.lang.Integer(10)
        val el: sequence.List[Any] = 3 :: "hello" :: i :: 'a' :: sequence.Nil.of[Any]
        val tl = 3 :: "hello" :: i :: 'a' :: Nil
        assertEquals(tl, list.typed[Int :: String :: java.lang.Integer :: Char :: Nil](el))
        assertEquals(Nil, list.typed[Nil](sequence.Nil))
        ()
    }
*/
    def testPrepend {
        val i = new java.lang.Integer(10)
        val lst1 = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val lst2 = _Box("wow") :: _Box(99) :: Nil
        assertEquals(_Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: _Box("wow") :: _Box(99) :: Nil, lst1 append lst2)
        assertEquals(Nil append Nil, Nil)
        assertEquals(lst1 append Nil, _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil)
        assertEquals(Nil append lst1, _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil)
        val k: _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil = ((_Box(3) :: _Box("hello") :: Nil) append (_Box(i) :: Nil) append (_Box('a') :: _Box(12) :: Nil) append Nil).force
        assertEquals(lst1, k)
    }

    /*
    def testReversePrepend {
        val i = new java.lang.Integer(10)
        type Lst1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        type Lst2 = _Box[String] :: _Box[Int] :: Nil
        val lst1: Lst1 = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val lst2: Lst2 = _Box("wow") :: _Box(99) :: Nil

        val lst12: Lst1 reverse_::: Lst2 = lst1 reverse_::: lst2
        assertEquals(_Box(12) :: _Box('a') :: _Box(i) :: _Box("hello") :: _Box(3) :: _Box("wow") :: _Box(99) :: Nil, lst12)
        assertEquals(Nil reverse_::: Nil, Nil)
        assertEquals(lst1 reverse_::: Nil, _Box(12) :: _Box('a') :: _Box(i) :: _Box("hello") :: _Box(3)  :: Nil)
        assertEquals(Nil reverse_::: lst1, _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil)
        val k: _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil = (_Box("hello") :: _Box(3) :: Nil) reverse_::: (_Box(i) :: Nil) reverse_::: (_Box(12) :: _Box('a') :: Nil) reverse_::: Nil
        assertEquals(lst1, k)
        ()
    }*/

    def testReverse {
        val i = new java.lang.Integer(10)
        type Lst1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val lst1: Lst1 = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val lst1r: Lst1#reverse = lst1.reverse
        val lst1r_ : _Box[Int] :: _Box[Char] :: _Box[java.lang.Integer] :: _Box[String] :: _Box[Int] :: Nil = lst1r.force
        assertEquals(_Box(12) :: _Box('a') :: _Box(i) :: _Box("hello") :: _Box(3) :: Nil, lst1r)
        assertEquals(Nil.reverse, Nil)
    }
}


object TrivialTezt {
    import Weak.{ assert, assertSame }

    trait testAt {
        type lst = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: Nil
        assertSame[lst#nth[_0], _Box[Int]]
        assertSame[lst#nth[_1], _Box[String]]
        assertSame[lst#nth[_2], _Box[Double]]
        assertSame[lst#nth[_3], _Box[Char]]
        assertSame[lst#nth[_2#plus[_1]], _Box[Char]]
    }

    trait testSize {
        type lst = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: Nil
        assert[lst#length# equal[_4]]
        assert[Nil#length# equal[_0]]
    }

    trait testIsEmpty {
        type lst = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: Nil
        assertSame[Nil#isEmpty, `true`]
        assertSame[lst#isEmpty, `false`]
    }

    trait testPrepend {
        type lst1 = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil
        type lst2 = _Box[Boolean] :: _Box[Byte] :: Nil
        assertSame[Nil, Nil# append[Nil]#force]
        assertSame[_Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: _Box[Boolean] :: _Box[Byte] :: Nil, lst1# append[lst2]#force]
        assertSame[lst1, lst1# append[Nil]#force]
        assertSame[lst1, Nil# append[lst1]#force]
/*
        assertSame[Nil, (Nil ++ Nil)#force]
        assertSame[_Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: _Box[Boolean] :: _Box[Byte] :: Nil, (lst1 ++ lst2)#force]
        assertSame[lst1, (lst1 ++ Nil)#force]
        assertSame[lst1, (Nil ++ lst1)#force]
        assertSame[lst1, ((_Box[Int] :: _Box[String] :: Nil) ++ (_Box[Double] :: Nil) ++ (_Box[Char] :: _Box[Float] :: Nil) ++ Nil)#force]
*/
    }

    type prependprepend[l1 <: List, l2 <: List, r <: List] = l2# append[l1]# append[r]#force

    trait testPrepend2 {
        type lst1 = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil
        type lst2 = _Box[Boolean] :: _Box[Byte] :: Nil
        type lst3 = _Box[Char] :: _Box[String] :: Nil
        type r = prependprepend[lst2, lst3, lst1]
        assertSame[_Box[Char] :: _Box[String] :: _Box[Boolean] :: _Box[Byte] :: _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil, r]
    }
}
