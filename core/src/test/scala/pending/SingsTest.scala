

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing.{Nat, AsFunction1, makro, Any, Nil, ::, singmethod, Boolean, `true`}
import junit.framework.Assert._
import sing.Dense.Literal._


import scala.language.existentials


package object PPP extends makro.Sings.apply {

    @singmethod
    type id[x] = x
}



class SingsTest extends org.scalatest.junit.JUnit3Suite with makro.Sings.apply {

    class dummyAnno extends scala.annotation.StaticAnnotation

    @singmethod
    type id[x] = PPP.id[x]

    trait AbsFun extends AsFunction1 with makro.Sings.apply {
        @singmethod @deprecated("hello", "1.0")
        type foo[n <: Nat, m <: Boolean] <: Nat

        @singmethod
        type v <: Nat
    }

    object Inc extends AbsFun with makro.Sings.apply {
        type self = Inc.type

        @singmethod @dummyAnno
        override type apply[n <: Any] = id[n#asNat#increment#plus[_2]]

        @singmethod
        override type foo[n <: Nat, m <: Boolean] = n#plus[m#asNat]

        def foobar() = Unit

        @singmethod
        override type v = _3
    }

    object K {
        val k: Inc.type = Inc
    }

    object CallFromObj extends AsFunction1 with makro.Sings.apply {
        @singmethod
        override type apply[n <: Any] = K.k.apply[n]
    }

    @singmethod
    class foo[m <: Nat] extends AsFunction1 with makro.Sings.apply {
        @singmethod
        override type apply[n <: Any] = n#asNat#plus[m]
    }

    object CallFromPackage extends AsFunction1 with makro.Sings.apply {
        @singmethod
        override type apply[n <: Any] = id[com.github.okomok.sing.Cons[n, Nil]]
    }

    def testTrivial() {
        Inc.foobar()

        val xs = _0 :: _1 :: _2 :: Nil
        val rs: _3 :: _4 :: _5 :: Nil = xs.map(Inc).force

        val k: _4  = Inc.foo(_3, `true`)
        val l: _4 = CallFromObj(_1)
        val p: _3 = Inc.v

        val m: _3 :: Nil = CallFromPackage(_3)

        val q: foo[_3]#apply[_2] = foo(_3)(_2)
        val z: _5 = q

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

