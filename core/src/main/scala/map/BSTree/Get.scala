

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package map; package bstree


private[sing]
object NodeGet {
     def apply[m <: BSTree, k <: Any](m: m, k: k): apply[m, k] =
        m.ord.`match`(k, m.key, CaseLT(m, k), CaseGT(m, k), CaseEQ(m, k)).asOption.asInstanceOf[apply[m, k]]
    type apply[m <: BSTree, k <: Any] =
        m#ord#`match`[k, m#key, CaseLT[m, k], CaseGT[m, k], CaseEQ[m, k]]#asOption

    case class CaseLT[m <: BSTree, k <: Any](m: m, k: k) extends Function0 {
        type self = CaseLT[m, k]
        override  def apply: apply = m.left.get(k)
        override type apply        = m#left#get[k]
    }

    case class CaseGT[m <: BSTree, k <: Any](m: m, k: k) extends Function0 {
        type self = CaseGT[m, k]
        override  def apply: apply = m.right.get(k)
        override type apply        = m#right#get[k]
    }

    case class CaseEQ[m <: BSTree, k <: Any](m: m, k: k) extends Function0 {
        type self = CaseEQ[m, k]
        override  def apply: apply = Some(m.value)
        override type apply        = Some[m#value]
    }
}
