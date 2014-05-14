

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok


class MatchTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        import okomok.sing._
        val _Box(10.25) :: _Box(false) :: Nil() = _Box(10.25) :: _Box(false) :: Nil
        val _Box(-1.625) :: _Box(x) :: Nil() = _Box(-1.625) :: _Box(true) :: Nil
        assertResult(true)(x)

    /* shall fail to compile.
        val _Box(10) :: _Box(true) :: Nil() = _Box(10) :: _Box('c') :: Nil
        val _Box(10) :: Nil() = _Box(10) :: _Box(true) :: Nil
        val _Box(10) :: _Box(true) :: Nil() = _Box(10) :: Nil
    */
    }
}
