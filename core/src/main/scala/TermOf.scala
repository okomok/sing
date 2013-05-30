

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


@annotation.specializer
@scala.annotation.implicitNotFound("No implicit TermOf defined for ${x}.")
trait TermOf[x <: Any] extends scala.Function0[x]


object TermOf {


// Boolean

    implicit val _ofTrue = new TermOf[`true`] {
        override def apply: `true` = `true`
    }
    implicit val _ofFalse = new TermOf[`false`] {
        override def apply: `false` = `false`
    }


// List

    implicit val _ofListNil = new TermOf[list.Nil] {
        override def apply: list.Nil = list.Nil
    }
    implicit def _ofListCons[x <: Any, xs <: list.List](implicit _unmetaX: TermOf[x], _unmetaXs: TermOf[xs]) = new TermOf[list.Cons[x, xs]] {
        override def apply: list.Cons[x, xs] = new list.Cons(_unmetaX.apply, _unmetaXs.apply)
    }


// nat.Dense (contributed by @akihiro4chawon)

    implicit val _ofNatDenseZero = new TermOf[nat.dense.Nil] {
        override def apply: nat.dense.Nil = nat.dense.Nil
    }

    implicit def _ofNatDenseCons[x <: Boolean, xs <: nat.dense.Dense](implicit _unmetaX: TermOf[x], _unmetaXs: TermOf[xs]) = new TermOf[nat.dense.Cons[x, xs]] {
        override def apply: nat.dense.Cons[x, xs] = nat.dense.Cons(_unmetaX.apply, _unmetaXs.apply)
    }


// nat.Peano

    implicit val _ofNatPeanoZero = new TermOf[nat.peano.Zero] {
        override def apply: nat.peano.Zero = nat.peano.Zero
    }
    implicit def _ofNatPeanoSucc[n <: nat.peano.Peano](implicit _unmeta: TermOf[n]) = new TermOf[nat.peano.Succ[n]] {
        override def apply: nat.peano.Succ[n] = nat.peano.Succ(_unmeta.apply)
    }


// Unit

    implicit val _ofUnit = new TermOf[Unit] {
        override def apply: Unit = Unit
    }


/* Singular

    implicit def _ofSingular[x <: Singular](implicit m: ClassManifest[x]): TermOf[x] = new TermOf[x] {
        override def apply: x = m.erasure.newInstance().asInstanceOf[x]
    }
*/
}
