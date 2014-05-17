

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._

import sing.CompileError._


import scala.language.existentials


class AssertTest extends org.scalatest.junit.JUnit3Suite {

    final val badSuccess = "1"

    final val goodError = "wow"

    final val badSuccess2 = "ExpectError(NotFound) { goodError }"

    def testTrivial() {

        ExpectError(NotFound) {
            goodError
        }

        ExpectError(UnexpectedCompile) {"""
            // good error
            ExpectError(AnyError) {
                badSuccess
            }
        """}

        ExpectError(UnexpectedCompile) {"""
            // good error
            ExpectError(AnyError) {
                badSuccess2
            }
        """}

        ExpectError(AnyError) {"""
            Error()
        """}

        type no = Nothing

        val isEq_no_Nothing = IsEq[no, Nothing]

        AssertTrue[isEq_no_Nothing.unwrap]

        ExpectError(AssertError) {"""
            val isEq_Int_Nothing = IsEq[Int, Nothing]
            AssertTrue[isEq_Int_Nothing.unwrap]
        """}

        val conformes_Int_AnyVal = Conforms[Int, AnyVal]

        AssertTrue[conformes_Int_AnyVal.unwrap]

        ExpectError(AssertError) {"""
            AssertConforms[AnyVal, Int]
        """}

        val conforms_AnyVal_Int = Conforms[AnyVal, Int]

        AssertFalse[conforms_AnyVal_Int.unwrap]

        ExpectError(AssertError) {"""
            AssertFalse[conformes_Int_AnyVal.unwrap]
        """}

        type i = Int

        val isEq_AnyVal_i = IsEq[AnyVal, i]
        AssertFalse[isEq_AnyVal_i.unwrap]

        ExpectError(AssertError) {"""
            val isEq_i_Int = IsEq[i, Int]
            AssertFalse[isEq_i_Int.unwrap]
        """}

        def foo[x <: Any](x: x) = x.asNat.plus(Dense._2)
        type foo[x <: Any] = x#asNat#plus[Dense._2]

        ExpectError(AbstractType) {"""
            Check(foo(Nil))
        """}
/*
        ExpectError(AbstractType) {"""
            dummy[ Check[foo[Nil]] ]
        """}
*/
        val _x = Check(Some(Dense._2).get)
        val x = _x.unwrap
        type x = _x.unwrap //Check[Some[Dense._2]#get]

        ExpectError(AssertError) {"""
            AssertEq(Dense._3, x)
        """}

        ExpectError(AssertError) {"""
            AssertEq[Dense._3, x]
        """}
/*
        ExpectError(AssertError) {"""
            place[ AssertEq[Char, Int] ]
        """}
*/
        ExpectError(NotFound) {"""
            // dummy[ AssertEq[Char, Int] ] // why not error?
            wow
        """}
/*
        ExpectError(AssertError) {"""
            place[ AssertFalse[conforms[Int, Int]] ]
        """}

        ExpectError(AnyError) {"""
            place[Error]
        """}
*/
        AssertEq(Dense._2, x)
        AssertEq[Dense._2, x]

        ExpectError(NothingType) {"""
            Check(None.get)
        """}

        ()
    }

    def testCheck {
         def foo[x <: Nat](x: x): foo[x] = `if`(id(x).equal(Dense._2), Throw(new java.lang.Error("doh")), Const(id(x).increment)).apply
        type foo[x <: Nat]               = `if`[id[x]#equal[Dense._2], Throw                            , Const[id[x]#increment]]#apply

        val _x = Check(foo(Dense._3))
        val x = _x.unwrap
        type x = _x.unwrap // = Check[foo[Dense._3]]

        ExpectError(NothingType) {"""
            Check(foo(Dense._2))
        """}

        ExpectError(NothingType) {"""
            Check(dummy[foo[Dense._2]]) // Nothing
        """}

        ExpectError(AbstractType) {"""
            Check(dummy[Nat#increment]) // abstract
        """}

        val _xt = Check[Dense._3]
        type xt = _xt.unwrap

        AssertEq[xt, Dense._3]
    }
}

