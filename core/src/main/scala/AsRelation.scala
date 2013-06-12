

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsRelation extends Relation with AsAny with RefEquals {
    override  def asRelation: asRelation = self
    override type asRelation             = self
}
