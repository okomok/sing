

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _bstree


private[sing]
object NodeGet {
     def apply[m <: BSTree, k <: Any](m: m, k: k): apply[m, k] =
        id(m).ord.`match`(k, id(m).key, CaseLT(m, k), CaseGT(m, k), CaseEQ(m, k)).asOption
    type apply[m <: BSTree, k <: Any] =
        id[m]#ord#`match`[k, id[m]#key, CaseLT[m, k], CaseGT[m, k], CaseEQ[m, k]]#asOption

    case class CaseLT[m <: BSTree, k <: Any](m: m, k: k) extends AsFunction0 {
        override type self = CaseLT[m, k]
        override  def apply: apply = m.left.get(k)
        override type apply        = m#left#get[k]
    }

    case class CaseGT[m <: BSTree, k <: Any](m: m, k: k) extends AsFunction0 {
        override type self = CaseGT[m, k]
        override  def apply: apply = m.right.get(k)
        override type apply        = m#right#get[k]
    }

    case class CaseEQ[m <: BSTree, k <: Any](m: m, k: k) extends AsFunction0 {
        override type self = CaseEQ[m, k]
        override  def apply: apply = Some(m.value)
        override type apply        = Some[m#value]
    }
}
