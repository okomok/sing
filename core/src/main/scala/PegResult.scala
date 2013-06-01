

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import peg._


sealed abstract class PegResult extends Any {
    type self <: PegResult
    type unsing <: UnsingResult[_]

     def get: get
    type get <: Any

     def next: next
    type next <: List

     def successful: successful
    type successful <: Boolean

     def map[f <: Function1](f: f): map[f]
    type map[f <: Function1] <: PegResult

     def append[f <: Function0](f: f): append[f]
    type append[f <: Function0] <: PegResult
}


private[sing]
sealed abstract class AbstractPegResult extends PegResult {
    final override  def asPegResult: asPegResult = self
    final override type asPegResult              = self

    final override  def canEqual(that: scala.Any) = that.isInstanceOf[PegResult]
}


final case class PegSuccess[x <: Any, ys <: List](override val get: x, override val next: ys) extends AbstractPegResult {
    type self = PegSuccess[x, ys]

    override  def unsing: unsing = UnsingSuccess(get.unsing, next.unsing)
    override type unsing         = UnsingSuccess[get#unsing]

    override type get = x
    override type next = ys

    override  def successful: successful = `true`
    override type successful             = `true`

    override  def map[f <: Function1](f: f): map[f] = PegSuccess(f.apply(get), next)
    override type map[f <: Function1]               = PegSuccess[f#apply[get], next]

    override  def append[f <: Function0](f: f): append[f] = self
    override type append[f <: Function0]                  = self
}


final case class PegFailure[ys <: List](override val next: ys) extends AbstractPegResult {
    type self = PegFailure[ys]

    override  def unsing: unsing = UnsingFailure(next.unsing)
    override type unsing         = UnsingFailure

    override  def get: get = noSuchElement("PegFailure.get")
    override type get      = noSuchElement[_]
    override type next = ys

    override  def successful: successful = `false`
    override type successful             = `false`

    override  def map[f <: Function1](f: f): map[f] = self
    override type map[f <: Function1]               = self

    override  def append[f <: Function0](f: f): append[f] = f.apply.asPegResult
    override type append[f <: Function0]                  = f#apply#asPegResult
}
