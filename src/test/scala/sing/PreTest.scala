

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._
import nat.peano.Literal._


class PreTest extends org.scalatest.junit.JUnit3Suite {

    class LengthMust3[xs <: List](xs: xs)(implicit k: Pre[xs#length#equal[_3]])

    def testTrivial {
  //      val k = new LengthMust3(_1 :: _2 :: _3 :: _4 :: Nil)
        val k = new LengthMust3(_2 :: _3 :: _4 :: Nil)
        ()
    }
}
