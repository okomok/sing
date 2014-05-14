

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


trait DependentType {
     def self: self
    type self
}


object DependentType {
    type Of[x] = DependentType {
        type self = x
    }

    def apply[x](x: x): Of[x] = new DependentType {
        override  def self: self = x
        override type self       = x
    }
}
