

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.reflect.macros.whitebox.Context


trait TypeWrapper {
    type unwrap
}


object TypeWrapper {
    def apply(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        q"${sing_(c)}.TypeWrapper.of[$x]"

    }

    def of[x]: of[x] = new TypeWrapper {
        override type unwrap = x
    }

    type of[x] = TypeWrapper {
        type unwrap = x
    }
}
