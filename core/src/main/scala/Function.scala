

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


object Function {

    def apply[R](x: () => R): Lift0[R] = Lift0(x)
    def apply[T1, R](x: T1 => R): Lift1[T1, R] = Lift1(x)
    def apply[T1, T2, R](x: (T1, T2) => R): Lift2[T1, T2, R] = Lift2(x)
    def apply[T1, T2, T3, R](x: (T1, T2, T3) => R): Lift3[T1, T2, T3, R] = Lift3(x)

}
