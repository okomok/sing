

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


private[sing]
object KindId {
    private[sing] lazy val _ofAny                   = Binary_("0000000000000000000000000001")
    lazy val ofAny: ofAny = _ofAny.unwrap
        type ofAny        = _ofAny.unwrap

// Singles
    private[sing] lazy val _ofBoxed                 = Binary_("0000000000000000000000000011")
    lazy val ofBoxed: ofBoxed = _ofBoxed.unwrap
        type ofBoxed          = _ofBoxed.unwrap

    private[sing] lazy val _ofEither                = Binary_("0000000000000000000000000101")
    lazy val ofEither: ofEither = _ofEither.unwrap
        type ofEither           = _ofEither.unwrap

    private[sing] lazy val _ofFunction0             = Binary_("0000000000000000000000001001")
    lazy val ofFunction0: ofFunction0 = _ofFunction0.unwrap
        type ofFunction0              = _ofFunction0.unwrap

    private[sing] lazy val _ofFunction2             = Binary_("0000000000000000000000010001")
    lazy val ofFunction2: ofFunction2 = _ofFunction2.unwrap
        type ofFunction2              = _ofFunction2.unwrap

    private[sing] lazy val _ofFunction3             = Binary_("0000000000000000000000100001")
    lazy val ofFunction3: ofFunction3 = _ofFunction3.unwrap
        type ofFunction3              = _ofFunction3.unwrap

    private[sing] lazy val _ofKind                  = Binary_("0000000000000000000001000001")
    lazy val ofKind: ofKind = _ofKind.unwrap
        type ofKind         = _ofKind.unwrap

    private[sing] lazy val _ofOption                = Binary_("0000000000000000000010000001")
    lazy val ofOption: ofOption = _ofOption.unwrap
        type ofOption           = _ofOption.unwrap

    private[sing] lazy val _ofSet                   = Binary_("0000000000000000000100000001")
    lazy val ofSet: ofSet = _ofSet.unwrap
        type ofSet        = _ofSet.unwrap

    private[sing] lazy val _ofUnit                  = Binary_("0000000000000000001000000001")
    lazy val ofUnit: ofUnit = _ofUnit.unwrap
        type ofUnit         = _ofUnit.unwrap

// Nats
    private[sing] lazy val _ofNat                   = Binary_("0000000000000000010000000001")
    lazy val ofNat: ofNat = _ofNat.unwrap
        type ofNat        = _ofNat.unwrap

    private[sing] lazy val _ofBoolean               = Binary_("0000000000000000110000000001")
    lazy val ofBoolean: ofBoolean = _ofBoolean.unwrap
        type ofBoolean            = _ofBoolean.unwrap

// Lists
    private[sing] lazy val _ofList                  = Binary_("0000000000000001000000000001")
    lazy val ofList: ofList = _ofList.unwrap
        type ofList         = _ofList.unwrap

    private[sing] lazy val _ofProduct               = Binary_("0000000000000011000000000001")
    lazy val ofProduct: ofProduct = _ofProduct.unwrap
        type ofProduct            = _ofProduct.unwrap

    private[sing] lazy val _ofProduct1              = Binary_("0000000000000111000000000001")
    lazy val ofProduct1: ofProduct1 = _ofProduct1.unwrap
        type ofProduct1             = _ofProduct1.unwrap

    private[sing] lazy val _ofProduct2              = Binary_("0000000000001011000000000001")
    lazy val ofProduct2: ofProduct2 = _ofProduct2.unwrap
        type ofProduct2             = _ofProduct2.unwrap

    private[sing] lazy val _ofProduct3              = Binary_("0000000000010011000000000001")
    lazy val ofProduct3: ofProduct3 = _ofProduct3.unwrap
        type ofProduct3             = _ofProduct3.unwrap

// Relations
    private[sing] lazy val _ofRelation              = Binary_("0000000000100000000000000001")
    lazy val ofRelation: ofRelation = _ofRelation.unwrap
        type ofRelation             = _ofRelation.unwrap

    private[sing] lazy val _ofEquiv                 = Binary_("0000000001100000000000000001")
    lazy val ofEquiv: ofEquiv = _ofEquiv.unwrap
        type ofEquiv          = _ofEquiv.unwrap

    private[sing] lazy val _ofPartialOrdering       = Binary_("0000000010100000000000000001")
    lazy val ofPartialOrdering: ofPartialOrdering = _ofPartialOrdering.unwrap
        type ofPartialOrdering                    = _ofPartialOrdering.unwrap

