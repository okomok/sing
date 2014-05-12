

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


private object IsSingmethodAnnotation {

    def apply(c: Context)(an: c.Tree): Boolean = {
        import c.universe._

        val fn = c.typecheck(an).symbol.fullName
        fn == "com.github.okomok.sing.singmethod.<init>"
/*
        an match {
            case Apply(Select(New(id), _), _) => {
                tn.reverse.take(10).reverse == "singmethod"
            }
            case _ => false
        }

*/
    }
}
