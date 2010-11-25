

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


import tuple._


object Tuple {

    def apply[T1](v1: T1): Lift1[T1] = Lift1(scala.Tuple1(v1))
    def apply[T1, T2](v1: T1, v2: T2): Lift2[T1, T2] = Lift2((v1, v2))
    def apply[T1, T2, T3](v1: T1, v2: T2, v3: T3): Lift3[T1, T2, T3] = Lift3((v1, v2, v3))

}
