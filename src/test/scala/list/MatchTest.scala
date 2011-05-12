

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok
import okomok.sing._


class MatchTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val Box(10.25) :: Box(false) :: Nil() = Box(10.25) :: Box(false) :: Nil
        val Box(-1.625) :: Box(true) :: Nil() = Box(-1.625) :: Box(true) :: Nil

        intercept[scala.MatchError] {
            val Box(10.25) :: Box(false) :: Nil() = Box(10.25) :: Box(false) :: Box('c') :: Nil
        }
    }
}
