

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package function


private[sing]
final class Throw0(x: Throwable) extends Function0 {
    type self = Throw0
    override  def apply: apply = throw x
    override type apply        = Nothing
}
