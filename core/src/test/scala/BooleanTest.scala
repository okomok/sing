

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok

import okomok.sing._
//import junit.framework.Assert._

import okomok.sing.nat.peano.Literal._
import okomok.sing.nat.Peano
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
        weak.assertSame[scala.Boolean, `true`#unsing]
        weak.assertSame[`true`, `true`]
     //   weak.assert[`false` === if_Boolean[`true`, `false`, `true`]]
     //   weak.assert[`false` === if_Boolean[`false`, `true`, `false`]]

    //    weak.assertSame[`false`, if_Boolean[`true`, `false`, `true`]]
    //    weak.assertSame[`false`, if_Boolean[`false`, `true`, `false`]]
    }

    def testDuality {
        val f: `false`# and [`true`] = `false` and `true`
        val t: `false`# or [`true`] = `false` or `true`
        val x: `false` = f and t
        okomok.sing.assert(x equal `false`)
    }

    weak.assert[`true`]
    weak.assertNot[`false`]

    weak.assert[`true`# equal [`true`]]
    weak.assert[`false`# equal [`false`]]
    weak.assert[`true`# nequal [`false`]]
    weak.assert[`false`# nequal [`true`]]

    type myNot[b <: Boolean] = b#not
    weak.assert[myNot[`true`]# nequal [`true`]]
    weak.assert[myNot[`false`]# nequal [`false`]]
    weak.assert[myNot[`true`]# equal [`false`]]
    weak.assert[myNot[`false`]# equal [`true`]]

    /*
    trait testOperator {
        weak.assert[`true` && `true`]
        weak.assert[(`false` && `true`)#not]
        weak.assert[`false` || `true`]
        weak.assert[`true` || `false`]
    }
    */

    trait testPropagation {
        type incinc[n <: Peano] = `if`[n# equal[_3], Inc_Nat[n], const0[n]]#apply#asNat#increment#decrement#increment
        weak.assertConforms[incinc[_2], Peano]

        weak.assert[`if`[_2# equal[_3], Inc_Nat[_2], const0[_2]]#apply#increment# equal[_3]]
        weak.assert[incinc[_2]# equal[_3]]
        weak.assert[incinc[_3]# equal[_5]]
    }

    class Inc_Nat[e <: Peano](val e: e) extends Function0 {
        override type self = Inc_Nat[e]
        override def apply = e.increment
        override type apply = e#increment
    }
}
