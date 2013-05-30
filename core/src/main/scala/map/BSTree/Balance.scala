

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package map; package bstree


@annotation.visibleForTesting
object Balance {
     val delta: delta = nat.dense._5
    type delta        = nat.dense._5
     val ratio: ratio = nat.dense._2
    type ratio        = nat.dense._2

     def apply[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r): apply[k, v, l, r] =
        `if`(l.size.plus(r.size).lteq(nat.dense._1),
            const0(Node(k, v, l, r)),
            `if`(r.size.gteq(delta.times(l.size)),
                RotateL(k, v, l, r),
                `if`(l.size.gteq(delta.times(r.size)),
                    RotateR(k, v, l, r),
                    const0(Node(k, v, l, r))
                )
            )
        ).apply.asInstanceOf[apply[k, v, l, r]]

    type apply[k <: Any, v <: Any, l <: BSTree, r <: BSTree] =
        `if`[l#size#plus[r#size]#lteq[nat.dense._1],
            const0[Node[k, v, l, r]],
            `if`[r#size#gteq[delta#times[l#size]],
                RotateL[k, v, l, r],
                `if`[l#size#gteq[delta#times[r#size]],
                    RotateR[k, v, l, r],
                    const0[Node[k, v, l, r]]
                ]
            ]
        ]#apply

    case class RotateL[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends Function0 {
        type self = RotateL[k, v, l, r]
        override  def apply: apply = `if`(r.left.size.lt(ratio.times(r.right.size)), SingleL(k, v, l, r), DoubleL(k, v, l, r)).apply.asInstanceOf[apply]
        override type apply =        `if`[r#left#size#lt[ratio#times[r#right#size]], SingleL[k, v, l, r], DoubleL[k, v, l, r]]#apply
    }

    case class RotateR[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends Function0 {
        type self = RotateR[k, v, l, r]
        override  def apply: apply = `if`(l.right.size.lt(ratio.times(l.left.size)), SingleR(k, v, l, r), DoubleR(k, v, l, r)).apply.asInstanceOf[apply]
        override type apply =        `if`[l#right#size#lt[ratio#times[l#left#size]], SingleR[k, v, l, r], DoubleR[k, v, l, r]]#apply
    }

    case class SingleL[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends Function0 {
        type self = SingleL[k, v, l, r]
        override  def apply: apply = Node(r.key, r.value, Node(k, v, l, r.left), r.right).asInstanceOf[apply]
        override type apply =        Node[r#key, r#value, Node[k, v, l, r#left], r#right]
    }

    case class SingleR[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends Function0 {
        type self = SingleR[k, v, l, r]
        override  def apply: apply = Node(l.key, l.value, l.left, Node(k, v, l.right, r)).asInstanceOf[apply]
        override type apply =        Node[l#key, l#value, l#left, Node[k, v, l#right, r]]
    }

    case class DoubleL[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends Function0 {
        type self = DoubleL[k, v, l, r]
        override  def apply: apply = Node(r.left.key, r.left.value, Node(k, v, l, r.left.left), Node(r.key, r.value, r.left.right, r.right)).asInstanceOf[apply]
        override type apply =        Node[r#left#key, r#left#value, Node[k, v, l, r#left#left], Node[r#key, r#value, r#left#right, r#right]]
    }

    case class DoubleR[k <: Any, v <: Any, l <: BSTree, r <: BSTree](k: k, v: v, l: l, r: r) extends Function0 {
        type self = DoubleR[k, v, l, r]
        override  def apply: apply = Node(l.right.key, l.right.value, Node(l.key, l.value, l.left, l.right.left), Node(k, v, l.right.right, r)).asInstanceOf[apply]
        override type apply =        Node[l#right#key, l#right#value, Node[l#key, l#value, l#left, l#right#left], Node[k, v, l#right#right, r]]
    }
}


