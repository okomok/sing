

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.Peano.Literal._
import junit.framework.{Assert => JAssert}

import scala.language.existentials


class BoxParamTest extends org.scalatest.junit.JUnit3Suite {

    def testParam {
        class A[T, U]
        class B[T]

        type k = Char

/*
        StackOverflow, I don't know why.

        val x = Box(new A[B[Int], Char])
        val x_ = Box(new A[B[Int], k])
        val y = Box(new A[B[Int], Int])

        Test.assertTrue(x.equal(x_))
        Test.assertFalse(x.equal(y))
*/
    }

}


