

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing._
import scala.reflect.macros.TypecheckException
import junit.framework.Assert._


class TryTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial() {
        val x: Int = Try("wow") {
            case e: TypecheckException => 1
        }

        assertEquals(x, 1)
    }
}
