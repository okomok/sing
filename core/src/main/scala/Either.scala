

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Either extends AsKind with ListLikeKind {
    override  def kindId: kindId = KindId.ofEither
    override type kindId         = KindId.ofEither
}


/**
 * The sing Either
 */
sealed abstract class Either extends Any {
    override type self <: Either
    override type unsing <: scala.Either[_, _]

     def get: get
    type get <: Any

     def fold[f <: Function1, g <: Function1](f: f, g: g): fold[f, g]
    type fold[f <: Function1, g <: Function1] <: Any

     def swap: swap
    type swap <: Either

     def joinLeft: joinLeft
    type joinLeft <: Either

     def joinRight: joinRight
    type joinRight <: Either

     def isLeft: isLeft
    type isLeft <: Boolean

     def isRight: isRight
    type isRight <: Boolean
}


private[sing]
sealed abstract class AsEither extends EitherImpl {
    override  def kind: kind = Either
    override type kind       = Either.type
}


private[sing]
sealed abstract class EitherImpl extends Either with AnyImpl with UnsingEquals with ListLike {
    override  def asEither: asEither = self
    override type asEither           = self

    override def canEqual(that: scala.Any) = that.isInstanceOf[Either]
}


/**
 * The sing Left
 */
final case class Left[e <: Any](override val get: e) extends AsEither {
    override type self = Left[e]

    override  def unsing: unsing = scala.Left(get.unsing)
    override type unsing         = scala.Left[get#unsing, _]

    override type get = e

    override  def fold[f <: Function1, g <: Function1](f: f, g: g): fold[f, g] = f.apply(get)
    override type fold[f <: Function1, g <: Function1]                         = f#apply[get]

    override  def swap: swap = Right(get)
    override type swap       = Right[get]

    override  def joinLeft: joinLeft = get.asEither
    override type joinLeft           = get#asEither

    override  def joinRight: joinRight = self
    override type joinRight            = self

    override  def isLeft: isLeft = `true`
    override type isLeft         = `true`

    override  def isRight: isRight = `false`
    override type isRight          = `false`

    override  def asList: asList = `false` :: get :: Nil
    override type asList         = `false` :: get :: Nil
}


/**
 * The sing Right
 */
final case class Right[e <: Any](override val get: e) extends AsEither {
    override type self = Right[e]

    override  def unsing: unsing = scala.Right(get.unsing)
    override type unsing         = scala.Right[_, get#unsing]

    override type get = e

    override  def fold[f <: Function1, g <: Function1](f: f, g: g): fold[f, g] = g.apply(get)
    override type fold[f <: Function1, g <: Function1]                         = g#apply[get]

    override  def swap: swap = Left(get)
    override type swap       = Left[get]

    override  def joinLeft: joinLeft = self
    override type joinLeft           = self

    override  def joinRight: joinRight = get.asEither
    override type joinRight            = get#asEither

    override  def isLeft: isLeft = `false`
    override type isLeft         = `false`

    override  def isRight: isRight = `true`
    override type isRight          = `true`

    override  def asList: asList = `true` :: get :: Nil
    override type asList         = `true` :: get :: Nil
}
