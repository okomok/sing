

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


package object tuple {

     def Lift1[T1](t: scala.Tuple1[T1]): Lift1[T1] = Tuple1(Box(t._1))
    type Lift1[T1]                                 = Tuple1[Box[T1]]

     def Lift2[T1, T2](t: scala.Tuple2[T1, T2]): Lift2[T1, T2] = Tuple2(Box(t._1), Box(t._2))
    type Lift2[T1, T2]                                         = Tuple2[Box[T1], Box[T2]]

     def Lift3[T1, T2, T3](t: scala.Tuple3[T1, T2, T3]): Lift3[T1, T2, T3] = Tuple3(Box(t._1), Box(t._2), Box(t._3))
    type Lift3[T1, T2, T3]                                                 = Tuple3[Box[T1], Box[T2], Box[T3]]

}
