

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing._

import CompileError._
import Dense._


import scala.language.existentials


class AssertEqualTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        AssertEqual(_3.plus(_2), _6.minus(_1))
//        AssertEqual[_3#plus[_2], _6.minus[_1]]
//        place[ AssertEqual[_3#plus[_2], _6.minus[_1]] ]

        ExpectError(AssertError) {"""
            AssertEqual(_3, _5)
        """}
    }

    def testTrivialNot {
        AssertNequal(_3.plus(_2), _6.minus(_0))
//        AssertNequal[_3#plus[_2], _6.minus[_0]]
//        place[ AssertNequal[_3#plus[_2], _6.minus[_0]] ]

        ExpectError(AssertError) {"""
            AssertNequal(_3, _3)
        """}
    }
}
