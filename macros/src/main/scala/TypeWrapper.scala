

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait TypeWrapper {
    type unwrap
}


object TypeWrapper {
    def of[x]: of[x] = new TypeWrapper {
        override type unwrap = x
    }

    type of[x] = TypeWrapper {
        type unwrap = x
    }
}
