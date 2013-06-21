

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing._
import scala.language.existentials


class KindTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        Test.cassert(`true`.is(Nat))
        Test.cassert[`true`#is[Nat.type]]

//        Test.echo[`true`.kind#kindId]
//        Test.echo[Nat.kindId]

        Test.cassert(`true`.is(Boolean))
        Test.cassert[`true`#is[Boolean.type]]

        Test.cassert(Peano._1.is(Nat))
        Test.cassert[Peano._1#is[Nat.type]]

        Test.cassertNot(Peano._1.is(Boolean))
        Test.cassertNot[Peano._1#is[Boolean.type]]
    }

}
