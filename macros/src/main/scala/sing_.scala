

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


object sing_ {
    def apply(c: Context): c.Tree = {
        import c.universe._
        q"_root_.com.github.okomok.sing"
    }
}
