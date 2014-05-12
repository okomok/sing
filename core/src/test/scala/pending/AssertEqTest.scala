

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing.Test._
import sing.Test.CompileError._
import sing.Dense._


import scala.language.existentials


class AssertEqTest extends org.scalatest.junit.JUnit3Suite {

    // Note dense provides the unique representations of nats.

    def testTrivial {
        assertEq(_3.plus(_2), _6.minus(_1))
        assertEq[_3#plus[_2], _6.minus[_1]]
//        place[ assertEq[_3#plus[_2], _6.minus[_1]] ]

        expectError(AssertError) {"""
            assertEq(_3, _5)
        """}
    }

    def testTrivialNot {
        assertNeq(_3.plus(_2), _6.minus(_0))
        assertNeq[_3#plus[_2], _6.minus[_0]]
//        place[ assertNeq[_3#plus[_2], _6.minus[_0]] ]

        expectError(AssertError) {"""
            assertNeq(_3, _3)
        """}
    }
}
