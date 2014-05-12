

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing.makro._
import junit.framework.Assert._
import sing.Test
import sing.Test.CompileError._


import scala.language.existentials


class ConstantTypeTest extends org.scalatest.junit.JUnit3Suite {

    def testInt {
        type ct = ConstantTypeOf.apply(3)

        val x: ct = 3
        Test.expectError(TypeMismatch) {
            val x: ct = 4
        }

        val c: Int = ConstantTermOf.apply[ct]
        assertEquals(c, 3)
    }

    def testString {
        type ct = ConstantTypeOf.apply("he" + "llo")
        val c: String = ConstantTermOf.apply[ct]

        val x: ct = "hello"
        Test.expectError(TypeMismatch) {
            val x: ct = "hi"
        }

        assertEquals(c, "hello")
    }

    def testIntExpr {
        type ct = ConstantTypeOf.apply(1+2)

        val x: ct = 3
        Test.expectError(TypeMismatch) {
            val x: ct = 4
        }

        val c: Int = ConstantTermOf.apply[ct]
        assertEquals(c, 3)
    }

    final val THREE = 3

    def testSmart {
        type ct = ConstantTypeOf.apply(1+2 == THREE)
        val x: ct = true

        Test.expectError(TypeMismatch) {
            val x: ct = false
        }

        // Test.echo[ct]

        val c: Boolean = ConstantTermOf.apply[ct]
        assertEquals(true, c)
    }

}

