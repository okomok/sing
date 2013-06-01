

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package weak


@Annotation.specializer
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

    implicit val _listNil = new TermOf[Nil] {
        override def apply: Nil = Nil
    }
    implicit def _listCons[x <: Any, xs <: List](implicit _termOfX: TermOf[x], _termOfXs: TermOf[xs]) = new TermOf[Cons[x, xs]] {
        override def apply: Cons[x, xs] = new Cons(_termOfX.apply, _termOfXs.apply)
    }


// Dense (contributed by @akihiro4chawon)

    implicit val _natDenseZero = new TermOf[DNil] {
        override def apply: DNil = DNil
    }

    implicit def _natDenseCons[x <: Boolean, xs <: Dense](implicit _termOfX: TermOf[x], _termOfXs: TermOf[xs]) = new TermOf[DCons[x, xs]] {
        override def apply: DCons[x, xs] = DCons(_termOfX.apply, _termOfXs.apply)
    }


// Peano

    implicit val _natPeanoZero = new TermOf[Zero] {
        override def apply: Zero = Zero
    }
    implicit def _natPeanoSucc[n <: Peano](implicit _termOf: TermOf[n]) = new TermOf[Succ[n]] {
        override def apply: Succ[n] = Succ(_termOf.apply)
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
