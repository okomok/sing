

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import scala.language.existentials


class CheckTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        makro.ExpectError("(?s).*NoSuchElementException.*") {"""
            val x = check(Nil.head)
        """}
    }

}
