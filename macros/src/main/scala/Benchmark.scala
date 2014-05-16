

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Benchmark {
    def apply(x: String): Unspecified = macro BenchmarkImpl.term_impl
}

class BenchmarkImpl(override val c: Context) extends UntypedImpl {
    import c.universe._

    override protected def untyped_term_impl(x: c.Tree): c.Tree = {
        val start = System.currentTimeMillis
        c.typecheck(x)
        val elapsed = System.currentTimeMillis - start
        q"$elapsed"
    }
}
