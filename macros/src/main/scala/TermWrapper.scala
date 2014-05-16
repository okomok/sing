

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait TermWrapper extends TypeWrapper {
     def apply: apply
}


object TermWrapper {
    def of[x](x: x): of[x] = new TermWrapper {
        override  def apply: apply = x
        override type apply        = x
    }

    type of[x] = TermWrapper {
        type apply = x
    }

}
