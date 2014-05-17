

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


// Will be removed.

trait TypeThrowMacroImpl extends InContext {
    protected def what: c.Tree

    import c.universe._

    final def termMacro(x: c.Tree): c.Tree = TermWrapper(c) {
        q"""
            (throw new ${what}(${x})): ${_errorType(x)}
        """
    }

    final def typeMacro(x: c.Tree): c.Tree = {
        tq"""
            ${_errorType(x)}
        """
    }

    final def _errorType(x: c.Tree): c.Tree = {
        tq"""
            _root_.scala.Nothing with ${x}
        """
        // with ${ConstantTypeOf.termMacro(c)(x)}
    }
}
