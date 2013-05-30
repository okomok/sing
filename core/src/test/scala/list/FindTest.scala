

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class FindTest extends org.scalatest.junit.JUnit3Suite {

    case class Gt3() extends Function1 {
        override type self = Gt3
        override  def apply[x <: Any](x: x): apply[x] = x.asNat gt _3
        override type apply[x <: Any] = x#asNat#gt[_3]
    }

    def testTrivial {
        type xs = _5 :: Nil
        free.assertSame[Some[_5], xs#find[Gt3]]
    }

}
