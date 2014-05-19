

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package example

    import com.github.okomok.sing._

    // These object must be here for implicit Boxer lookup.
    // I don't know why.

    // Notice there is no common super trait.
    class WinButton {
        def paint = "I'm a WinButton"
    }

    class OSXButton {
        def paint = "I'm a OSXButton"
    }

    object WinFactory {
        def createButton = new WinButton
        val ID = Peano._0
    }

    object OSXFactory {
        def createButton = new OSXButton
        val ID = Peano._1
    }

    class AbstractFactoryTest extends org.scalatest.junit.JUnit3Suite {

        // Crossing sing world boundary with explicit boxing
        val factoryMap = ListMap.put(WinFactory.ID, Box(WinFactory)).put(OSXFactory.ID, Box(OSXFactory))

        def createFactory[n <: Nat](n: n) = {
            val option = factoryMap.get(n)
            option.get.unsing
        }

        def testTrivial {
            // Concrete types are preserved.
            val factory = createFactory(WinFactory.ID)
            val button = factory.createButton
            assertResult("I'm a WinButton")(button.paint)
        }
    }

