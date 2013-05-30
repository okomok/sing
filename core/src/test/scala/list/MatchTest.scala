

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok


class MatchTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        import okomok.sing._
        val Box(10.25) :: Box(false) :: Nil() = Box(10.25) :: Box(false) :: Nil
        val Box(-1.625) :: Box(x) :: Nil() = Box(-1.625) :: Box(true) :: Nil
        expectResult(true)(x)

    /* shall fail to compile.
        val Box(10) :: Box(true) :: Nil() = Box(10) :: Box('c') :: Nil
        val Box(10) :: Nil() = Box(10) :: Box(true) :: Nil
        val Box(10) :: Box(true) :: Nil() = Box(10) :: Nil
    */
    }
}
