

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.annotation.elidable
import scala.annotation.elidable.ALL
import scala.language.experimental.macros
import scala.reflect.macros.Context


object Test {


    // scala.Unit is used to suppress a warning.


    /**
     * Ignores an expression, or places a type in term expressions.
     */
    @elidable(ALL)
     def ignore[x](x: x): ignore[x] = ()
    type ignore[x]                  = scala.Unit


    // Typemethod forms don't work correctly in fact.


    /**
     * Asserts that a condition is true.
     */
    @elidable(ALL)
     def assertTrue[x >: `true` <: `true`](implicit x: x = unused[x]): assertTrue[`true`] = () // implicit for `assertTrue[x]` to be well-formed.
    type assertTrue[x >: `true` <: `true`]                                                = scala.Unit


    /**
     * Asserts that a condition is false.
     */
    @elidable(ALL)
     def assertFalse[x >: `false` <: `false`](implicit x: x = unused[x]): assertFalse[`false`] = ()
    type assertFalse[x >: `false` <: `false`]                                                  = scala.Unit


    /**
     * Asserts that a type is Nothing.
     */
    @elidable(ALL)
     def assertNothing[x >: Nothing <: Nothing](implicit x: x = unused[x]): assertNothing[x] = ()
    type assertNothing[x >: Nothing <: Nothing]                                              = scala.Unit


    /**
     * Asserts that a type isn't Nothing.
     */
     def assertNotNothing[x]: scala.Unit       = macro assertNotNothing_term_impl_[x]
     def assertNotNothing[x](x: x): scala.Unit = macro assertNotNothing_term_impl[x]
    type assertNotNothing[x]                   = macro assertNotNothing_type_impl[x]

    def assertNotNothing_term_impl_[x](c: Context)(implicit xt: c.WeakTypeTag[x]): c.Expr[scala.Unit] = {
        import c.universe._
        _assertNotNothing_impl(c)(xt)
        reify(())
    }

    def assertNotNothing_term_impl[x](c: Context)(x: c.Expr[x])(implicit xt: c.WeakTypeTag[x]): c.Expr[scala.Unit] = {
        import c.universe._
        _assertNotNothing_impl(c)(xt)
        reify(())
    }

    def assertNotNothing_type_impl[x: c.WeakTypeTag](c: Context)(implicit xt: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        _assertNotNothing_impl(c)(xt)
        tq"scala.Unit"
    }

    private def _assertNotNothing_impl[x](c: Context)(xt: c.WeakTypeTag[x]) {
        import c.universe._
        if (weakTypeOf(xt) =:= weakTypeOf[Nothing]) {
            c.error(c.enclosingPosition, show(weakTypeOf[x]) + " is Nothing unexpectedly.")
        }
    }


    /**
     * Asserts that two types refer to the same type.
     */
    @elidable(ALL)
     def assertSame[x >: y <: y, y](implicit x: x = unused[x], y: y = unused[y]): assertSame[x, y] = ()
    type assertSame[x >: y <: y, y]                                                                = scala.Unit


    /**
     * Asserts that two types don't refer to the same type.
     */
    def assertNotSame[x, y]: scala.Unit             = macro assertNotSame_term_impl_[x, y]
    def assertNotSame[x, y](x: x, y: y): scala.Unit = macro assertNotSame_term_impl[x, y]
   type assertNotSame[x, y]                         = macro assertNotSame_type_impl[x, y]

    def assertNotSame_term_impl_[x, y](c: Context)(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Expr[scala.Unit] = {
        import c.universe._
        _assertNotSame_impl(c)(xt, yt)
        reify(())
    }

    def assertNotSame_term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Expr[scala.Unit] = {
        import c.universe._
        _assertNotSame_impl(c)(xt, yt)
        reify(())
    }

    def assertNotSame_type_impl[x, y](c: Context)(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._
        _assertNotSame_impl(c)(xt, yt)
        tq"scala.Unit"
    }

    private def _assertNotSame_impl[x, y](c: Context)(xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]) {
        import c.universe._
        if (weakTypeOf(xt) =:= weakTypeOf(yt)) {
            c.error(c.enclosingPosition, show(weakTypeOf(xt)) + " is the same type as " + show(weakTypeOf(yt)) + " unexpectedly.")
        }
    }


    /**
     * Asserts that <code>A</code> conforms to <code>B</code>.
     */
    @elidable(ALL)
     def assertConforms[x <: y, y](implicit x: x = unused[x], y: y = unused[y]): assertConforms[x, y] = Unit
    type assertConforms[x <: y, y]                                                                    = Unit


    /**
     * Asserts that <code>A</code> doesn't conform to <code>B</code>.
     */
     def assertNotConforms[x, y]: scala.Unit             = macro assertNotConforms_term_impl_[x, y]
     def assertNotConforms[x, y](x: x, y: y): scala.Unit = macro assertNotConforms_term_impl[x, y]
    type assertNotConforms[x, y]                         = macro assertNotConforms_type_impl[x, y]

    def assertNotConforms_term_impl_[x, y](c: Context)(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Expr[scala.Unit] = {
        import c.universe._
        _assertNotConforms_impl(c)(xt, yt)
        reify(())
    }

    def assertNotConforms_term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Expr[scala.Unit] = {
        import c.universe._
        _assertNotConforms_impl(c)(xt, yt)
        reify(())
    }

    def assertNotConforms_type_impl[x, y](c: Context)(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._
        _assertNotConforms_impl(c)(xt, yt)
        tq"scala.Unit"
    }

    private def _assertNotConforms_impl[x, y](c: Context)(xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]) {
        import c.universe._
        if (weakTypeOf(xt) <:< weakTypeOf(yt)) {
            c.error(c.enclosingPosition, show(weakTypeOf[x]) + " conforms to " + show(weakTypeOf[y]) + " unexpectedly.")
        }
    }


    /**
     * Compile-error (any usecase?)
     */
     def error: scala.Unit = macro error_term_impl
    type error             = macro error_type_impl

    def error_term_impl(c: Context): c.Expr[scala.Unit] = {
        import c.universe._
        _error_impl(c)
        reify(())
    }

    def error_type_impl(c: Context): c.Tree = {
        import c.universe._
        _error_impl(c)
        tq"scala.Unit"
    }

    private def _error_impl(c: Context) {
        import c.universe._
        c.error(c.enclosingPosition, "compile-error expectedly.")
    }


    /**
     * Expects a compile-error.
     */
    def expectError(x: _): scala.Unit = macro expectError_impl

    // Thanks to: https://gist.github.com/travisbrown/5066283
    def expectError_impl(c: Context)(x: c.Tree): c.Expr[scala.Unit] = {
        import c.universe._

        if (c.typeCheck(x, silent = true) != EmptyTree) {
            c.error(c.enclosingPosition, show(x) + " compiles unexpectedly.")
        }
        reify(())
    }


    /**
     * Prints a type name.
     */
     def echo[x]: scala.Unit = macro echo_term_impl[x]
    type echo[x]             = macro echo_type_impl[x]

    def echo_term_impl[x](c: Context)(implicit xt: c.WeakTypeTag[x]): c.Expr[scala.Unit] = {
        import c.universe._
        _echo_impl(c)(xt)
        reify(())
    }

    def echo_type_impl[x](c: Context)(implicit xt: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        _echo_impl(c)(xt)
        tq"scala.Unit"
    }

    private def _echo_impl[x](c: Context)(xt: c.WeakTypeTag[x]) {
        import c.universe._
        c.echo(c.enclosingPosition, weakTypeOf(xt).normalize.toString)
    }

}
