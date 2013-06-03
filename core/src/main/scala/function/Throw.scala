

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package function


private[sing]
final class Throw0(x: Throwable) extends AsFunction0 {
    override type self = Throw0
    override  def apply: apply = throw x
    override type apply        = Nothing
}
