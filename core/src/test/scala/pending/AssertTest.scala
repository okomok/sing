

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

        cassert[isEq[no, Nothing]]

        expectError {
            cassert[isEq[Int, Nothing]]
        }

        cassert[conforms[Int, AnyVal]]

        expectError {
            cassertConforms[AnyVal, Int]
        }

        cassertNot[conforms[AnyVal, Int]]

        expectError {
            assertNot[conforms[Int, AnyVal]]
        }

        type i = Int

        cassertNot[isEq[AnyVal, i]]

        expectError {
            cassertNot[isEq[i, Int]]
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
            cassertEq(Dense._3, x)
        }
        expectError {
            cassertEq[Dense._3, x]
        }


        expectError {
            ignore[ cassertEq[Char, Int] ]
        }

        expectError {
            // dummy[ cassertEq[Char, Int] ] // why not error?
            wow
        }

        expectError {
            ignore[ cassertNot[conforms[Int, Int]] ]
        }

        expectError {
            ignore[error]
        }

        cassertEq(Dense._2, x)
        cassertEq[Dense._2, x]

        expectError {
            check(None.get)
        }

        ()
    }

    def testCheck {
         def foo[x <: Nat](x: x): foo[x] = `if`(id(x).equal(Dense._2), Throw(new java.lang.Error("doh")), Const(id(x).increment)).apply
        type foo[x <: Nat]               = `if`[id[x]#equal[Dense._2], Throw                            , Const[id[x]#increment]]#apply

        val x: x = check(foo(Dense._3))
        type x   = check[foo[Dense._3]]

        expectError {
            check(foo(Dense._2))
        }

        expectError {
            check(dummy[foo[Dense._2]]) // Nothing
        }

        expectError {
            check(dummy[Nat#increment]) // abstract
        }
    }
}

