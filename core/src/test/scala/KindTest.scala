

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing._
import scala.language.existentials


class KindTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        Test.assertTrue(`true`.is(Nat))
        Test.assertTrue[`true`#is[Nat.type]]

//        Test.echo[`true`.kind#kindId]
//        Test.echo[Nat.kindId]

        Test.assertTrue(`true`.is(Boolean))
        Test.assertTrue[`true`#is[Boolean.type]]

        Test.assertTrue(Peano._1.is(Nat))
        Test.assertTrue[Peano._1#is[Nat.type]]

        Test.assertFalse(Peano._1.is(Boolean))
        Test.assertFalse[Peano._1#is[Boolean.type]]
    }

}
