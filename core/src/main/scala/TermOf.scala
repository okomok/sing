

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object termOf {
    /**
     * Term of a type
     */
    def apply[x <: Any](implicit ev: _TermOf[x]): x = ev.apply
}


@Annotation.specializer
@scala.annotation.implicitNotFound("No implicit _TermOf defined for ${x}.")
trait _TermOf[x <: Any] extends scala.Function0[x]


object _TermOf {


// Boolean

    implicit val _true = new _TermOf[`true`] {
        override def apply: `true` = `true`
    }
    implicit val _false = new _TermOf[`false`] {
        override def apply: `false` = `false`
    }


// List

    implicit val _listNil = new _TermOf[Nil] {
        override def apply: Nil = Nil
    }
    implicit def _listCons[x <: Any, xs <: List](implicit _termOfX: _TermOf[x], _termOfXs: _TermOf[xs]) = new _TermOf[Cons[x, xs]] {
        override def apply: Cons[x, xs] = new Cons(_termOfX.apply, _termOfXs.apply)
    }


// Dense (contributed by @akihiro4chawon)

    implicit val _natDenseZero = new _TermOf[DNil] {
        override def apply: DNil = DNil
    }

    implicit def _natDenseCons[x <: Boolean, xs <: Dense](implicit _termOfX: _TermOf[x], _termOfXs: _TermOf[xs]) = new _TermOf[DCons[x, xs]] {
        override def apply: DCons[x, xs] = DCons(_termOfX.apply, _termOfXs.apply)
    }


// Peano

    implicit val _natPeanoZero = new _TermOf[Zero] {
        override def apply: Zero = Zero
    }
    implicit def _natPeanoSucc[n <: Peano](implicit _termOf: _TermOf[n]) = new _TermOf[Succ[n]] {
        override def apply: Succ[n] = Succ(_termOf.apply)
    }


// Unit

    implicit val _Unit = new _TermOf[Unit] {
        override def apply: Unit = Unit
    }


/* Singular

    implicit def _Singular[x <: Singular](implicit m: ClassManifest[x]): _TermOf[x] = new _TermOf[x] {
        override def apply: x = m.erasure.newInstance().asInstanceOf[x]
    }
*/
}
