

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
//import sing.nat.peano.Literal._
import junit.framework.Assert._


class MacroTest extends org.scalatest.junit.JUnit3Suite {

    import Macros._

    val x = com.github.okomok.sing.nat.dense.Nil

    trait Foo

    class My extends NewKind with Foo with ReferenceEquality {
        val x = 3
    }

    class My2[A <: Foo] extends NewKind with Foo with ReferenceEquality {
        val x = 3
    }

    class MM extends AsBoxed {

    }

    object NN extends AsBoxed {
    }

    case class PP[A](override val unsing: scala.List[A]) extends AsBoxed

//    sing.weak.printe[My#typeid]

    def testTrivial() {

    println( new My{}.kindId )


    }

}


