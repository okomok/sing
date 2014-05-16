

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.reflect.macros.whitebox.Context


// See:
//   http://stackoverflow.com/questions/15898037/how-to-check-if-weaktypetag-or-type-represents-concrete-type


object IsAbstractType {
    def apply(c: Context)(x: c.Type): scala.Boolean = {
        x.typeSymbol.asType.isAbstract
    }
}
