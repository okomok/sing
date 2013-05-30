

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


package object function {

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

}
