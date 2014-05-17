

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Sleep {
    def apply(x: Long): scala.Unit = macro SleepImpl.termMacro
}


final class SleepImpl(val c: Context) {
    import c.universe._

    def termMacro(x: c.Tree): c.Tree = {
        Thread.sleep(extractLong(x))
        q"()"
    }

    def typeMacro(x: c.Tree): c.Tree = {
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
