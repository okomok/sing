

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait TermWrapper extends TypeWrapper {
     def unwrap: unwrap
}


object TermWrapper {
    def of[x](x: x): of[x] = new TermWrapper {
        override  def unwrap: unwrap = x
        override type unwrap         = x
    }

    type of[x] = TermWrapper {
        type unwrap = x
    }
}
