

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait AnnotationMacroImpl extends InContext {
    protected def annotMacroImpl(ts: scala.List[c.Tree]): scala.List[c.Tree]

    import c.universe._

    final def annotMacro(annottees: c.Tree*): c.Tree = {
        Block(annotMacroImpl(annottees.toList), q"()")
    }
}
