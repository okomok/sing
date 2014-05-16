

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing

import sing._
import sing.CompileError._
import sing.Dense._


import scala.language.existentials


class AssertEqTest extends org.scalatest.junit.JUnit3Suite {

    // Note dense provides the unique representations of nats.

    def testTrivial {
        AssertEq(_3.plus(_2), _6.minus(_1))
        AssertEq[_3#plus[_2], _6.minus[_1]]
//        place[ AssertEq[_3#plus[_2], _6.minus[_1]] ]

        ExpectError(AssertError) {"""
            AssertEq(_3, _5)
        """}
    }

    def testTrivialNot {
        AssertNeq(_3.plus(_2), _6.minus(_0))
        AssertNeq[_3#plus[_2], _6.minus[_0]]
//        place[ AssertNeq[_3#plus[_2], _6.minus[_0]] ]

        ExpectError(AssertError) {"""
            AssertNeq(_3, _3)
        """}
    }
}
