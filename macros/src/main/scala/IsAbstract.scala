

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


// See: http://stackoverflow.com/questions/15898037/how-to-check-if-weaktypetag-or-type-represents-concrete-type


object IsAbstract {

    def apply[T: c.WeakTypeTag](c: Context): Boolean = {
        import c.universe._
        weakTypeOf[T].typeSymbol.asType.isAbstractType
    }
}
