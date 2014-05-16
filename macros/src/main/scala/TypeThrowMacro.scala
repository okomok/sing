

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait TypeThrowMacro extends DepMacro1 {
    protected def what: c.Tree

    import c.universe._

    final override protected def termMacroImpl(msg: c.Tree): c.Tree = {
        val ret = typeMacroImpl(msg)
        q"""
            (throw new ${what}(${msg})): $ret
        """
    }

    final override protected def typeMacroImpl(msg: c.Tree): c.Tree = {
        tq"""
            _root_.scala.Nothing with ${what}
        """
        // with ${ConstantTypeOf.termMacro(c)(msg)}
    }
}
