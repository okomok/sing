

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Option {

    /**
     * Lifts scala.Options.
     */
    def lift(x: scala.None.type): None = liftNone(x)
    def lift[A](x: scala.Some[A])(implicit _A: BoxKind[A]): Some[Box[A, _A.self]] = liftSome(x)(_A)

    def liftNone(x: scala.None.type): None = None
    def liftSome[A](x: scala.Some[A])(implicit _A: BoxKind[A]): Some[Box[A, _A.self]] = Some(Box(x.get)(_A))

}


/**
 * The sing Option
 */
sealed abstract class Option extends Any {
    override type self <: Option
    override type unsing <: scala.Option[_]

     def isEmpty: isEmpty
    type isEmpty <: Boolean

     def nonEmpty: nonEmpty
    type nonEmpty <: Boolean

     def get: get
    type get <: Any

     def getOrElse[f <: Function0](f: f): getOrElse[f]
    type getOrElse[f <: Function0] <: Any

     def getOrNaturalEquiv[x <: Any](x: x): getOrNaturalEquiv[x]
    type getOrNaturalEquiv[x <: Any] <: Equiv

     def getOrNaturalOrdering[x <: Any](x: x): getOrNaturalOrdering[x]
    type getOrNaturalOrdering[x <: Any] <: Ordering

     def isDefined: isDefined
    type isDefined <: Boolean

     def map[f <: Function1](f: f): map[f]
    type map[f <: Function1] <: Option

     def flatMap[f <: Function1](f: f): flatMap[f]
    type flatMap[f <: Function1] <: Option

     def filter[f <: Function1](f: f): filter[f]
    type filter[f <: Function1] <: Option

     def exists[f <: Function1](f: f): exists[f]
    type exists[f <: Function1] <: Boolean

     def foreach[f <: Function1](f: f): foreach[f]
    type foreach[f <: Function1] <: Unit

     def orElse[f <: Function0](f: f): orElse[f]
    type orElse[f <: Function0] <: Option
}


private[sing]
sealed abstract class AsOption extends Option with AsAny {
    override  def asOption: asOption = self
    override type asOption           = self

    override  def nonEmpty: nonEmpty = isEmpty.not
    override type nonEmpty           = isEmpty#not

    override  def getOrNaturalEquiv[x <: Any](x: x): getOrNaturalEquiv[x] =
        getOrElse(NaturalOrderingOf(x)).asEquiv
    override type getOrNaturalEquiv[x <: Any] =
        getOrElse[NaturalOrderingOf[x]]#asEquiv

    override  def getOrNaturalOrdering[x <: Any](x: x): getOrNaturalOrdering[x] =
        getOrElse(NaturalOrderingOf(x)).asOrdering
    override type getOrNaturalOrdering[x <: Any] =
        getOrElse[NaturalOrderingOf[x]]#asOrdering

    override  def isDefined: isDefined = isEmpty.not
    override type isDefined            = isEmpty#not

    override type foreach[f <: Function1] = Unit

    override  def orElse[f <: Function0](f: f): orElse[f] = `if`(isEmpty, f, const0(self)).apply.asOption
    override type orElse[f <: Function0]                  = `if`[isEmpty, f, const0[self]]#apply#asOption

    override  def naturalOrdering: naturalOrdering = List.naturalOrdering
    override type naturalOrdering                  = List.naturalOrdering

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Option]
}


/**
 * The sing None
 */
sealed abstract class None extends AsOption {
    override type self = None

    override  def unsing: unsing = scala.None
    override type unsing         = scala.None.type

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    override  def get: get = noSuchElement("None.get")
    override type get      = noSuchElement[_]

    override  def getOrElse[f <: Function0](f: f): getOrElse[f] = f.apply
    override type getOrElse[f <: Function0]                     = f#apply

    override  def map[f <: Function1](f: f): map[f] = self
    override type map[f <: Function1]               = self

    override  def flatMap[f <: Function1](f: f): flatMap[f] = self
    override type flatMap[f <: Function1]                   = self

    override  def filter[f <: Function1](f: f): filter[f] = self
    override type filter[f <: Function1]                  = self

    override  def exists[f <: Function1](f: f): exists[f] = `false`
    override type exists[f <: Function1]                  = `false`

    override  def foreach[f <: Function1](f: f): foreach[f] = Unit

    override  def asList: asList = Nil
    override type asList         = Nil
}

private[sing]
object _TermOfNone {
    val apply: None = new None{}
}


/**
 * The sing Some
 */
final case class Some[e <: Any](override val get: e) extends AsOption {
    override type self = Some[e]

    override  def unsing: unsing = scala.Some(get.unsing)
    override type unsing         = scala.Some[get#unsing]

    override  def isEmpty: isEmpty = `false`
    override type isEmpty          = `false`

    override type get = e

    override  def getOrElse[f <: Function0](f: f): getOrElse[f] = get
    override type getOrElse[f <: Function0]                     = get

    override  def map[f <: Function1](f: f): map[f] = Some(f.apply(get))
    override type map[f <: Function1]               = Some[f#apply[get]]

    override  def flatMap[f <: Function1](f: f): flatMap[f] = f.apply(get).asOption
    override type flatMap[f <: Function1]                   = f#apply[get]#asOption

    override  def filter[f <: Function1](f: f): filter[f] = `if`(f.apply(get).asBoolean, const0(self), const0(None)).apply.asOption
    override type filter[f <: Function1]                  = `if`[f#apply[get]#asBoolean, const0[self], const0[None]]#apply#asOption

    override  def exists[f <: Function1](f: f): exists[f] = f.apply(get).asBoolean
    override type exists[f <: Function1]                  = f#apply[get]#asBoolean

    override  def foreach[f <: Function1](f: f): foreach[f] = { f.apply(get); Unit }

    override  def asList: asList = get :: Nil
    override type asList         = get :: Nil
}

