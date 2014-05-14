

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.

// Copyright Daan Leijen 2002.


package com.github.okomok.sing


import _bstree._


sealed abstract class BSTree extends Map {
    override type self <: BSTree
    override type unsing = scala.collection.immutable.Map[scala.Any, scala.Any]

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


private[sing]
sealed abstract class AsBSTree extends BSTree with AsMap {
    override  def asBSTree: asBSTree = self
    override type asBSTree           = self

    override  def keySet: keySet = BSUnitTree(self)
    override type keySet         = BSUnitTree[self]

    override  def clear: clear = BSNil(ord)
    override type clear        = BSNil[ord]
}


final case class BSNil[o <: Ordering](override val ord: o) extends AsBSTree {
    override type self = BSNil[o]

    override  def unsing: unsing = scala.collection.immutable.Map.empty

    override  def size: size = Dense._0
    override type size       = Dense._0

    private[sing] lazy val _key = makro.Unsupported("BSNil.key")
    override  def key: key = _key.self
    override type key      = _key.self

    private[sing] lazy val _value =  makro.Unsupported("BSNil.value")
    override  def value: value = _value.self
    override type value        = _value.self

    private[sing] lazy val _left = makro.Unsupported("BSNil.left")
    override  def left: left = _left.self
    override type left       = _left.self

    private[sing] lazy val _right = makro.Unsupported("BSNil.right")
    override  def right: right = _right.self
    override type right        = _right.self

    override type ord = o

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    override  def get[k <: Any](k: k): get[k] = None
    override type get[k <: Any]               = None

    override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = BSNode(k, v, self, self)
    override type put[k <: Any, v <: Any]                        = BSNode[k, v, self, self]

    override  def remove[k <: Any](k: k): remove[k] = self
    override type remove[k <: Any]                  = self

    override  def asList: asList = Nil
    override type asList         = Nil

    override  def keyList: keyList = Nil
    override type keyList          = Nil

    override  def valueList: valueList = Nil
    override type valueList            = Nil
}


final case class BSNode[k <: Any, v <: Any, l <: BSTree, r <: BSTree](
    override val key: k, override val value: v, override val left: l, override val right: r) extends AsBSTree
{
    Predef.assert(left.ord eq right.ord)

    override type self = BSNode[k, v, l, r]

    override  def unsing: unsing = (left.unsing + (key.unsing -> value.unsing)) ++ right.unsing

    override  val size: size = id(left).size.plus(id(right).size).increment
    override type size       = id[left]#size#plus[id[right]#size]#increment

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

    override  def asList: asList = left.asList.append(Tuple2(key, value) :: right.asList)
    override type asList         = left#asList#append[Tuple2[key, value] :: right#asList]

    override  def keyList: keyList = left.keyList.append(key :: right.keyList)
    override type keyList          = left#keyList#append[key :: right#keyList]

    override  def valueList: valueList = left.valueList.append(value :: right.valueList)
    override type valueList            = left#valueList#append[value :: right#valueList]
}
