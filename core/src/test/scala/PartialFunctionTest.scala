

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._

import scala.language.existentials


class PartialFunctionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val pf = ListMap.put(Box.empty[Int], Box.empty[AnyVal]).put(Box.empty[String], Box.empty[AnyRef])
        AssertFalse {
            pf.related(Box('a'), Box("abc"))
        }
        AssertFalse {
            pf.related(Box("hello"), Box(3))
        }
        AssertTrue {
            pf.related(Box(3), Box.empty[AnyVal])
        }
        AssertTrue {
            pf.related(Box.empty[String], Box.empty[AnyRef])
        }
    }

}
