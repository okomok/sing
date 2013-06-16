

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import makro.BinaryLiteral.{apply => B_}


private[sing]
object KindId {
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
}
