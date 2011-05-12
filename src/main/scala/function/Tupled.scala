

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package function


private[sing]
object Tupled2 {

    final case class Impl[f <: Function2](f: f) extends Function1 {
        type self = Impl[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = _aux(v1.asProduct2)
        override type apply[v1 <: Any]                    = _aux[v1#asProduct2]

        private[this]  def _aux[p <: Product2](p: p): _aux[p] = f.apply(p._1, p._2)
        private[this] type _aux[p <: Product2]                = f#apply[p#_1, p#_2]
    }

}


private[sing]
object Tupled3 {

    final case class Impl[f <: Function3](f: f) extends Function1 {
        type self = Impl[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = _aux(v1.asProduct3)
        override type apply[v1 <: Any]                    = _aux[v1#asProduct3]

        private[this]  def _aux[p <: Product3](p: p): _aux[p] = f.apply(p._1, p._2, p._3)
        private[this] type _aux[p <: Product3]                = f#apply[p#_1, p#_2, p#_3]
    }

}


private[sing]
object TupledLeft3 {

    final case class Impl[f <: Function3](f: f) extends Function1 {
        type self = Impl[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = _aux(v1.asProduct2)
        override type apply[v1 <: Any]                    = _aux[v1#asProduct2]

        private[this]  def _aux[p <: Product2](p: p): _aux[p] = _aux2(p._1.asProduct2, p._2)
        private[this] type _aux[p <: Product2]                = _aux2[p#_1#asProduct2, p#_2]

        private[this]  def _aux2[p <: Product2, v3 <: Any](p: p, v3: v3): _aux2[p, v3] = f.apply(p._1, p._2, v3)
        private[this] type _aux2[p <: Product2, v3 <: Any]                             = f#apply[p#_1, p#_2, v3]
    }

}
