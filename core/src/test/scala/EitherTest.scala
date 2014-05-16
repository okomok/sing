

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
import Peano.Literal._


class EitherTest extends org.scalatest.junit.JUnit3Suite {


    def testTrivialLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        AssertTrue[s#isLeft]
        assertEquals(`true`, s.isLeft)
        AssertFalse[s#isRight]
        assertEquals(`false`, s.isRight)
    }

    def testTrivialRight {
        type s = Right[_3]
        val s: s = Right(_3)
        AssertTrue[s#isRight]
        assertEquals(`true`, s.isRight)
        AssertFalse[s#isLeft]
        assertEquals(`false`, s.isLeft)
    }


    def testUnsingLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        AssertEq[scala.Left[Int, _], s#unsing]
        assertEquals(scala.Left(3), s.unsing)
    }

    def testUnsingRight {
        type s = Right[_3]
        val s: s = Right(_3)
        AssertEq[scala.Right[_, Int], s#unsing]
        assertEquals(scala.Right(3), s.unsing)
    }


    def testMatchLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        (s: Either) match {
            case Left(a) =>
            case Right(b) => fail("doh")
        }
        ()
    }

    def testMatchRight {
        type s = Right[_3]
        val s: s = Right(_3)
        (s: Either) match {
            case Left(a) => fail("doh")
            case Right(b) =>
        }
        ()
    }


    def testGetLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        AssertEq[_3, s#get]
        val m: s#get = s.get
        assertEquals(_3, m)
    }

    def testGetRight {
        type s = Right[_3]
        val s: s = Right(_3)
        AssertEq[_3, s#get]
        val m: s#get = s.get
        assertEquals(_3, m)
    }


    def testSwapLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        AssertEq[Right[_3], s#swap]
        val m: s#swap = s.swap
        assertEquals(Right(_3), m)
    }

    def testSwapRight {
        type s = Right[_3]
        val s: s = Right(_3)
        AssertEq[Left[_3], s#swap]
        val m: s#swap = s.swap
        assertEquals(Left(_3), m)
    }


    def testJoinLeftLeft {
        type s = Left[Right[_3]]
        val s: s = Left(Right(_3))
        AssertEq[Right[_3], s#joinLeft]
        val m: s#joinLeft = s.joinLeft
        assertEquals(Right(_3), m)
    }

    def testJoinLeftRight {
        type s = Right[_3]
        val s: s = Right(_3)
        AssertEq[Right[_3], s#joinLeft]
        val m: s#joinLeft = s.joinLeft
        assertEquals(Right(_3), m)
    }

    def testJoinRightRight {
        type s = Right[Left[_3]]
        val s: s = Right(Left(_3))
        AssertEq[Left[_3], s#joinRight]
        val m: s#joinRight = s.joinRight
        assertEquals(Left(_3), m)
    }

    def testJoinRightLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        AssertEq[Left[_3], s#joinRight]
        val m: s#joinRight = s.joinRight
        assertEquals(Left(_3), m)
    }


    case class Plus1() extends AsFunction1 {
        override type self = Plus1
        override def apply[n <: Any](n: n): apply[n] = n.asNat.increment
        override type apply[n <: Any] = n#asNat#increment
    }

    case class Plus2() extends AsFunction1 {
        override type self = Plus2
        override def apply[n <: Any](n: n): apply[n] = n.asNat.increment.increment
        override type apply[n <: Any] = n#asNat#increment#increment
    }

    def testFoldLeft {
        type s = Left[_3]
        val s: s = Left(_3)
        AssertEq[_4, s#fold[Plus1, Plus2]]
        val m: s#fold[Plus1, Plus2] = s.fold(Plus1(), Plus2())
        assertEquals(_4, m)
    }

    def testFoldRight {
        type s = Right[_3]
        val s: s = Right(_3)
        AssertEq[_5, s#fold[Plus1, Plus2]]
        val m: s#fold[Plus1, Plus2] = s.fold(Plus1(), Plus2())
        assertEquals(_5, m)
    }

}
