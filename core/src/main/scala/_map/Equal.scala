

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _map


private[sing]
object Equal {
     def apply[m <: Map, w <: Map, ve <: Option](m: m, w: w, ve: ve): apply[m, w, ve] =
        `if`(id(m).size.nequal(id(w).size), Const(`false`), Else(m, w, ve)).apply.asBoolean
    type apply[m <: Map, w <: Map, ve <: Option] =
        `if`[id[m]#size#nequal[id[w]#size], Const[`false`], Else[m, w, ve]]#apply#asBoolean

    case class Else[m <: Map, w <: Map, ve <: Option](m: m, w: w, ve: ve) extends AsFunction0 {
        override type self = Else[m, w, ve]
        override  def apply: apply = id(m).asList.forall(Pred(w, ve))
        override type apply        = id[m]#asList#forall[Pred[w, ve]]
    }

    case class Pred[w <: Map, ve <: Option](w: w, ve: ve) extends AsFunction1 {
        override type self = Pred[w, ve]
        override  def apply[kv <: Any](kv: kv): apply[kv] =
            new PredApply(id(w).get(id(kv).asProduct2._1), id(kv).asProduct2._2, ve).apply
        override type apply[kv <: Any] =
                PredApply[id[w]#get[id[kv]#asProduct2#_1], kv#asProduct2#_2, ve]#apply
    }

    case class PredApply[ov <: Option, v <: Any, ve <: Option](ov: ov, v: v, ve: ve) extends AsFunction0 {
        override type self = PredApply[ov, v, ve]
        override  def apply: apply = `if`(ov.isEmpty, Const(`false`), PredApplyElse(ov, v, ve)).apply
        override type apply        = `if`[ov#isEmpty, Const[`false`], PredApplyElse[ov, v, ve]]#apply
    }

    case class PredApplyElse[ov <: Option, v <: Any, ve <: Option](ov: ov, v: v, ve: ve) extends AsFunction0 {
        override type self = PredApplyElse[ov, v, ve]
        private[this] lazy val _ve: _ve = ve.getOrNaturalEquiv(v)
        private[this]     type _ve      = ve#getOrNaturalEquiv[v]
        override  def apply: apply = _ve.equiv(ov.get, v)
        override type apply        = _ve#equiv[ov#get, v]
    }
}
