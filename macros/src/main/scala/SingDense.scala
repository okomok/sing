

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


// scala.::(t1, scala.::(t2, scala.Nil)) --> sing.DCons(t1, sing.DCons(t2, sing.DNil))

object SingDense {
    def inTerm(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._

        val vzero: c.Tree = q"${sing_(c)}.`false`"
        val vone: c.Tree = q"${sing_(c)}.`true`"
        val vnil: c.Tree = q"${sing_(c)}.DNil"
        val vcons: c.Tree = q"${sing_(c)}.DCons"
        def vbit(b: Boolean): c.Tree = if (b) vone else vzero

        bs.foldRight(vnil) { (b, x) => Apply(vcons, List(vbit(b), x)) }
    }

    def inType(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._

        val tzero: c.Tree = tq"${sing_(c)}.`false`"
        val tone: c.Tree = tq"${sing_(c)}.`true`"
        val tnil: c.Tree = tq"${sing_(c)}.DNil"
        val tcons: c.Tree = tq"${sing_(c)}.DCons"
        def tbit(b: Boolean): c.Tree = if (b) tone else tzero

        bs.foldRight(tnil) { (b, x) => AppliedTypeTree(tcons, List(tbit(b), x)) }
    }
}
