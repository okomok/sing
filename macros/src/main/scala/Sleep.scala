

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Sleep extends DependentImpl1 {
    def apply(x: Long): Unit = macro term_impl

    override protected def dep_term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        Thread.sleep(extractLong(c)(x))
        q"()"
    }

    override protected def dep_type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        Thread.sleep(extractLong(c)(x))
        tq"_root_.scala.Unit"
    }

    private def extractLong(c: Context)(x: c.Tree): Long = {
        import c.universe._

        x match {
            case Literal(Constant(ms: Long)) if (ms >= 0) => ms
            case t => CompileError.illegalArgument(c)(show(t) + " is required to be non-negative Long literal.")
        }
    }
}
