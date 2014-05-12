

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import makro.{BinaryLiteral => B_}

private[sing]
object KindId {
    private[sing] lazy val _ofAny                   = B_("0000000000000000000000000001")
    lazy val ofAny: ofAny = _ofAny.apply
        type ofAny        = _ofAny.apply

// Singles
    private[sing] lazy val _ofBoxed                 = B_("0000000000000000000000000011")
    lazy val ofBoxed: ofBoxed = _ofBoxed.apply
        type ofBoxed          = _ofBoxed.apply

    private[sing] lazy val _ofEither                = B_("0000000000000000000000000101")
    lazy val ofEither: ofEither = _ofEither.apply
        type ofEither           = _ofEither.apply

    private[sing] lazy val _ofFunction0             = B_("0000000000000000000000001001")
    lazy val ofFunction0: ofFunction0 = _ofFunction0.apply
        type ofFunction0              = _ofFunction0.apply

    private[sing] lazy val _ofFunction2             = B_("0000000000000000000000010001")
    lazy val ofFunction2: ofFunction2 = _ofFunction2.apply
        type ofFunction2              = _ofFunction2.apply

    private[sing] lazy val _ofFunction3             = B_("0000000000000000000000100001")
    lazy val ofFunction3: ofFunction3 = _ofFunction3.apply
        type ofFunction3              = _ofFunction3.apply

    private[sing] lazy val _ofKind                  = B_("0000000000000000000001000001")
    lazy val ofKind: ofKind = _ofKind.apply
        type ofKind         = _ofKind.apply

    private[sing] lazy val _ofOption                = B_("0000000000000000000010000001")
    lazy val ofOption: ofOption = _ofOption.apply
        type ofOption           = _ofOption.apply

    private[sing] lazy val _ofSet                   = B_("0000000000000000000100000001")
    lazy val ofSet: ofSet = _ofSet.apply
        type ofSet        = _ofSet.apply

    private[sing] lazy val _ofUnit                  = B_("0000000000000000001000000001")
    lazy val ofUnit: ofUnit = _ofUnit.apply
        type ofUnit         = _ofUnit.apply

// Nats
    private[sing] lazy val _ofNat                   = B_("0000000000000000010000000001")
    lazy val ofNat: ofNat = _ofNat.apply
        type ofNat        = _ofNat.apply

    private[sing] lazy val _ofBoolean               = B_("0000000000000000110000000001")
    lazy val ofBoolean: ofBoolean = _ofBoolean.apply
        type ofBoolean            = _ofBoolean.apply

// Lists
    private[sing] lazy val _ofList                  = B_("0000000000000001000000000001")
    lazy val ofList: ofList = _ofList.apply
        type ofList         = _ofList.apply

    private[sing] lazy val _ofProduct               = B_("0000000000000011000000000001")
    lazy val ofProduct: ofProduct = _ofProduct.apply
        type ofProduct            = _ofProduct.apply

    private[sing] lazy val _ofProduct1              = B_("0000000000000111000000000001")
    lazy val ofProduct1: ofProduct1 = _ofProduct1.apply
        type ofProduct1             = _ofProduct1.apply

    private[sing] lazy val _ofProduct2              = B_("0000000000001011000000000001")
    lazy val ofProduct2: ofProduct2 = _ofProduct2.apply
        type ofProduct2             = _ofProduct2.apply

    private[sing] lazy val _ofProduct3              = B_("0000000000010011000000000001")
    lazy val ofProduct3: ofProduct3 = _ofProduct3.apply
        type ofProduct3             = _ofProduct3.apply

// Relations
    private[sing] lazy val _ofRelation              = B_("0000000000100000000000000001")
    lazy val ofRelation: ofRelation = _ofRelation.apply
        type ofRelation             = _ofRelation.apply

    private[sing] lazy val _ofEquiv                 = B_("0000000001100000000000000001")
    lazy val ofEquiv: ofEquiv = _ofEquiv.apply
        type ofEquiv          = _ofEquiv.apply

    private[sing] lazy val _ofPartialOrdering       = B_("0000000010100000000000000001")
    lazy val ofPartialOrdering: ofPartialOrdering = _ofPartialOrdering.apply
        type ofPartialOrdering                    = _ofPartialOrdering.apply

