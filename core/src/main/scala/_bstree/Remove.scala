

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _bstree


private[sing]
object NodeRemove {
     def apply[m <: BSTree, k <: Any](m: m, k: k): apply[m, k] =
        id(m).ord.`match`(k, id(m).key, CaseLT(m, k), CaseGT(m, k), CaseEQ(m, k)).asMap.asBSTree
    type apply[m <: BSTree, k <: Any] =
        id[m]#ord#`match`[k, id[m]#key, CaseLT[m, k], CaseGT[m, k], CaseEQ[m, k]]#asMap#asBSTree

    case class CaseLT[m <: BSTree, k <: Any](m: m, k: k) extends AsFunction0 {
        override type self = CaseLT[m, k]
        override  def apply: apply = Balance.apply(m.key, m.value, m.left.remove(k), m.right)
        override type apply        = Balance.apply[m#key, m#value, m#left#remove[k], m#right]
    }

    case class CaseGT[m <: BSTree, k <: Any](m: m, k: k) extends AsFunction0 {
        override type self = CaseGT[m, k]
        override  def apply: apply = Balance.apply(m.key, m.value, m.left, m.right.remove(k))
        override type apply        = Balance.apply[m#key, m#value, m#left, m#right#remove[k]]
    }

    case class CaseEQ[m <: BSTree, k <: Any](m: m, k: k) extends AsFunction0 {
        override type self = CaseEQ[m, k]
        override  def apply: apply = Glue.apply(m.left, m.right)
        override type apply        = Glue.apply[m#left, m#right]
    }
}
