

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


trait DependentType {
    type apply
}

object DependentType {
    def of[x]: of[x] = new DependentType {
        override type apply = x
    }

    type of[x] = DependentType {
        type apply = x
    }
}
