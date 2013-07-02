

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing.Test._
import sing.Test.CompileError._
import sing.Dense._


import scala.language.existentials


class AssertEqualTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial() {
        assertEqual(_3.plus(_2), _6.minus(_1))
        assertEqual[_3#plus[_2], _6.minus[_1]]
        place[ assertEqual[_3#plus[_2], _6.minus[_1]] ]

        expectError(AssertError) {
            assertEqual[_3, _5]
        }
    }
}

