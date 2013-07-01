

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing._
import com.github.okomok.sing.Test.CompileError._


trait MiscTest {

    def depfoo[n <: Nat](n: n) {
        val x = n.plus(Dense._1)
        val y = id(n).plus(Dense._1)

        type x = typeOf(x)
        type y = typeOf(y)
        type r = n#plus[Dense._1]


        // x <:< r, but not r <:< x
        val rx: r = x

        Test.expectError(AnyError) {
            val xr: x = null.asInstanceOf[r]
        }

        // y =:= x
        val ry: r = y
        val yr: y = null.asInstanceOf[r]

        ()
    }

    trait Foo[T] {
        type self = typeOf(this)
        type self_ = this.type
        type self__ = typeOf(id(null.asInstanceOf[this.type]))

        implicitly[self =:= self__ ]

        implicitly[self_ <:< self]

        Test.expectError(CannotProve) {
            implicitly[self <:< self_]
        }
    }
}



