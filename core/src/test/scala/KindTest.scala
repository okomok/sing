

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing._
import scala.language.existentials


class KindTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        AssertTrue(`true`.is(Nat))
        AssertTrue[`true`#is[Nat.type]]

//        echo[`true`.kind#kindId]
//        echo[Nat.kindId]

        AssertTrue(`true`.is(Boolean))
        AssertTrue[`true`#is[Boolean.type]]

        AssertTrue(Peano._1.is(Nat))
        AssertTrue[Peano._1#is[Nat.type]]

        AssertFalse(Peano._1.is(Boolean))
        AssertFalse[Peano._1#is[Boolean.type]]
    }

}
