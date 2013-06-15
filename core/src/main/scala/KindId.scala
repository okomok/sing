

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
object KindId {
    import Dense._

     def fresh[bs <: Dense](bs: bs): fresh[bs] = DCons(_0B, bs.tail)
    type fresh[bs <: Dense]                    = DCons[_0B, bs#tail]

    object ReverseAppend {
         def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
            `if`(xs.isZero, Const(ys), Else(xs, ys)).apply.asNat.asDense
        type apply[xs <: Dense, ys <: Dense] =
            `if`[xs#isZero, Const[ys], Else[xs, ys]]#apply#asNat#asDense

        case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
            override type self = Else[xs, ys]
            override  def apply: apply = ReverseAppend.apply(xs.tail, DCons(xs.head, ys))
            override type apply        = ReverseAppend.apply[xs#tail, DCons[xs#head, ys]]
        }
    }

     def rev[bs <: Dense](bs: bs): rev[bs] = ReverseAppend.apply(bs, DNil)
    type rev[bs <: Dense]                  = ReverseAppend.apply[bs, DNil]

    lazy val _ofAny: _ofAny                         = _1B D_:: DNil
        type _ofAny                                 = _1B D_:: DNil

    lazy val ofAny: ofAny = rev(_ofAny)
        type ofAny        = rev[_ofAny]

// Singles

    lazy val _ofBoxed: _ofBoxed                     = _1B D_:: _ofAny
        type _ofBoxed                               = _1B D_:: _ofAny

    lazy val ofBoxed: ofBoxed = rev(_ofBoxed)
        type ofBoxed          = rev[_ofBoxed]

    lazy val _ofEither: _ofEither                   = _1B D_:: fresh(_ofBoxed)
        type _ofEither                              = _1B D_:: fresh[_ofBoxed]

    lazy val ofEither: ofEither = rev(_ofEither)
        type ofEither           = rev[_ofEither]

    lazy val _ofFunction0: _ofFunction0             = _1B D_:: fresh(_ofEither)
        type _ofFunction0                           = _1B D_:: fresh[_ofEither]

    lazy val ofFunction0: ofFunction0 = rev(_ofFunction0)
        type ofFunction0              = rev[_ofFunction0]

    lazy val _ofFunction2: _ofFunction2             = _1B D_:: fresh(_ofFunction0)
        type _ofFunction2                           = _1B D_:: fresh[_ofFunction0]

    lazy val ofFunction2: ofFunction2 = rev(_ofFunction2)
        type ofFunction2              = rev[_ofFunction2]

    lazy val _ofFunction3: _ofFunction3             = _1B D_:: fresh(_ofFunction2)
        type _ofFunction3                           = _1B D_:: fresh[_ofFunction2]

    lazy val ofFunction3: ofFunction3 = rev(_ofFunction3)
        type ofFunction3              = rev[_ofFunction3]

    lazy val _ofKind: _ofKind                       = _1B D_:: fresh(_ofFunction3)
        type _ofKind                                = _1B D_:: fresh[_ofFunction3]

    lazy val ofKind: ofKind = rev(_ofKind)
        type ofKind         = rev[_ofKind]

    lazy val _ofOption: _ofOption                   = _1B D_:: fresh(_ofKind)
        type _ofOption                              = _1B D_:: fresh[_ofKind]

    lazy val ofOption: ofOption = rev(_ofOption)
        type ofOption           = rev[_ofOption]

    lazy val _ofSet: _ofSet                         = _1B D_:: fresh(_ofOption)
        type _ofSet                                 = _1B D_:: fresh[_ofOption]

    lazy val ofSet: ofSet = rev(_ofSet)
        type ofSet        = rev[_ofSet]

    lazy val _ofUnit: _ofUnit                       = _1B D_:: fresh(_ofSet)
        type _ofUnit                                = _1B D_:: fresh[_ofSet]

    lazy val ofUnit: ofUnit = rev(_ofUnit)
        type ofUnit         = rev[_ofUnit]

// Nats

    lazy val _ofNat: _ofNat                         = _1B D_:: fresh(_ofUnit)
        type _ofNat                                 = _1B D_:: fresh[_ofUnit]

    lazy val ofNat: ofNat = rev(_ofNat)
        type ofNat        = rev[_ofNat]

    lazy val _ofBoolean: _ofBoolean                 = _1B D_:: _ofNat
        type _ofBoolean                             = _1B D_:: _ofNat

    lazy val ofBoolean: ofBoolean = rev(_ofBoolean)
        type ofBoolean            = rev[_ofBoolean]

// Lists

    lazy val _ofList: _ofList                       = _1B D_:: fresh(fresh(_ofBoolean))
        type _ofList                                = _1B D_:: fresh[fresh[_ofBoolean]]

    lazy val ofList: ofList = rev(_ofList)
        type ofList         = rev[_ofList]

    lazy val _ofProduct: _ofProduct                 = _1B D_:: fresh(_ofList)
        type _ofProduct                             = _1B D_:: fresh[_ofList]

    lazy val ofProduct: ofProduct = rev(_ofProduct)
        type ofProduct            = rev[_ofProduct]

    lazy val _ofProduct1: _ofProduct1               = _1B D_:: _ofProduct
        type _ofProduct1                            = _1B D_:: _ofProduct

    lazy val ofProduct1: ofProduct1 = rev(_ofProduct1)
        type ofProduct1             = rev[_ofProduct1]

    lazy val _ofProduct2: _ofProduct2               = _1B D_:: fresh(_ofProduct1)
        type _ofProduct2                            = _1B D_:: fresh[_ofProduct1]

    lazy val ofProduct2: ofProduct2 = rev(_ofProduct2)
        type ofProduct2             = rev[_ofProduct2]

    lazy val _ofProduct3: _ofProduct3               = _1B D_:: fresh(_ofProduct2)
        type _ofProduct3                            = _1B D_:: fresh[_ofProduct2]

    lazy val ofProduct3: ofProduct3 = rev(_ofProduct3)
        type ofProduct3             = rev[_ofProduct3]

// Relations

    lazy val _ofRelation: _ofRelation               = _1B D_:: fresh(fresh(fresh(fresh(_ofProduct3))))
        type _ofRelation                            = _1B D_:: fresh[fresh[fresh[fresh[_ofProduct3]]]]

    lazy val ofRelation: ofRelation = rev(_ofRelation)
        type ofRelation             = rev[_ofRelation]

    lazy val _ofEquiv: _ofEquiv                     = _1B D_:: _ofRelation
        type _ofEquiv                               = _1B D_:: _ofRelation

    lazy val ofEquiv: ofEquiv = rev(_ofEquiv)
        type ofEquiv          = rev[_ofEquiv]

    lazy val _ofPartialOrdering: _ofPartialOrdering = _1B D_:: _ofEquiv
        type _ofPartialOrdering                     = _1B D_:: _ofEquiv

    lazy val ofPartialOrdering: ofPartialOrdering = rev(_ofPartialOrdering)
        type ofPartialOrdering                    = rev[_ofPartialOrdering]

    lazy val _ofOrdering: _ofOrdering               = _1B D_:: _ofPartialOrdering
        type _ofOrdering                            = _1B D_:: _ofPartialOrdering

    lazy val ofOrdering: ofOrdering = rev(_ofOrdering)
        type ofOrdering             = rev[_ofOrdering]

// Function1s (extends Relation)

    lazy val _ofFunction1: _ofFunction1             = _1B D_:: fresh(fresh(fresh(_ofOrdering)))
        type _ofFunction1                           = _1B D_:: fresh[fresh[fresh[_ofOrdering]]]

    lazy val ofFunction1: ofFunction1 = rev(_ofFunction1)
        type ofFunction1              = rev[_ofFunction1]

    lazy val _ofPartialFunction: _ofPartialFunction = _1B D_:: _ofFunction1
        type _ofPartialFunction                     = _1B D_:: _ofFunction1

    lazy val ofPartialFunction: ofPartialFunction = rev(_ofPartialFunction)
        type ofPartialFunction                    = rev[_ofPartialFunction]

    lazy val _ofMap: _ofMap                         = _1B D_:: _ofPartialFunction
        type _ofMap                                 = _1B D_:: _ofPartialFunction

    lazy val ofMap: ofMap = rev(_ofMap)
        type ofMap        = rev[_ofMap]
}
