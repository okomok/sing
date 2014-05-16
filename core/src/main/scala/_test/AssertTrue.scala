

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _test


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import makro._


class AssertTrueImpl(override val c: Context) extends AssertImpl1 {
    import c.universe._

    override protected def assert_type_only(x: c.Type): AssertResult = {
        if (x =:= weakTypeOf[`true`]) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " required to be `true`.")
        }
    }
}


class AssertFalseImpl(override val c: Context) extends AssertImpl1 {
    import c.universe._
    override protected def assert_type_only(x: c.Type): AssertResult = {
        if (x =:= weakTypeOf[`false`]) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " required to be `false`.")
        }
    }
}
