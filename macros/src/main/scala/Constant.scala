

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


// See:
//   http://existentialtype.net/2008/07/21/literally-dependent-types/
//   shapeless.SingletonTypes


import scala.language.experimental.macros
import scala.reflect.macros.Context


object ConstantTypeOf {
    type apply[T](x: T) = macro impl[T]

    def impl[T: c.WeakTypeTag](c: Context)(x: c.Expr[T]): c.Tree = {
        import c.universe._

        x.tree match {
            case Literal(c @ Constant(_)) => TypeTree(ConstantType(c))
            case t => c.abort(c.enclosingPosition, show(t) + " is not constant")
        }
    }
}


object ConstantTermOf {
    def apply[T] = macro impl[T]

    def impl[T: c.WeakTypeTag](c: Context): c.Expr[Any] = {
        import c.universe._

        weakTypeOf[T].normalize match {
            case ConstantType(Constant(x)) => c.Expr[Any](Literal(Constant(x)))
            case t => c.abort(c.enclosingPosition, show(t) + " is not constant")
        }
    }
}
