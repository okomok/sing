

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.annotation.elidable
import scala.annotation.elidable.ALL
import scala.language.experimental.macros
import scala.reflect.macros.Context


object Test {

    /**
     * Asserts that a condition is true.
     */
    @elidable(ALL)
    def assertTrue(a: `true`): scala.Unit = ()

    /**
     * Asserts that a condition is true.
     */
    @elidable(ALL)
    def assertTrue[a >: `true` <: `true`]: scala.Unit = () // `case class` doesn't work well.

    /**
     * Asserts that a condition is false.
     */
    @elidable(ALL)
    def assertFalse(a: `false`): scala.Unit = ()

    /**
     * Asserts that a condition is false.
     */
    @elidable(ALL)
    def assertFalse[a >: `false` <: `false`]: scala.Unit = ()

    /**
     * Asserts that a type is Nothing.
     */
    @elidable(ALL)
    def assertNothing[A >: Nothing <: Nothing]: scala.Unit = ()

    /**
     * Asserts that a type isn't Nothing.
     */
    def assertNotNothing[A] = macro assertNotNothing_impl[A]

    def assertNotNothing_impl[A: c.WeakTypeTag](c: Context): c.Expr[scala.Unit] = {
        import c.universe._

        if (weakTypeOf[A] =:= weakTypeOf[Nothing]) {
            c.error(c.enclosingPosition, weakTypeOf[A].toString + " is Nothing unexpectedly.")
        }
        reify(())
    }

    /**
     * Asserts that two types refer to the same type.
     */
    @elidable(ALL)
    def assertSame[A >: B <: B, B]: scala.Unit = ()

    /**
     * Asserts that two types don't refer to the same type.
     */
    def assertNotSame[A, B] = macro assertNotSame_impl[A, B]

    def assertNotSame_impl[A: c.WeakTypeTag, B: c.WeakTypeTag](c: Context): c.Expr[scala.Unit] = {
        import c.universe._

        if (weakTypeOf[A] =:= weakTypeOf[B]) {
            c.error(c.enclosingPosition, weakTypeOf[A].toString + " is the same type as " + weakTypeOf[B].toString + " unexpectedly.")
        }
        reify(())
    }

    /**
     * Asserts that <code>A</code> conforms to <code>B</code>.
     */
    @elidable(ALL)
    def assertConforms[A <: B, B]: scala.Unit = ()

    /**
     * Asserts that <code>A</code> doesn't conform to <code>B</code>.
     */
    def assertNotConforms[A, B] = macro assertNotConforms_impl[A, B]

    def assertNotConforms_impl[A: c.WeakTypeTag, B: c.WeakTypeTag](c: Context): c.Expr[scala.Unit] = {
        import c.universe._

        if (weakTypeOf[A] <:< weakTypeOf[B]) {
            c.error(c.enclosingPosition, weakTypeOf[A].toString + " conforms to " + weakTypeOf[B].toString + " unexpectedly.")
        }
        reify(())
    }

    /**
     * Compile-error (any usecase?)
     */
    def error = macro error_impl

    def error_impl(c: Context): c.Expr[scala.Unit] = {
        import c.universe._

        c.error(c.enclosingPosition, "compile-error expectedly.")
        reify(())
    }

    /**
     * Expects a compile-error.
     */
    def expectError(x: _) = macro expectError_impl

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
    def echo[A] = macro echo_impl[A]

    def echo_impl[A: c.WeakTypeTag](c: Context): c.Expr[scala.Unit] = {
        import c.universe._

        c.echo(c.enclosingPosition, weakTypeOf[A].normalize.toString)
        reify(())
    }

}
