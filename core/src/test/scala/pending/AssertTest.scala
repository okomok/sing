

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import Test._
import sing.Test.CompileError._


import scala.language.existentials


class AssertTest extends org.scalatest.junit.JUnit3Suite {

    final val badSuccess = "1"

    final val goodError = "wow"

    final val badSuccess2 = "expectError(NotFound) { goodError }"

    def testTrivial() {

        expectError(NotFound) {
            goodError
        }

        expectError(UnexpectedCompile) {"""
            // good error
            expectError(AnyError) {
                badSuccess
            }
        """}

        expectError(UnexpectedCompile) {"""
            // good error
            expectError(AnyError) {
                badSuccess2
            }
        """}

        expectError(AnyError) {"""
            error
        """}

        type no = Nothing

        val isEq_no_Nothing = isEq[no, Nothing]

        assertTrue[isEq_no_Nothing.self]

        expectError(AssertError) {"""
            val isEq_Int_Nothing = isEq[Int, Nothing]
            assertTrue[isEq_Int_Nothing.self]
        """}

        val conformes_Int_AnyVal = conforms[Int, AnyVal]

        assertTrue[conformes_Int_AnyVal.self]

        expectError(AssertError) {"""
            assertConforms[AnyVal, Int]
        """}

        val conforms_AnyVal_Int = conforms[AnyVal, Int]

        assertFalse[conforms_AnyVal_Int.self]

        expectError(AssertError) {"""
            assertFalse[conformes_Int_AnyVal.self]
        """}

        type i = Int

        val isEq_AnyVal_i = isEq[AnyVal, i]
        assertFalse[isEq_AnyVal_i.self]

        expectError(AssertError) {"""
            val isEq_i_Int = isEq[i, Int]
            assertFalse[isEq_i_Int.self]
        """}

        def foo[x <: Any](x: x) = x.asNat.plus(Dense._2)
        type foo[x <: Any] = x#asNat#plus[Dense._2]

        expectError(AbstractType) {"""
            check(foo(Nil))
        """}
/*
        expectError(AbstractType) {"""
            dummy[ check[foo[Nil]] ]
        """}
*/
        val _x = check(Some(Dense._2).get)
        val x = _x.self
        type x = _x.self //check[Some[Dense._2]#get]

        expectError(AssertError) {"""
            assertEq(Dense._3, x)
        """}

        expectError(AssertError) {"""
            assertEq[Dense._3, x]
        """}
/*
        expectError(AssertError) {"""
            place[ assertEq[Char, Int] ]
        """}
*/
        expectError(NotFound) {"""
            // dummy[ assertEq[Char, Int] ] // why not error?
            wow
        """}
/*
        expectError(AssertError) {"""
            place[ assertFalse[conforms[Int, Int]] ]
        """}
*/
        expectError(AnyError) {"""
            place[error]
        """}

        assertEq(Dense._2, x)
        assertEq[Dense._2, x]

        expectError(NothingType) {"""
            check(None.get)
        """}

        ()
    }

    def testCheck {
         def foo[x <: Nat](x: x): foo[x] = `if`(id(x).equal(Dense._2), Throw(new java.lang.Error("doh")), Const(id(x).increment)).apply
        type foo[x <: Nat]               = `if`[id[x]#equal[Dense._2], Throw                            , Const[id[x]#increment]]#apply

        val _x = check(foo(Dense._3))
        val x = _x.self
        type x = _x.self // = check[foo[Dense._3]]

        expectError(NothingType) {"""
            check(foo(Dense._2))
        """}

        expectError(NothingType) {"""
            check(dummy[foo[Dense._2]]) // Nothing
        """}

        expectError(AbstractType) {"""
            check(dummy[Nat#increment]) // abstract
        """}
    }
}

