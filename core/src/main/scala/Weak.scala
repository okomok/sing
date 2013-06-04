

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.annotation.elidable
import scala.annotation.elidable.ALL
import scala.language.experimental.macros
import scala.reflect.macros.Macro


import weak._


object Weak {

    /**
     * assertion
     */
    @elidable(ALL)
    def assert(a: `true`): scala.Unit = ()

    /**
     * type assertion
     */
    // @elidable(ALL) crashes compiler.
    def assert[a >: `true` <: `true`]: scala.Unit = () // `case class` doesn't work well.

    /**
     * negative assertion
     */
    @elidable(ALL)
    def assertNot(a: `false`): scala.Unit = ()

    /**
     * negative type assertion
     */
    def assertNot[a >: `false` <: `false`]: scala.Unit = ()

    /**
     * type assertion of identity equality
     */
    def assertSame[a >: b <: b, b]: scala.Unit = ()

    /**
     * type assertion if <code>a</code> is lower than <code>b</code>.
     */
    def assertConforms[a <: b, b]: scala.Unit = ()

    /**
     * type assertion for terms
     */
    def assertTypeOf[x <: Any](y: Any)(implicit i: x =:= y.self): scala.Unit = ()

    /**
     * Prints a type-name as a compile-error.
     * (type-alias isn't expanded.)
     */
    def printe[T](implicit i: Printe[T]): scala.Unit = ()

}

