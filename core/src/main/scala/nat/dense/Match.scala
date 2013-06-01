

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
final case class Match[xs <: Dense, ys <: Dense, nn <: Function0, nc <: Function0, cn <: Function0, cc <: Function0](xs: xs, ys: ys, nn: nn, nc: nc, cn: cn, cc: cc) extends Function0 {
    type self = Match[xs, ys, nn, nc, cn, cc]
    override  def apply: apply = `if`(xs.isZero, `if`(ys.isZero, nn, nc), `if`(ys.isZero, cn, cc)).apply.asInstanceOf[apply]
    override type apply        = `if`[xs#isZero, `if`[ys#isZero, nn, nc], `if`[ys#isZero, cn, cc]]#apply
}

private[sing]
final case class ConsMatch[xs <: Dense, ys <: Dense, tt <: Function0, tf <: Function0, ft <: Function0, ff <: Function0](xs: xs, ys: ys, tt: tt, tf: tf, ft: ft, ff: ff) extends Function0 {
    type self = ConsMatch[xs, ys, tt, tf, ft, ff]
    override  def apply: apply = `if`(xs.head, `if`(ys.head, tt, tf), `if`(ys.head, ft, ff)).apply.asInstanceOf[apply]
    override type apply        = `if`[xs#head, `if`[ys#head, tt, tf], `if`[ys#head, ft, ff]]#apply
}


/*
private[sing]
final class Match {
     def apply[xs <: Dense, ys <: Dense, nn <: Function0, nc <: Function0, cn <: Function0, cc <: Function0](xs: xs, ys: ys, nn: nn, nc: nc, cn: cn, cc: cc): apply[xs, ys, nn, nc, cn, cc] =
        `if`(xs.isZero, `if`(ys.isZero, nn, nc), `if`(ys.isZero, cn, cc)).apply.asInstanceOf[apply[xs, ys, nn, nc, cn, cc]]
    type apply[xs <: Dense, ys <: Dense, nn <: Function0, nc <: Function0, cn <: Function0, cc <: Function0] =
        `if`[xs#isZero, `if`[ys#isZero, nn, nc], `if`[ys#isZero, cn, cc]]#apply
}
*/
