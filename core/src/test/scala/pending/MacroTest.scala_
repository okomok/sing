

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._
//import sing.Peano.Literal._
import junit.framework.Assert._


class MacroTest extends org.scalatest.junit.JUnit3Suite {

    import makro._

    val x = com.github.okomok.sing.DNil

    trait Foo

    class My extends NewKind.apply with Foo with RefEquals {
        val x = 3
    }

    class My2[A <: Foo] extends NewKind.apply with Foo with RefEquals {
        val x = 3
    }
/*
    class MM extends AsBoxed {

    }

    object NN extends AsBoxed {
    }

    case class PP[A](override val unsing: scala.List[A]) extends AsBoxed
*/
//    sing.Weak.printe[My#typeid]

    def testTrivial() {

        //println( new My{}.kindId )


    }

}


