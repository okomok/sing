

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


import scala.collection.immutable.{Seq => SSeq}


sealed abstract class UnsungResult[+T] {
    def get: T
    def next: SSeq[scala.Any]
}

final case class UnsungSuccess[+T](override val get: T, override val next: SSeq[scala.Any]) extends UnsungResult[T]

final case class UnsungFailure(override val next: SSeq[scala.Any]) extends UnsungResult[Nothing] {
    override def get = throw new NoSuchElementException("peg.UnsungFailure.get")
}
