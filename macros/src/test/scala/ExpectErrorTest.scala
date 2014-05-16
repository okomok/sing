

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing._
import CompileError._


class ExpectErrorTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        ExpectError(NotFound) {"""
            wow
        """}
    }

    def testSelf {
        val hey = "hello" // not constant

        ExpectError(IllegalArgument) {"""
            ExpectError(hey) {"3"}
        """}
    }

}
