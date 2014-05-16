

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Benchmark {
    def apply(x: String): scala.Any = macro BenchmarkImpl.untyped
}


class BenchmarkImpl(override val c: Context) extends UntypedMacro {
    import c.universe._

    override protected def untypedImpl(x: c.Tree): c.Tree = {
        val start = System.currentTimeMillis
        c.typecheck(x)
        val elapsed = System.currentTimeMillis - start
        q"$elapsed"
    }
}
