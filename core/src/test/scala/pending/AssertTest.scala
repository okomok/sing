

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._


import scala.language.existentials


class AssertTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial() {

        assertError {
            // good error
            woo
        }

        assertError {
            // good error
            assertError {
                // bad success
                1
            }
        }

        assertError {
            // good error
            assertError {
                // bad success
                assertError {
                    // good error
                    wow
                }
            }
        }
    }
}


