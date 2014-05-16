

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait AnnotationMacro extends InContext {
    protected def annotImpl(ts: scala.List[c.Tree]): scala.List[c.Tree]

    import c.universe._

    final def annot(annottees: c.Tree*): c.Tree = {
        Block(annotImpl(annottees.toList), q"()")
    }
}
