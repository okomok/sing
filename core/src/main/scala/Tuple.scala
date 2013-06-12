

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Tuple {
    /**
     * Lifts scala.Tuples.
     */
    def lift1[T1](t: scala.Tuple1[T1])(implicit _T1: Boxer[T1]): Tuple1[_T1.box] = Tuple1(_T1.box(t._1))
    def lift2[T1, T2](t: scala.Tuple2[T1, T2])(implicit _T1: Boxer[T1], _T2: Boxer[T2]): Tuple2[_T1.box, _T2.box] = Tuple2(_T1.box(t._1), _T2.box(t._2))
    def lift3[T1, T2, T3](t: scala.Tuple3[T1, T2, T3])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3]): Tuple3[_T1.box, _T2.box, _T3.box] = Tuple3(_T1.box(t._1), _T2.box(t._2), _T3.box(t._3))
}
