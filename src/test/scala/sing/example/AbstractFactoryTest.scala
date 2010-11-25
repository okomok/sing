

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package example

    import com.github.okomok.sing
    import sing.{map, Nat, Box}
    import sing.nat.dense.Literal._

    class AbstractFactoryTest extends org.scalatest.junit.JUnit3Suite {
        // Notice there is no common super trait.
        class WinButton {
            def paint = "I'm a WinButton"
        }
        class OSXButton {
            def paint = "I'm a OSXButton"
        }

        object WinFactory {
            def createButton = new WinButton
        }
        object OSXFactory {
            def createButton = new OSXButton
        }

        // Needs explicit boxing to make a sing object from a non-sing one.
        val factoryMap = map.sorted1(_0, Box(WinFactory)).put(_1, Box(OSXFactory))

        def createFactory[n <: Nat](n: n) = {
            val option = factoryMap.get(n)
            option.get.unsung
        }

        def testTrivial {
            // Concrete types are preserved.
            val factory = createFactory(_0)
            val button = factory.createButton
            expect("I'm a WinButton")(button.paint)
        }
    }
