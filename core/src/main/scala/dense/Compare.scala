

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package dense


private[sing]
object Equal {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, Const(`true`), Const(`false`), Const(`false`), CaseCC(xs, ys)).apply.asBoolean
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, Const[`true`], Const[`false`], Const[`false`], CaseCC[xs, ys]]#apply#asBoolean

    case class CaseCC[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseCC[xs, ys]
        override  def apply: apply = `if`(id(xs).head.nequal(id(ys).head), Const(`false`), Else(xs, ys)).apply
        override type apply        = `if`[id[xs]#head#nequal[id[ys]#head], Const[`false`], Else[xs, ys]]#apply
    }

    // for short-circuit.
    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = Else[xs, ys]
        override  def apply: apply = id(xs).tail.equal(id(ys).tail)
        override type apply        = id[xs]#tail#equal[id[ys]#tail]
    }
}


private[sing]
object Lt {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, Const(`false`), Const(`true`), Const(`false`),
            DConsMatch(xs, ys, CaseXXorTF(xs, ys), CaseXXorTF(xs, ys), CaseFT(xs, ys), CaseXXorTF(xs, ys))).apply.asBoolean
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, Const[`false`], Const[`true`], Const[`false`],
            DConsMatch[xs, ys, CaseXXorTF[xs, ys], CaseXXorTF[xs, ys], CaseFT[xs, ys], CaseXXorTF[xs, ys]]]#apply#asBoolean

    case class CaseXXorTF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseXXorTF[xs, ys]
        override  def apply: apply = xs.tail.lt(ys.tail)
        override type apply        = xs#tail#lt[ys#tail]
    }

    case class CaseFT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseFT[xs, ys]
        override  def apply: apply = id(ys).tail.lt(id(xs).tail).not
        override type apply        = id[ys]#tail#lt[id[xs]#tail]#not
    }
}
