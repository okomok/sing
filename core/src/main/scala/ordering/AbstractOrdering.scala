

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package ordering


trait AbstractOrdering extends Ordering {
    final override  def asOrdering: asOrdering = self
    final override type asOrdering             = self

    final override  def lteq[x <: Any, y <: Any](x: x, y: y): lteq[x, y] = compare(x, y).isLTEQ
    final override type lteq[x <: Any, y <: Any]                         = compare[x, y]#isLTEQ

    final override  def gteq[x <: Any, y <: Any](x: x, y: y): gteq[x, y] = compare(x, y).isGTEQ
    final override type gteq[x <: Any, y <: Any]                         = compare[x, y]#isGTEQ

    final override  def lt[x <: Any, y <: Any](x: x, y: y): lt[x, y] = compare(x, y).isLT
    final override type lt[x <: Any, y <: Any]                       = compare[x, y]#isLT

    final override  def gt[x <: Any, y <: Any](x: x, y: y): gt[x, y] = compare(x, y).isGT
    final override type gt[x <: Any, y <: Any]                       = compare[x, y]#isGT

    final override  def `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](x: x, y: y, flt: flt, fgt: fgt, feq: feq): `match`[x, y, flt, fgt, feq] =
        Match(self, x, y, flt, fgt, feq).apply
    final override type `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0] =
        Match[self, x, y, flt, fgt, feq]#apply
}
