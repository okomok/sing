

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
import sing.Dense.Literal._


package object PPP {

    @singmethod
    type id[x] = x

}

class SingmethodTest extends org.scalatest.junit.JUnit3Suite {

    class dummyAnno extends scala.annotation.StaticAnnotation

    @singmethod
    type id[x] = PPP.id[x]

//    Not supported?
//    type singmethodAlias = singmethod

    trait AbsFun extends AsFunction1 {
        @singmethod @deprecated("hello", "1.0")
        type foo[n <: Nat, m <: Boolean] <: Nat

        @singmethod
        type v <: Nat
    }

    object Inc extends AbsFun {
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

    object CallFromObj extends AsFunction1 {
        type self = CallFromObj.type
        @singmethod
        override type apply[n <: Any] = K.k.apply[n]

        @singmethod
        type foo[n <: Nat] = Inc.foo[n, `true`]
    }
/*
    @singmethod
    class foo[m <: Nat] extends AsFunction1 {
        @singmethod
        override type apply[n <: Any] = n#asNat#plus[m]
    }
*/
    object CallFromPackage extends AsFunction1 {
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

        val r: _4 = CallFromObj.foo(_3)

//        val q: foo[_3]#apply[_2] = foo(_3)(_2)
//        val z: _5 = q

        ()
    }
}

