

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _dense


private[sing]
final case class Match[xs <: Dense, ys <: Dense, nn <: Function0, nc <: Function0, cn <: Function0, cc <: Function0](xs: xs, ys: ys, nn: nn, nc: nc, cn: cn, cc: cc) extends AsFunction0 {
    override type self = Match[xs, ys, nn, nc, cn, cc]
    override  def apply: apply = `if`(id(xs).isZero, `if`(id(ys).isZero, nn, nc), `if`(id(ys).isZero, cn, cc)).apply
    override type apply        = `if`[id[xs]#isZero, `if`[id[ys]#isZero, nn, nc], `if`[id[ys]#isZero, cn, cc]]#apply
}

private[sing]
final case class DConsMatch[xs <: Dense, ys <: Dense, tt <: Function0, tf <: Function0, ft <: Function0, ff <: Function0](xs: xs, ys: ys, tt: tt, tf: tf, ft: ft, ff: ff) extends AsFunction0 {
    override type self = DConsMatch[xs, ys, tt, tf, ft, ff]
    override  def apply: apply = `if`(id(xs).head, `if`(id(ys).head, tt, tf), `if`(id(ys).head, ft, ff)).apply
    override type apply        = `if`[id[xs]#head, `if`[id[ys]#head, tt, tf], `if`[id[ys]#head, ft, ff]]#apply
}


/*
private[sing]
final class Match {
     def apply[xs <: Dense, ys <: Dense, nn <: Function0, nc <: Function0, cn <: Function0, cc <: Function0](xs: xs, ys: ys, nn: nn, nc: nc, cn: cn, cc: cc): apply[xs, ys, nn, nc, cn, cc] =
        `if`(xs.isZero, `if`(ys.isZero, nn, nc), `if`(ys.isZero, cn, cc)).apply
    type apply[xs <: Dense, ys <: Dense, nn <: Function0, nc <: Function0, cn <: Function0, cc <: Function0] =
        `if`[xs#isZero, `if`[ys#isZero, nn, nc], `if`[ys#isZero, cn, cc]]#apply
}
*/
