

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


trait DependentTerm extends DependentType {
     def apply: apply
}

object DependentTerm {
    def of[x](x: x): of[x] = new DependentTerm {
        override  def apply: apply = x
        override type apply        = x
    }

    type of[x] = DependentTerm {
        type apply = x
    }

}
