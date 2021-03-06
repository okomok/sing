

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.reflect.macros.whitebox.Context


private object AddLazyFlag {
    def apply(c: Context)(mods: c.Modifiers): c.Modifiers = {
        import c.universe._

        val Modifiers(flags, privateWithin, annotations) = mods
        Modifiers(flags | Flag.LAZY, privateWithin, annotations)
    }
}
