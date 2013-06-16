

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


// See: http://stackoverflow.com/questions/15898037/how-to-check-if-weaktypetag-or-type-represents-concrete-type


object AssertConcrete {
    def apply[T: c.WeakTypeTag](c: Context) {
        import c.universe._

        val t = weakTypeOf[T]
        if (t.typeSymbol.asType.isAbstractType) {
            c.error(c.enclosingPosition, show(t) + " is abstract.")
        }
    }
}

