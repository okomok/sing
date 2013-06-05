

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


// How to do it precisely?
object IsSingmethodAnnotation {

    def apply(c: Context)(an: c.Tree): Boolean = {
        import c.universe._

        an match {
            case Apply(Select(New(Ident(TypeName(tn))), _), _) => {
                tn.reverse.take(10).reverse == "singmethod"
            }
            case _ => false
        }
    }
}
