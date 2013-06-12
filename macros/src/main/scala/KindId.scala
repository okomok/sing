

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object KindId {

    def apply(c: Context)(fullName: String): (c.Tree, c.Tree) = {
        val ids = idList(fullName)
        val v = vFrom(c)( vListFrom(c)( ids.map { id => vNatFrom(c)(Bits(id)) } ) )
        val t = tFrom(c)( tListFrom(c)( ids.map { id => tNatFrom(c)(Bits(id)) } ) )
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

    // KindId construction from Nat List
    private def vFrom(c: Context)(ns: c.Tree): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        Apply(q"$singlib.KindId.From", List(ns))
    }

    private def tFrom(c: Context)(ns: c.Tree): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        AppliedTypeTree(tq"$singlib.KindId.From", List(ns))
    }

    // Nat List --> n1 :: n2 :: ... :: Nil
    private def vListFrom(c: Context)(ns: List[c.Tree]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val vnil: c.Tree = q"$singlib.Nil"
        val vcons: c.Tree = q"$singlib.Cons"

        ns.foldRight(vnil) { (n, x) => Apply(vcons, List(n, x)) }
    }

    private def tListFrom(c: Context)(ns: List[c.Tree]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val tnil: c.Tree = tq"$singlib.Nil"
        val tcons: c.Tree = tq"$singlib.Cons"

        ns.foldRight(tnil) { (n, x) => AppliedTypeTree(tcons, List(n, x)) }
    }

    // Boolean List --> a Nat
    private def vNatFrom(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val vzero: c.Tree = q"$singlib.`false`"
        val vone: c.Tree  = q"$singlib.`true`"
        val vnil: c.Tree  = q"$singlib.DNil"
        val vcons: c.Tree = q"$singlib.DCons"
        def vbit(b: Boolean): c.Tree = if (b) vone else vzero

        bs.foldRight(vnil) { (b, x) => Apply(vcons, List(vbit(b), x)) }
    }

    private def tNatFrom(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val tzero: c.Tree = tq"$singlib.`false`"
        val tone: c.Tree  = tq"$singlib.`true`"
        val tnil: c.Tree  = tq"$singlib.DNil"
        val tcons: c.Tree = tq"$singlib.DCons"
        def tbit(b: Boolean): c.Tree = if (b) tone else tzero

        bs.foldRight(tnil) { (b, x) => AppliedTypeTree(tcons, List(tbit(b), x)) }
    }
}
