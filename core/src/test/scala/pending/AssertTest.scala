

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import Test._


import scala.language.existentials


class AssertTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial() {

        expectError {
            // good error
            woo
        }

        expectError {
            // good error
            expectError {
                // bad success
                1
            }
        }

        expectError {
            // good error
            expectError {
                // bad success
                expectError {
                    // good error
                    wow
                }
            }
        }

        expectError {
            error
        }

        type no = Nothing

        assertNotNothing[Int]

        expectError {
            assertNotNothing[no]
        }

        assertNothing[no]

        expectError {
            assertNothing[Int]
        }

        assertConforms[Int, AnyVal]

        expectError {
            assertConforms[AnyVal, Int]
        }

        assertNotConforms[AnyVal, Int]

        expectError {
            assertNotConforms[Int, AnyVal]
        }

        type i = Int

        assertNotSame[AnyVal, i]

        expectError {
            assertNotSame[i, Int]
        }

        def foo[x <: Any](x: x)/*: foo[x]*/ = x.asNat.plus(Dense._2)
        type foo[x <: Any] = x#asNat#plus[Dense._2]

        expectError {
            makro_.Check {
                foo(Nil)
            }
        }

        type t = makro_.CheckType.apply[foo[Nil]]

        val ret = makro_.CheckTerm(foo(Nil))
        ()
    }
}


