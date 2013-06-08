

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

        def foo[x <: Any](x: x) = x.asNat.plus(Dense._2)
        type foo[x <: Any] = x#asNat#plus[Dense._2]

        expectError {
            check(foo(Nil))
        }

        expectError {
            unused[ check[foo[Nil]] ]
        }

        val x: x = check(Some(Dense._2).get)
        type x   = check[Some[Dense._2]#get]

        expectError {
            assertSame(Dense._3, x)
        }
        expectError {
            assertSame[Dense._3, x]
        }

/*
        expectError {
            unused[ assertSame[Char, Int] ] // hmm compiles... macro version is better?
        }
*/
        expectError {
            unused[ assertNotConforms[Int, Int] ]
        }

        expectError {
            unused[error]
        }

        assertSame(Dense._2, x)
        assertSame[Dense._2, x]

        expectError {
            check(None.get)
        }

        ()
    }
}

