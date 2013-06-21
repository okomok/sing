

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

        cassertNothing[no]

        expectError {
            cassertNothing[Int]
        }

        cassert[conforms[Int, AnyVal]]

        expectError {
            assertConforms[AnyVal, Int]
        }

        cassertNot[conforms[AnyVal, Int]]

        expectError {
            assertNot[conforms[Int, AnyVal]]
        }

        type i = Int

        cassertNot[isSame[AnyVal, i]]

        expectError {
            cassertNot[isSame[i, Int]]
        }

        def foo[x <: Any](x: x) = x.asNat.plus(Dense._2)
        type foo[x <: Any] = x#asNat#plus[Dense._2]

        expectError {
            check(foo(Nil))
        }

        expectError {
            dummy[ check[foo[Nil]] ]
        }

        val x: x = check(Some(Dense._2).get)
        type x   = check[Some[Dense._2]#get]

        expectError {
            cassertSame(Dense._3, x)
        }
        expectError {
            cassertSame[Dense._3, x]
        }


        expectError {
            ignore[ cassertSame[Char, Int] ]
        }


        expectError {
            // dummy[ cassertSame[Char, Int] ] // compiles, funny.
            wow
        }

        expectError {
            ignore[ cassertNot[conforms[Int, Int]] ]
        }

        expectError {
            ignore[error]
        }

        cassertSame(Dense._2, x)
        cassertSame[Dense._2, x]

        expectError {
            check(None.get)
        }

        ()
    }

    def testNull {
         def foo[x <: Nat](x: x): foo[x] = `if`(id(x).equal(Dense._2), Throw(new java.lang.Error("doh")), Const(id(x).increment)).apply
        type foo[x <: Nat]               = `if`[id[x]#equal[Dense._2], Throw                            , Const[id[x]#increment]]#apply

        val x: x = check(foo(Dense._3))
        type x   = check[foo[Dense._3]]

        expectError {
            check(foo(Dense._2))
        }

        expectError {
            check(ignore[foo[Dense._2]])
        }
    }
}

