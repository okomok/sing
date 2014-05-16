

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing._
import com.github.okomok.sing.CompileError._


trait MiscTest {

    def depfoo[n <: Nat](n: n) {
        val x = n.plus(Dense._1)
        val y = id(n).plus(Dense._1)

        val _x = TypeOf(x)
        type x = _x.apply

        val _y = TypeOf(y)
        type y = _y.apply
        type r = n#plus[Dense._1]


        // x <:< r, but not r <:< x
        val rx: r = x

        ExpectError(AnyError) {"""
            val xr: x = null.asInstanceOf[r]
        """}

        // y =:= x
        val ry: r = y
        val yr: y = null.asInstanceOf[r]

        ()
    }

    trait Foo[T] {
        val _self = TypeOf(this)
        type self = _self.apply
        type self_ = this.type
        val _self__ = TypeOf(id(null.asInstanceOf[this.type]))
        type self__ = _self__.apply

        implicitly[self =:= self__ ]

        implicitly[self_ <:< self]

        ExpectError(CannotProve) {"""
            implicitly[self <:< self_]
        """}
    }
}