    private[sing] lazy val _ofOrdering              = Binary_("0000000100100000000000000001")
    lazy val ofOrdering: ofOrdering = _ofOrdering.unwrap
        type ofOrdering             = _ofOrdering.unwrap

// Function1s (extends Relation)
    private[sing] lazy val _ofFunction1             = Binary_("0000001000100000000000000001")
    lazy val ofFunction1: ofFunction1 = _ofFunction1.unwrap
        type ofFunction1              = _ofFunction1.unwrap

    private[sing] lazy val _ofPartialFunction       = Binary_("0000011000100000000000000001")
    lazy val ofPartialFunction: ofPartialFunction = _ofPartialFunction.unwrap
        type ofPartialFunction                    = _ofPartialFunction.unwrap

    private[sing] lazy val _ofMap                   = Binary_("0000101000100000000000000001")
    lazy val ofMap: ofMap = _ofMap.unwrap
        type ofMap        = _ofMap.unwrap

/*
    lazy val ofAny: ofAny                           = Binary_("0000000000000000000000000001")
        type ofAny                                  = Binary_("0000000000000000000000000001")
// Singles
    lazy val ofBoxed: ofBoxed                       = Binary_("0000000000000000000000000011")
        type ofBoxed                                = Binary_("0000000000000000000000000011")
    lazy val ofEither: ofEither                     = Binary_("0000000000000000000000000101")
        type ofEither                               = Binary_("0000000000000000000000000101")
    lazy val ofFunction0: ofFunction0               = Binary_("0000000000000000000000001001")
        type ofFunction0                            = Binary_("0000000000000000000000001001")
    lazy val ofFunction2: ofFunction2               = Binary_("0000000000000000000000010001")
        type ofFunction2                            = Binary_("0000000000000000000000010001")
    lazy val ofFunction3: ofFunction3               = Binary_("0000000000000000000000100001")
        type ofFunction3                            = Binary_("0000000000000000000000100001")
    lazy val ofKind: ofKind                         = Binary_("0000000000000000000001000001")
        type ofKind                                 = Binary_("0000000000000000000001000001")
    lazy val ofOption: ofOption                     = Binary_("0000000000000000000010000001")
        type ofOption                               = Binary_("0000000000000000000010000001")
    lazy val ofSet: ofSet                           = Binary_("0000000000000000000100000001")
        type ofSet                                  = Binary_("0000000000000000000100000001")
    lazy val ofUnit: ofUnit                         = Binary_("0000000000000000001000000001")
        type ofUnit                                 = Binary_("0000000000000000001000000001")
// Nats
    lazy val ofNat: ofNat                           = Binary_("0000000000000000010000000001")
        type ofNat                                  = Binary_("0000000000000000010000000001")
    lazy val ofBoolean: ofBoolean                   = Binary_("0000000000000000110000000001")
        type ofBoolean                              = Binary_("0000000000000000110000000001")
// Lists
    lazy val ofList: ofList                         = Binary_("0000000000000001000000000001")
        type ofList                                 = Binary_("0000000000000001000000000001")
    lazy val ofProduct: ofProduct                   = Binary_("0000000000000011000000000001")
        type ofProduct                              = Binary_("0000000000000011000000000001")
    lazy val ofProduct1: ofProduct1                 = Binary_("0000000000000111000000000001")
        type ofProduct1                             = Binary_("0000000000000111000000000001")
    lazy val ofProduct2: ofProduct2                 = Binary_("0000000000001011000000000001")
        type ofProduct2                             = Binary_("0000000000001011000000000001")
    lazy val ofProduct3: ofProduct3                 = Binary_("0000000000010011000000000001")
        type ofProduct3                             = Binary_("0000000000010011000000000001")
// Relations
    lazy val ofRelation: ofRelation                 = Binary_("0000000000100000000000000001")
        type ofRelation                             = Binary_("0000000000100000000000000001")
    lazy val ofEquiv: ofEquiv                       = Binary_("0000000001100000000000000001")
        type ofEquiv                                = Binary_("0000000001100000000000000001")
    lazy val ofPartialOrdering: ofPartialOrdering   = Binary_("0000000010100000000000000001")
        type ofPartialOrdering                      = Binary_("0000000010100000000000000001")
    lazy val ofOrdering: ofOrdering                 = Binary_("0000000100100000000000000001")
        type ofOrdering                             = Binary_("0000000100100000000000000001")
// Function1s (extends Relation)
    lazy val ofFunction1: ofFunction1               = Binary_("0000001000100000000000000001")
        type ofFunction1                            = Binary_("0000001000100000000000000001")
    lazy val ofPartialFunction: ofPartialFunction   = Binary_("0000011000100000000000000001")
        type ofPartialFunction                      = Binary_("0000011000100000000000000001")
    lazy val ofMap: ofMap                           = Binary_("0000101000100000000000000001")
        type ofMap                                  = Binary_("0000101000100000000000000001")
*/
}
