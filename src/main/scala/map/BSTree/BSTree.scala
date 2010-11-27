

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.

// Copyright Daan Leijen 2002.


package com.github.okomok
package sing; package map; package bstree


sealed abstract class BSTree extends AbstractMap {
    type self <: BSTree
    type unsing = scala.collection.immutable.Map[scala.Any, scala.Any]

    override type put[k <: Any, v <: Any] <: BSTree
    override type remove[k <: Any] <: BSTree
    override type clear <: BSTree

     def key: key
    type key <: Any

     def value: value
    type value <: Any

     def left: left
    type left <: BSTree

     def right: right
    type right <: BSTree

     def ord: ord
    type ord <: Ordering
}


sealed abstract class AbstractBSTree extends BSTree {
    final override  def asBSTree: asBSTree = self
    final override type asBSTree           = self

    final override  def keySet: keySet = set.BSTree(self)
    final override type keySet         = set.BSTree[self]

    final override  def clear: clear = Nil(ord)
    final override type clear        = Nil[ord]
}


final case class Nil[o <: Ordering](override val ord: o) extends AbstractBSTree {
    type self = Nil[o]

    override  def unsing: unsing = scala.collection.immutable.Map.empty

    override  def size: size = nat.dense._0
    override type size       = nat.dense._0

    override  def key: key = unsupported("map.bstree.Nil.key")
    override type key      = unsupported[_]

    override  def value: value = unsupported("map.bstree.Nil.value")
    override type value        = unsupported[_]

    override  def left: left = unsupported("map.bstree.Nil.left")
    override type left       = unsupported[_]

    override  def right: right = unsupported("map.bstree.Nil.right")
    override type right        = unsupported[_]

    override type ord = o

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    override  def get[k <: Any](k: k): get[k] = None
    override type get[k <: Any]               = None

    override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = Node(k, v, self, self)
    override type put[k <: Any, v <: Any]                        = Node[k, v, self, self]

    override  def remove[k <: Any](k: k): remove[k] = self
    override type remove[k <: Any]                  = self

    override  def asList: asList = list.Nil
    override type asList         = list.Nil

    override  def keyList: keyList = list.Nil
    override type keyList          = list.Nil

    override  def valueList: valueList = list.Nil
    override type valueList            = list.Nil
}


final case class Node[k <: Any, v <: Any, l <: BSTree, r <: BSTree](
    override val key: k, override val value: v, override val left: l, override val right: r) extends AbstractBSTree
{
    Predef.assert(left.ord eq right.ord)

    type self = Node[k, v, l, r]

    override  def unsing: unsing = (left.unsing + (key.unsing -> value.unsing)) ++ right.unsing

    override  val size: size = left.size.plus(right.size).increment.asInstanceOf[size]
    override type size       = left#size#plus[right#size]#increment

    override type key = k
    override type value = v
    override type left = l
    override type right = r

    override  val ord: ord = left.ord
    override type ord      = left#ord

    override  def isEmpty: isEmpty = `false`
    override type isEmpty          = `false`

    override  def get[k <: Any](k: k): get[k] = NodeGet.apply(self, k)
    override type get[k <: Any]               = NodeGet.apply[self, k]

    override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = NodePut.apply(self, k, v)
    override type put[k <: Any, v <: Any]                        = NodePut.apply[self, k, v]

    override  def remove[k <: Any](k: k): remove[k] = NodeRemove.apply(self, k)
    override type remove[k <: Any]                  = NodeRemove.apply[self, k]

    override  def asList: asList = left.asList.append(Tuple2(key, value) :: right.asList).asInstanceOf[asList]
    override type asList         = left#asList#append[Tuple2[key, value] :: right#asList]

    override  def keyList: keyList = left.keyList.append(key :: right.keyList).asInstanceOf[keyList]
    override type keyList          = left#keyList#append[key :: right#keyList]

    override  def valueList: valueList = left.valueList.append(value :: right.valueList).asInstanceOf[valueList]
    override type valueList            = left#valueList#append[value :: right#valueList]
}
