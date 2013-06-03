

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


object Function {

    /**
     * The unary constant function
     */
     def const0[v <: Any](v: => v): const0[v] = new Const0(v)
    type const0[v <: Any]                     =     Const0[v]

    /**
     * The identity function
     */
     val identity: identity = new Identity
    type identity           =     Identity

    /**
     * An unary function to throw an exception
     */
     def throw0(x: Throwable) = new Throw0(x)
    type throw0[_]            =     Throw0

    /**
     * Lifts scala.Functions
     */
    def lift0[R](f: () => R)(implicit _R: BoxKind[R]): Lift0[R, _R.self] = new Lift0[R, _R.self](f, _R)
    def lift1[T1, R](f: T1 => R)(implicit _R: BoxKind[R]): Lift1[T1, R, _R.self] = new Lift1[T1, R, _R.self](f, _R)
    def lift2[T1, T2, R](f: (T1, T2) => R)(implicit _R: BoxKind[R]): Lift2[T1, T2, R, _R.self] = new Lift2[T1, T2, R, _R.self](f, _R)
    def lift3[T1, T2, T3, R](f: (T1, T2, T3) => R)(implicit _R: BoxKind[R]): Lift3[T1, T2, T3, R, _R.self] = new Lift3[T1, T2, T3, R, _R.self](f, _R)

}
