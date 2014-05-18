

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


class selfTypeDef extends StaticAnnotation {
    def macroTransform(annottees: scala.Any*): scala.Any = macro SelfTypeDefImpl.annotMacro
}


final class SelfTypeDefImpl(override val c: Context) extends AnnotationMacroImpl {
    import c.universe._

    override protected def annotMacroImpl(ts: scala.List[c.Tree]): scala.List[c.Tree] = {
        ts.flatMap {
            case TypeDef(mods, name, tparams, rhs) => {
                val v = TermName(c.freshName())
                val termdef = q"val $v = ${sing_(c)}.TypeOf(this)"
                val typedef = TypeDef(mods, name, tparams, tq"${Ident(v)}.unwrap")
                scala.List(termdef, typedef)
            }
            case t => scala.List(t)
        }
    }
}
