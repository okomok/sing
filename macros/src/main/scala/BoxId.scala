

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object BoxId {
    def apply(c: Context)(fullName: String): (c.Tree, c.Tree) = {
        val ids = idList(fullName)
        val v = term_ListFrom(c)( ids.map { id => term_NatFrom(c)(Bits(id)) } )
        val t = type_ListFrom(c)( ids.map { id => type_NatFrom(c)(Bits(id)) } )
        (v, t)
    }

    def idList(fullName: String): List[String] = {
        fullName.split("\\.").
            reverse. // for a faster search
            toList.
            filterNot(s => s == "type").
            map(s => s.take(6)).
            take(2) // because scalac is too slow
    }

    // Nat List --> n1 :: n2 :: ... :: Nil
    private def term_ListFrom(c: Context)(ns: List[c.Tree]): c.Tree = {
        import c.universe._

        val vnil: c.Tree = q"${sing_(c)}.Nil"
        val vcons: c.Tree = q"${sing_(c)}.Cons"

        ns.foldRight(vnil) { (n, x) => Apply(vcons, List(n, x)) }
    }

    private def type_ListFrom(c: Context)(ns: List[c.Tree]): c.Tree = {
        import c.universe._

        val tnil: c.Tree = tq"${sing_(c)}.Nil"
        val tcons: c.Tree = tq"${sing_(c)}.Cons"

        ns.foldRight(tnil) { (n, x) => AppliedTypeTree(tcons, List(n, x)) }
    }

    // Boolean List --> a Nat
    private def term_NatFrom(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._

        val vzero: c.Tree = q"${sing_(c)}.`false`"
        val vone: c.Tree  = q"${sing_(c)}.`true`"
        val vnil: c.Tree  = q"${sing_(c)}.DNil"
        val vcons: c.Tree = q"${sing_(c)}.DCons"
        def vbit(b: Boolean): c.Tree = if (b) vone else vzero

        bs.foldRight(vnil) { (b, x) => Apply(vcons, List(vbit(b), x)) }
    }

    private def type_NatFrom(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._

        val tzero: c.Tree = tq"${sing_(c)}.`false`"
        val tone: c.Tree  = tq"${sing_(c)}.`true`"
        val tnil: c.Tree  = tq"${sing_(c)}.DNil"
        val tcons: c.Tree = tq"${sing_(c)}.DCons"
        def tbit(b: Boolean): c.Tree = if (b) tone else tzero

        bs.foldRight(tnil) { (b, x) => AppliedTypeTree(tcons, List(tbit(b), x)) }
    }
}
