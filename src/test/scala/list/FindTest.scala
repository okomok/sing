

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


object _Find {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] = toOption(xs.dropWhile(f.not))
    type apply[xs <: List, f <: Function1]                             = toOption[xs#dropWhile[f#not]]

     def toOption[ys <: List](ys: ys): toOption[ys] =
        `if`(ys.isEmpty, const0(None), Else(ys)).apply.asOption.asInstanceOf[toOption[ys]]
    type toOption[ys <: List] =
        `if`[ys#isEmpty, const0[None], Else[ys]]#apply#asOption

    case class Else[ys <: List](ys: ys) extends Function0 {
        type self = Else[ys]
        override  def apply: apply = Some(ys.head)
        override type apply        = Some[ys#head]
    }
}

class FindTest extends org.scalatest.junit.JUnit3Suite {

    case class Gt3() extends Function1 {
        override type self = Gt3
        override  def apply[x <: Any](x: x): apply[x] = x.asNat gt _3
        override type apply[x <: Any] = x#asNat#gt[_3]
    }

    def testTrivial {
        type xs = _5 :: Nil
        free.assertSame[Some[_5], _Find.apply[xs#self, Gt3]]
        free.assertSame[Some[_5], xs#find[Gt3]]
    }


}
