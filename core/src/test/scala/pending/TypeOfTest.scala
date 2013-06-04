

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
import sing.Dense.Literal._


import scala.language.existentials



class TypeOfTest extends org.scalatest.junit.JUnit3Suite {

    object Inc extends AsFunction1 with makro.Sings.apply {
        type self = Inc.type
        @singmethod @deprecated("hello", "1.0")
        def apply(n: Any) = n.asNat.increment.plus(_2)

        def foobar() = Unit
    }

    type id[x <: Nat] = x
    def id[x <: Nat](x: x): id[x] = x

    object Inc2 extends AsFunction1 with makro.Sings.apply with makro.Sings.apply {
        type self = Inc.type

        @singmethod @deprecated("hello", "1.0")
        def apply(n: Any) = id(n.asNat.increment.plus(_2))

        def foobar() = Unit
    }

    def testTrivial() {
        Inc.foobar()

        val xs = _0 :: _1 :: _2 :: Nil
        val rs: _3 :: _4 :: _5 :: Nil = xs.map(Inc).force

        val rs2: _3 :: _4 :: _5 :: Nil = xs.map(Inc2).force
        ()
    }

/* hmmm, two macros crash.
    object Inc3 extends makro.Self.apply with makro.Sings.apply {
        @singmethod @deprecated("hello", "1.0")
        def apply(n: Any) = n.asNat.increment.plus(_2)
        def foo = ()
    }
*/
}
