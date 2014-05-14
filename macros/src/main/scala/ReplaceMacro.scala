

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


object ReplaceMacro {
    def apply(c: Context)(parents: List[c.Tree], zuper: c.Tree): List[c.Tree] = {
        parents.map { x =>
            if (x.equalsStructure(c.macroApplication)) zuper else x
        }
    }
}
