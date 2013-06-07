

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package example

    import com.github.okomok.sing
    import sing.{map, Nat, Box}
    import sing.Dense.Literal._
    import scala.language.existentials


// Buggy implicit macro
//
// needes wildcard imports, and
    import sing._

// needs to be visible from outside.

    // Notice there is no common super trait.
    class WinButton {
        def paint = "I'm a WinButton"
    }
    class OSXButton {
        def paint = "I'm a OSXButton"
    }

    object WinFactory {
        def createButton = new WinButton
        val ID = _0
    }
    object OSXFactory {
        def createButton = new OSXButton
        val ID = _1
    }

    class AbstractFactoryTest extends org.scalatest.junit.JUnit3Suite {
        // Needs explicit boxing to make a sing object from a non-sing one.
        val factoryMap = Map.sorted1(WinFactory.ID, Box(WinFactory)).put(OSXFactory.ID, Box(OSXFactory))

        def createFactory[n <: Nat](n: n) = {
            val option = factoryMap.get(n)
            option.get.unsing
        }

        def testTrivial {
            // Concrete types are preserved.
            val factory = createFactory(WinFactory.ID)
            val button = factory.createButton
            expectResult("I'm a WinButton")(button.paint)
        }
    }

