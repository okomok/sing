

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.Peano.Literal._
import junit.framework.{Assert => JAssert}


class A[T, U]
class B[T]

class BoxParamTest extends org.scalatest.junit.JUnit3Suite {
    def testParam {
        type k = Char

/*      Compiler stack overflows. I don't know why.
        class A[T, U]
        class B[T]
*/
        val x = Box(new A[B[Int], Char])
        val x_ = Box(new A[B[Int], k])
        val y = Box(new A[B[Int], Int])

        AssertTrue(x.equal(x_))
        AssertFalse(x.equal(y))
    }

}


