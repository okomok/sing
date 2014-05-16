

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.reflect.macros.whitebox.Context


private object TypeFold {
    def apply[b](c: Context)(t: c.Type)(f: (c.Type, scala.List[b]) => b): b = {
        impl(c)((t: c.Type) => (ts: scala.List[b]) => f(t, ts))(t)
    }

    def impl[b](c: Context)(f: c.Type => scala.List[b] => b)(t: c.Type): b = {
        import c.universe._
        f(t) { typeArgs(c)(t).map(impl(c)(f)) }
    }

    def typeArgs(c: Context)(t: c.Type): scala.List[c.Type] = {
        import c.universe._

        t.dealias match {
            case TypeRef(_, _, args) => args
            case _ => Nil
        }
    }
}
