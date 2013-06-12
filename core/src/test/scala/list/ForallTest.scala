

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class ForallTest extends org.scalatest.junit.JUnit3Suite {

    case class Gt3() extends AsFunction1 {
        override type self = Gt3
        override  def apply[x <: Any](x: x): apply[x] = x.asNat gt _3
        override type apply[x <: Any] = x#asNat#gt[_3]
    }

    def testTrivial {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val u: xs#forall[Gt3] = xs.forall(Gt3())
        Test.assertSame[`true`, xs#forall[Gt3]]
        assertEquals(`true`, u)
    }

    def testTrivialFalse {
        type xs = _5 :: _6 :: _7 :: _1 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _1 :: _9 :: Nil
        val u: xs#forall[Gt3] = xs.forall(Gt3())
        Test.assertSame[`false`, xs#forall[Gt3]]
        assertEquals(`false`, u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#forall[Gt3] = xs.forall(Gt3())
        Test.assertSame[`true`, xs#forall[Gt3]]
        assertEquals(`true`, u)
    }

}
