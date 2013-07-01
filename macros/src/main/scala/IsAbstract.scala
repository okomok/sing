

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


// See: http://stackoverflow.com/questions/15898037/how-to-check-if-weaktypetag-or-type-represents-concrete-type


object IsAbstract extends Predicate1Impl {
     def apply[x](x: x) = macro term_impl[x]
    type apply[x]       = macro type_impl[x]

    override protected def impl(c: Context)(x: c.Type): Boolean = {
        x.typeSymbol.asType.isAbstractType
    }
}
