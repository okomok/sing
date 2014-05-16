

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok

import okomok.sing._
//import junit.framework.Assert._

import okomok.sing.Peano.Literal._
import okomok.sing.Peano
//import boolean.Operator._


class BooleanTest extends org.scalatest.junit.JUnit3Suite {
    def testConvert {
        import junit.framework.Assert._
        assertEquals(true, `true`.unsing)
        assertEquals(false, `false`.unsing)
        assertEquals(`true`, `true`)
        assertEquals(`false`, `false`)
        AssertNotEquals(`false`, `true`)

    }

    trait testTrivial {
        AssertEq[scala.Boolean, `true`#unsing]
        AssertEq[`true`, `true`]
     //   AssertTrue[`false` === if_Boolean[`true`, `false`, `true`]]
     //   AssertTrue[`false` === if_Boolean[`false`, `true`, `false`]]

    //    AssertEq[`false`, if_Boolean[`true`, `false`, `true`]]
    //    AssertEq[`false`, if_Boolean[`false`, `true`, `false`]]
    }

    def testDuality {
        val f: `false`# and [`true`] = `false` and `true`
        val t: `false`# or [`true`] = `false` or `true`
        val x: `false` = f and t
        okomok.sing.assert(x equal `false`)
    }

    AssertTrue[`true`]
    AssertFalse[`false`]

    AssertTrue[`true`# equal [`true`]]
    AssertTrue[`false`# equal [`false`]]
    AssertTrue[`true`# nequal [`false`]]
    AssertTrue[`false`# nequal [`true`]]

    type myNot[b <: Boolean] = b#not
    AssertTrue[myNot[`true`]# nequal [`true`]]
    AssertTrue[myNot[`false`]# nequal [`false`]]
    AssertTrue[myNot[`true`]# equal [`false`]]
    AssertTrue[myNot[`false`]# equal [`true`]]

    /*
    trait testOperator {
        AssertTrue[`true` && `true`]
        AssertTrue[(`false` && `true`)#not]
        AssertTrue[`false` || `true`]
        AssertTrue[`true` || `false`]
    }
    */

    trait testPropagation {
        type incinc[n <: Peano] = `if`[n# equal[_3], Inc_Nat[n], Const[n]]#apply#asNat#increment#decrement#increment
        AssertConforms[incinc[_2], Peano]

        AssertTrue[`if`[_2# equal[_3], Inc_Nat[_2], Const[_2]]#apply#increment# equal[_3]]
        AssertTrue[incinc[_2]# equal[_3]]
        AssertTrue[incinc[_3]# equal[_5]]
    }

    class Inc_Nat[e <: Peano](val e: e) extends AsFunction0 {
        override type self = Inc_Nat[e]
        override def apply = e.increment
        override type apply = e#increment
    }
}
