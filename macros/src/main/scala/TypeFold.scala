

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


object TypeFold {
    def apply[b](c: Context)(t: c.Type)(f: (c.Type, List[b]) => b): b = {
        term_impl(c)((t: c.Type) => (ts: List[b]) => f(t, ts))(t)
    }

    def term_impl[b](c: Context)(f: c.Type => List[b] => b)(t: c.Type): b = {
        import c.universe._
        f(t) { typeArgs(c)(t).map(term_impl(c)(f)) }
    }

    def typeArgs(c: Context)(t: c.Type): List[c.Type] = {
        import c.universe._

        t.dealias match {
            case TypeRef(_, _, args) => args
            case _ => Nil
        }
    }
}
