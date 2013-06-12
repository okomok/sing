

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package bstree


private[sing]
object NodePut {
     def apply[m <: BSTree, k <: Any, v <: Any](m: m, k: k, v: v): apply[m, k, v] =
        m.ord.`match`(k, m.key, CaseLT(m, k, v), CaseGT(m, k, v), CaseEQ(m, k, v)).asMap.asBSTree.asInstanceOf[apply[m, k, v]]
    type apply[m <: BSTree, k <: Any, v <: Any] =
        m#ord#`match`[k, m#key, CaseLT[m, k, v], CaseGT[m, k, v], CaseEQ[m, k, v]]#asMap#asBSTree

    case class CaseLT[m <: BSTree, k <: Any, v <: Any](m: m, k: k, v: v) extends AsFunction0 {
        override type self = CaseLT[m, k, v]
        override  def apply: apply = Balance.apply(m.key, m.value, m.left.put(k, v), m.right).asInstanceOf[apply]
        override type apply        = Balance.apply[m#key, m#value, m#left#put[k, v], m#right]
    }

    case class CaseGT[m <: BSTree, k <: Any, v <: Any](m: m, k: k, v: v) extends AsFunction0 {
        override type self = CaseGT[m, k, v]
        override  def apply: apply = Balance.apply(m.key, m.value, m.left, m.right.put(k, v)).asInstanceOf[apply]
        override type apply        = Balance.apply[m#key, m#value, m#left, m#right#put[k, v]]
    }

    case class CaseEQ[m <: BSTree, k <: Any, v <: Any](m: m, k: k, v: v) extends AsFunction0 {
        override type self = CaseEQ[m, k, v]
        override  def apply: apply = BSNode(k, v, m.left, m.right)
        override type apply        = BSNode[k, v, m#left, m#right]
    }
}