    private[sing] lazy val _ofOrdering              = B_("0000000100100000000000000001")
    lazy val ofOrdering: ofOrdering = _ofOrdering.apply
        type ofOrdering             = _ofOrdering.apply

// Function1s (extends Relation)
    private[sing] lazy val _ofFunction1             = B_("0000001000100000000000000001")
    lazy val ofFunction1: ofFunction1 = _ofFunction1.apply
        type ofFunction1              = _ofFunction1.apply

    private[sing] lazy val _ofPartialFunction       = B_("0000011000100000000000000001")
    lazy val ofPartialFunction: ofPartialFunction = _ofPartialFunction.apply
        type ofPartialFunction                    = _ofPartialFunction.apply

    private[sing] lazy val _ofMap                   = B_("0000101000100000000000000001")
    lazy val ofMap: ofMap = _ofMap.apply
        type ofMap        = _ofMap.apply

/*
    lazy val ofAny: ofAny                           = B_("0000000000000000000000000001")
        type ofAny                                  = B_("0000000000000000000000000001")
// Singles
    lazy val ofBoxed: ofBoxed                       = B_("0000000000000000000000000011")
        type ofBoxed                                = B_("0000000000000000000000000011")
    lazy val ofEither: ofEither                     = B_("0000000000000000000000000101")
        type ofEither                               = B_("0000000000000000000000000101")
    lazy val ofFunction0: ofFunction0               = B_("0000000000000000000000001001")
        type ofFunction0                            = B_("0000000000000000000000001001")
    lazy val ofFunction2: ofFunction2               = B_("0000000000000000000000010001")
        type ofFunction2                            = B_("0000000000000000000000010001")
    lazy val ofFunction3: ofFunction3               = B_("0000000000000000000000100001")
        type ofFunction3                            = B_("0000000000000000000000100001")
    lazy val ofKind: ofKind                         = B_("0000000000000000000001000001")
        type ofKind                                 = B_("0000000000000000000001000001")
    lazy val ofOption: ofOption                     = B_("0000000000000000000010000001")
        type ofOption                               = B_("0000000000000000000010000001")
    lazy val ofSet: ofSet                           = B_("0000000000000000000100000001")
        type ofSet                                  = B_("0000000000000000000100000001")
    lazy val ofUnit: ofUnit                         = B_("0000000000000000001000000001")
        type ofUnit                                 = B_("0000000000000000001000000001")
// Nats
    lazy val ofNat: ofNat                           = B_("0000000000000000010000000001")
        type ofNat                                  = B_("0000000000000000010000000001")
    lazy val ofBoolean: ofBoolean                   = B_("0000000000000000110000000001")
        type ofBoolean                              = B_("0000000000000000110000000001")
// Lists
    lazy val ofList: ofList                         = B_("0000000000000001000000000001")
        type ofList                                 = B_("0000000000000001000000000001")
    lazy val ofProduct: ofProduct                   = B_("0000000000000011000000000001")
        type ofProduct                              = B_("0000000000000011000000000001")
    lazy val ofProduct1: ofProduct1                 = B_("0000000000000111000000000001")
        type ofProduct1                             = B_("0000000000000111000000000001")
    lazy val ofProduct2: ofProduct2                 = B_("0000000000001011000000000001")
        type ofProduct2                             = B_("0000000000001011000000000001")
    lazy val ofProduct3: ofProduct3                 = B_("0000000000010011000000000001")
        type ofProduct3                             = B_("0000000000010011000000000001")
// Relations
    lazy val ofRelation: ofRelation                 = B_("0000000000100000000000000001")
        type ofRelation                             = B_("0000000000100000000000000001")
    lazy val ofEquiv: ofEquiv                       = B_("0000000001100000000000000001")
        type ofEquiv                                = B_("0000000001100000000000000001")
    lazy val ofPartialOrdering: ofPartialOrdering   = B_("0000000010100000000000000001")
        type ofPartialOrdering                      = B_("0000000010100000000000000001")
    lazy val ofOrdering: ofOrdering                 = B_("0000000100100000000000000001")
        type ofOrdering                             = B_("0000000100100000000000000001")
// Function1s (extends Relation)
    lazy val ofFunction1: ofFunction1               = B_("0000001000100000000000000001")
        type ofFunction1                            = B_("0000001000100000000000000001")
    lazy val ofPartialFunction: ofPartialFunction   = B_("0000011000100000000000000001")
        type ofPartialFunction                      = B_("0000011000100000000000000001")
    lazy val ofMap: ofMap                           = B_("0000101000100000000000000001")
        type ofMap                                  = B_("0000101000100000000000000001")
*/
}
