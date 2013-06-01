

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class FindTest extends org.scalatest.junit.JUnit3Suite {

    case class Gt3() extends Function1 {
        override type self = Gt3
        override  def apply[x <: Any](x: x): apply[x] = x.asNat gt _3
        override type apply[x <: Any] = x#asNat#gt[_3]
    }

    def testTrivial {
        type xs = _5 :: Nil
        Weak.assertSame[Some[_5], xs#find[Gt3]]
    }

}
