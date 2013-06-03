

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Unzip {
     def apply[xs <: List](xs: xs): apply[xs] = Tuple2(Unzip1(xs), Unzip2(xs))
    type apply[xs <: List]                    = Tuple2[Unzip1[xs], Unzip2[xs]]
}


final case class Unzip1[xs <: List](xs: xs) extends AsList {
    override type self = Unzip1[xs]

    override  def isEmpty: isEmpty = xs.isEmpty
    override type isEmpty          = xs#isEmpty

    override  def head: head = xs.head.asProduct2._1
    override type head       = xs#head#asProduct2#_1

    override  def tail: tail = Unzip1(xs.tail)
    override type tail       = Unzip1[xs#tail]
}

final case class Unzip2[xs <: List](xs: xs) extends AsList {
    override type self = Unzip2[xs]

    override  def isEmpty: isEmpty = xs.isEmpty
    override type isEmpty          = xs#isEmpty

    override  def head: head = xs.head.asProduct2._2
    override type head       = xs#head#asProduct2#_2

    override  def tail: tail = Unzip2(xs.tail)
    override type tail       = Unzip2[xs#tail]
}
