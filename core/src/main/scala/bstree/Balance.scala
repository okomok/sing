

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package bstree


@Annotation.visibleForTesting
object Balance {
     val delta: delta = Dense._5
    type delta        = Dense._5
     val ratio: ratio = Dense._2
    type ratio        = Dense._2

     def apply[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r): apply[k, v, l, r] =
        `if`(l.size.plus(r.size).lteq(Dense._1),
            const0(BSNode(k, v, l, r)),
            `if`(r.size.gteq(delta.times(l.size)),
                RotateL(k, v, l, r),
                `if`(l.size.gteq(delta.times(r.size)),
                    RotateR(k, v, l, r),
                    const0(BSNode(k, v, l, r))
                )
            )
        ).apply.asInstanceOf[apply[k, v, l, r]]

    type apply[k <: Any, v <: Any, l <: BSTree, r <: BSTree] =
        `if`[l#size#plus[r#size]#lteq[Dense._1],
            const0[BSNode[k, v, l, r]],
            `if`[r#size#gteq[delta#times[l#size]],
                RotateL[k, v, l, r],
                `if`[l#size#gteq[delta#times[r#size]],
                    RotateR[k, v, l, r],
                    const0[BSNode[k, v, l, r]]
                ]
            ]
        ]#apply

    case class RotateL[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends AsFunction0 {
        override type self = RotateL[k, v, l, r]
        override  def apply: apply = `if`(r.left.size.lt(ratio.times(r.right.size)), SingleL(k, v, l, r), DoubleL(k, v, l, r)).apply.asInstanceOf[apply]
        override type apply =        `if`[r#left#size#lt[ratio#times[r#right#size]], SingleL[k, v, l, r], DoubleL[k, v, l, r]]#apply
    }

    case class RotateR[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends AsFunction0 {
        override type self = RotateR[k, v, l, r]
        override  def apply: apply = `if`(l.right.size.lt(ratio.times(l.left.size)), SingleR(k, v, l, r), DoubleR(k, v, l, r)).apply.asInstanceOf[apply]
        override type apply =        `if`[l#right#size#lt[ratio#times[l#left#size]], SingleR[k, v, l, r], DoubleR[k, v, l, r]]#apply
    }

    case class SingleL[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends AsFunction0 {
        override type self = SingleL[k, v, l, r]
        override  def apply: apply = BSNode(r.key, r.value, BSNode(k, v, l, r.left), r.right).asInstanceOf[apply]
        override type apply =        BSNode[r#key, r#value, BSNode[k, v, l, r#left], r#right]
    }

    case class SingleR[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends AsFunction0 {
        override type self = SingleR[k, v, l, r]
        override  def apply: apply = BSNode(l.key, l.value, l.left, BSNode(k, v, l.right, r)).asInstanceOf[apply]
        override type apply =        BSNode[l#key, l#value, l#left, BSNode[k, v, l#right, r]]
    }

    case class DoubleL[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends AsFunction0 {
        override type self = DoubleL[k, v, l, r]
        override  def apply: apply = BSNode(r.left.key, r.left.value, BSNode(k, v, l, r.left.left), BSNode(r.key, r.value, r.left.right, r.right)).asInstanceOf[apply]
        override type apply =        BSNode[r#left#key, r#left#value, BSNode[k, v, l, r#left#left], BSNode[r#key, r#value, r#left#right, r#right]]
    }

    case class DoubleR[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends AsFunction0 {
        override type self = DoubleR[k, v, l, r]
        override  def apply: apply = BSNode(l.right.key, l.right.value, BSNode(l.key, l.value, l.left, l.right.left), BSNode(k, v, l.right.right, r)).asInstanceOf[apply]
        override type apply =        BSNode[l#right#key, l#right#value, BSNode[l#key, l#value, l#left, l#right#left], BSNode[k, v, l#right#right, r]]
    }
}


