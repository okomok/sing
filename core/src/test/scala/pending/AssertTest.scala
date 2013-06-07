

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import sing.makro._
import junit.framework.Assert._
import sing.Dense.Literal._


import scala.language.existentials


class AssertTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial() {

        AssertError {
            // good error
            woo
        }

        AssertError {
            // good error
            AssertError {
                // bad success
                1
            }
        }

        AssertError {
            // good error
            AssertError {
                // bad success
                AssertError {
                    // good error
                    wow
                }
            }
        }
    }
}


