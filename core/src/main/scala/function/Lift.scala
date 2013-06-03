

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package function


import scala.language.existentials


private[sing]
final class Lift0[R, _R <: BoxKind[R]](override val unsing: () => R, _R: _R) extends AsFunction0 {
    override type self = Lift0[R, _R]
    override type unsing = () => R

    override  def apply: apply = _R.box(unsing())
    override type apply        = _R#box

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Lift0[_, _]]
}


private[sing]
final class Lift1[T1, R, _R <: BoxKind[R]](override val unsing: T1 => R, _R: _R) extends AsFunction1 {
    override type self = Lift1[T1, R, _R]
    override type unsing = T1 => R

    override  def apply[v1 <: Any](v1: v1): apply[v1] = _R.box(unsing(v1.unsing.asInstanceOf[T1]))
    override type apply[v1 <: Any]                    = _R#box

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Lift1[_, _, _]]
}


private[sing]
final class Lift2[T1, T2, R, _R <: BoxKind[R]](override val unsing: (T1, T2) => R, _R: _R) extends AsFunction2  {
    override type self = Lift2[T1, T2, R, _R]
    override type unsing = (T1, T2) => R

    override  def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2] = _R.box(unsing(v1.unsing.asInstanceOf[T1], v2.unsing.asInstanceOf[T2]))
    override type apply[v1 <: Any, v2 <: Any]                                = _R#box

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Lift2[_, _, _, _]]
}


private[sing]
final class Lift3[T1, T2, T3, R, _R <: BoxKind[R]](override val unsing: (T1, T2, T3) => R, _R: _R) extends AsFunction3 {
    override type self = Lift3[T1, T2, T3, R, _R]
    override type unsing = (T1, T2, T3) => R

    override  def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3] = _R.box(unsing(v1.unsing.asInstanceOf[T1], v2.unsing.asInstanceOf[T2], v3.unsing.asInstanceOf[T3]))
    override type apply[v1 <: Any, v2 <: Any, v3 <: Any]                                            = _R#box

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Lift3[_, _, _, _, _]]
}
