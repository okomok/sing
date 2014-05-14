

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


// Canonical way?
private object ConstructorTree {
    def apply(c: Context)(params: List[c.universe.ValDef]): c.Tree = {
        import c.universe._
        val ClassDef(_, _, _, Template(_, _, body)) = q"class X(..$params)"
        body.last
    }
}
