

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


import scala.language.implicitConversions


private[sing]
trait ToSTuple {

    sealed class _Of1[_this <: List](_this: _this) {
        def toSTuple: scala.Tuple1[_this#head#unsing] = scala.Tuple1(_this.head.unsing)
    }
    implicit def _of1[a1 <: Any](_this: a1 :: Nil): _Of1[a1 :: Nil] = new _Of1(_this)

    sealed class _Of2[_this <: List](_this: _this) {
        def toSTuple: scala.Tuple2[_this#head#unsing, _this#tail#head#unsing] = scala.Tuple2(_this.head.unsing, _this.tail.head.unsing)
    }
    implicit def _of2[a1 <: Any, a2 <: Any](_this: a1 :: a2 :: Nil): _Of2[a1 :: a2 :: Nil] = new _Of2(_this)

    sealed class _Of3[_this <: List](_this: _this) {
        def toSTuple: scala.Tuple3[_this#head#unsing, _this#tail#head#unsing, _this#tail#tail#head#unsing] = scala.Tuple3(_this.head.unsing, _this.tail.head.unsing, _this.tail.tail.head.unsing)
    }
    implicit def _of3[a1 <: Any, a2 <: Any, a3 <: Any](_this: a1 :: a2 :: a3 :: Nil): _Of3[a1 :: a2 :: a3 :: Nil] = new _Of3(_this)

    sealed class _Of4[_this <: List](_this: _this) {
        def toSTuple: scala.Tuple4[_this#head#unsing, _this#tail#head#unsing, _this#tail#tail#head#unsing, _this#tail#tail#tail#head#unsing] = scala.Tuple4(_this.head.unsing, _this.tail.head.unsing, _this.tail.tail.head.unsing, _this.tail.tail.tail.head.unsing)
    }
    implicit def _of4[a1 <: Any, a2 <: Any, a3 <: Any, a4 <: Any](_this: a1 :: a2 :: a3 :: a4 :: Nil): _Of4[a1 :: a2 :: a3 :: a4 :: Nil] = new _Of4(_this)

    sealed class _Of5[_this <: List](_this: _this) {
        def toSTuple: scala.Tuple5[_this#head#unsing, _this#tail#head#unsing, _this#tail#tail#head#unsing, _this#tail#tail#tail#head#unsing, _this#tail#tail#tail#tail#head#unsing] = scala.Tuple5(_this.head.unsing, _this.tail.head.unsing, _this.tail.tail.head.unsing, _this.tail.tail.tail.head.unsing, _this.tail.tail.tail.tail.head.unsing)
    }
    implicit def _of5[a1 <: Any, a2 <: Any, a3 <: Any, a4 <: Any, a5 <: Any](_this: a1 :: a2 :: a3 :: a4 :: a5 :: Nil): _Of5[a1 :: a2 :: a3 :: a4 :: a5 :: Nil] = new _Of5(_this)

}
