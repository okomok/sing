

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


object RemoveMacro {
    def apply(c: Context)(parents: List[c.Tree]): List[c.Tree] = {
        parents.filter { x =>
            !x.equalsStructure(c.macroApplication)
        }
    }
}
