

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Sleep {
    def apply(x: Long): Unit = macro SleepImpl.term_impl
}

class SleepImpl(override val c: Context) extends DependentImpl1 {
    import c.universe._

    override protected def dep_term_impl(x: c.Tree): c.Tree = {
        Thread.sleep(extractLong(x))
        q"()"
    }

    override protected def dep_type_impl(x: c.Tree): c.Tree = {
        Thread.sleep(extractLong(x))
        tq"_root_.scala.Unit"
    }

    private def extractLong(x: c.Tree): Long = {
        x match {
            case Literal(Constant(ms: Long)) if (ms >= 0) => ms
            case t => CompileError.illegalArgument(c)(show(t) + " is required to be non-negative Long literal.")
        }
    }
}
