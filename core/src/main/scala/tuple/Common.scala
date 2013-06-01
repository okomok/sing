

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package tuple


trait Common {

    /**
     * Lifts scala.Tuples.
     */
    def lift1[T1](t: scala.Tuple1[T1])(implicit _T1: BoxKind[T1]): Tuple1[Box[T1, _T1.self]] = Tuple1(Box(t._1)(_T1))
    def lift2[T1, T2](t: scala.Tuple2[T1, T2])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2]): Tuple2[Box[T1, _T1.self], Box[T2, _T2.self]] = Tuple2(Box(t._1)(_T1), Box(t._2)(_T2))
    def lift3[T1, T2, T3](t: scala.Tuple3[T1, T2, T3])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3]): Tuple3[Box[T1, _T1.self], Box[T2, _T2.self], Box[T3, _T3.self]] = Tuple3(Box(t._1)(_T1), Box(t._2)(_T2), Box(t._3)(_T3))

    @annotation.obsolete("Use liftN instead.")
    def Lift1[T1](t: scala.Tuple1[T1])(implicit _T1: BoxKind[T1]): Tuple1[Box[T1, _T1.self]] = Tuple1(Box(t._1)(_T1))
    def Lift2[T1, T2](t: scala.Tuple2[T1, T2])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2]): Tuple2[Box[T1, _T1.self], Box[T2, _T2.self]] = Tuple2(Box(t._1)(_T1), Box(t._2)(_T2))
    def Lift3[T1, T2, T3](t: scala.Tuple3[T1, T2, T3])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3]): Tuple3[Box[T1, _T1.self], Box[T2, _T2.self], Box[T3, _T3.self]] = Tuple3(Box(t._1)(_T1), Box(t._2)(_T2), Box(t._3)(_T3))

    @annotation.obsolete("Use liftN instead.")
    def apply[T1](t: scala.Tuple1[T1])(implicit _T1: BoxKind[T1]): Tuple1[Box[T1, _T1.self]] = Tuple1(Box(t._1)(_T1))
    def apply[T1, T2](t: scala.Tuple2[T1, T2])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2]): Tuple2[Box[T1, _T1.self], Box[T2, _T2.self]] = Tuple2(Box(t._1)(_T1), Box(t._2)(_T2))
    def apply[T1, T2, T3](t: scala.Tuple3[T1, T2, T3])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3]): Tuple3[Box[T1, _T1.self], Box[T2, _T2.self], Box[T3, _T3.self]] = Tuple3(Box(t._1)(_T1), Box(t._2)(_T2), Box(t._3)(_T3))

}
