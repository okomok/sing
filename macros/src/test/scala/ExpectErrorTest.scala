

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing.makro._
import CompileError._


class ExpectErrorTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        ExpectErrorOf(NotFound) {
            wow
        }
    }

    def testSelf {
        val hey = "hello" // not constant

        ExpectErrorOf(NotConstant) {
            ExpectErrorOf(hey) {
                3
            }
        }
    }

}
