

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


private object TypeId {
    def inTerm(c: Context)(t: c.Type): c.Tree = {
        TypeFold(c)(t) { (t, ts: scala.List[c.Tree]) =>
            SingList.inTerm(c) {
                scala.List(term_designatorId(c)(t), SingList.inTerm(c)(ts))
            }
        }
    }

    def inType(c: Context)(t: c.Type): c.Tree = {
        TypeFold(c)(t) { (t, ts: scala.List[c.Tree]) =>
            SingList.inType(c) {
                scala.List(type_designatorId(c)(t), SingList.inType(c)(ts))
            }
        }
    }

    private def term_designatorId(c: Context)(t: c.Type): c.Tree = {
        val ids = idList(c)(t)
        SingList.inTerm(c) {
            ids.map{ id => SingDense.inTerm(c)(Bits(id)) }
        }
    }

    private def type_designatorId(c: Context)(t: c.Type): c.Tree = {
        val ids = idList(c)(t)
        SingList.inType(c) {
            ids.map{ id => SingDense.inType(c)(Bits(id)) }
        }
    }

    private def idList(c: Context)(t: c.Type): scala.List[String] = {
        t.dealias.typeSymbol.fullName.split("\\.").
            reverse. // for faster equality
            toList.
            take(2) // because scalac is too slow
    }
}
