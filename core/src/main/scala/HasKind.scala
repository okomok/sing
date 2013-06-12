

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait HasKind {
     def kind: kind
    type kind <: Kind
}
