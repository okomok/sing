

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


@annotation.specializer
@scala.annotation.implicitNotFound("No implicit TermOf defined for ${x}.")
trait TermOf[x <: Any] extends scala.Function0[x]


object TermOf {


// Boolean

    implicit val _true = new TermOf[`true`] {
        override def apply: `true` = `true`
    }
    implicit val _false = new TermOf[`false`] {
        override def apply: `false` = `false`
    }


// List

    implicit val _listNil = new TermOf[list.Nil] {
        override def apply: list.Nil = list.Nil
    }
    implicit def _listCons[x <: Any, xs <: list.List](implicit _termOfX: TermOf[x], _termOfXs: TermOf[xs]) = new TermOf[list.Cons[x, xs]] {
        override def apply: list.Cons[x, xs] = new list.Cons(_termOfX.apply, _termOfXs.apply)
    }


// nat.Dense (contributed by @akihiro4chawon)

    implicit val _natDenseZero = new TermOf[nat.dense.Nil] {
        override def apply: nat.dense.Nil = nat.dense.Nil
    }

    implicit def _natDenseCons[x <: Boolean, xs <: nat.dense.Dense](implicit _termOfX: TermOf[x], _termOfXs: TermOf[xs]) = new TermOf[nat.dense.Cons[x, xs]] {
        override def apply: nat.dense.Cons[x, xs] = nat.dense.Cons(_termOfX.apply, _termOfXs.apply)
    }


// nat.Peano

    implicit val _natPeanoZero = new TermOf[nat.peano.Zero] {
        override def apply: nat.peano.Zero = nat.peano.Zero
    }
    implicit def _natPeanoSucc[n <: nat.peano.Peano](implicit _termOf: TermOf[n]) = new TermOf[nat.peano.Succ[n]] {
        override def apply: nat.peano.Succ[n] = nat.peano.Succ(_termOf.apply)
    }


// Unit

    implicit val _Unit = new TermOf[Unit] {
        override def apply: Unit = Unit
    }


/* Singular

    implicit def _Singular[x <: Singular](implicit m: ClassManifest[x]): TermOf[x] = new TermOf[x] {
        override def apply: x = m.erasure.newInstance().asInstanceOf[x]
    }
*/
}
