

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
final class UnitKind extends AsKind {
    override  def naturalOrdering: naturalOrdering = AlwaysEQ
    override type naturalOrdering                  = AlwaysEQ
}
