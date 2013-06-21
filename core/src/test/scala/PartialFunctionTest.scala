

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import sing.Test._
import scala.language.existentials


class PartialFunctionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val pf = SortedMap.put(Box.empty[Int], Box.empty[AnyVal]).put(Box.empty[String], Box.empty[AnyRef])
        cassertNot {
            pf.related(Box('a'), Box("abc"))
        }
        cassertNot {
            pf.related(Box("hello"), Box(3))
        }
        cassert {
            pf.related(Box(3), Box.empty[AnyVal])
        }
        cassert {
            pf.related(Box.empty[String], Box.empty[AnyRef])
        }
    }

}
