

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.experimental.macros
import scala.reflect.macros.Macro


object assertError {
    /**
     * not-compile assertion
     */
    def apply(x: _) = macro makro.AssertError.impl
}
