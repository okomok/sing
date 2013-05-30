

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object ConsFalse {
     def apply[xs <: Dense](xs: xs): apply[xs] = `if`(xs.isZero, const0(xs), const0(Cons(`false`, xs))).apply
    type apply[xs <: Dense]                    = `if`[xs#isZero, const0[xs], const0[Cons[`false`, xs]]]#apply
}
