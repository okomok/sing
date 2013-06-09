

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


final case class Throw(what: Throwable) extends AsFunction0 {
    override type self = Throw

    override  def apply: apply = throw what
    override type apply <: Nothing // keep it abstract.
}
