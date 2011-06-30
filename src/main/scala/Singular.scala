

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


trait Singular extends Any with ReferenceEquality {
    override  def unsing: unsing = self
    override type unsing         = self
}
