

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


import scala.collection.immutable.{Seq => SSeq}


sealed abstract class UnsingResult[+T] {
    def get: T
    def next: SSeq[scala.Any]
}

final case class UnsingSuccess[+T](override val get: T, override val next: SSeq[scala.Any]) extends UnsingResult[T]

final case class UnsingFailure(override val next: SSeq[scala.Any]) extends UnsingResult[Nothing] {
    override def get = throw new NoSuchElementException("peg.UnsingFailure.get")
}
