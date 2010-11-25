

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


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
        assertEquals(true, `true`.unsung)
        assertEquals(false, `false`.unsung)
        assertEquals(`true`, `true`)
        assertEquals(`false`, `false`)
        AssertNotEquals(`false`, `true`)

    }

    trait testTrivial {
        free.assertSame[scala.Boolean, `true`#unsung]
        free.assertSame[`true`, `true`]
     //   free.assert[`false` === if_Boolean[`true`, `false`, `true`]]
     //   free.assert[`false` === if_Boolean[`false`, `true`, `false`]]

    //    free.assertSame[`false`, if_Boolean[`true`, `false`, `true`]]
    //    free.assertSame[`false`, if_Boolean[`false`, `true`, `false`]]
    }

    def testDuality {
        val f: `false`# and [`true`] = `false` and `true`
        val t: `false`# or [`true`] = `false` or `true`
        val x: `false` = f and t
        okomok.sing.assert(x equal `false`)
    }

    free.assert[`true`]
    free.assertNot[`false`]

    free.assert[`true`# equal [`true`]]
    free.assert[`false`# equal [`false`]]
    free.assert[`true`# nequal [`false`]]
    free.assert[`false`# nequal [`true`]]

    type myNot[b <: Boolean] = b#not
    free.assert[myNot[`true`]# nequal [`true`]]
    free.assert[myNot[`false`]# nequal [`false`]]
    free.assert[myNot[`true`]# equal [`false`]]
    free.assert[myNot[`false`]# equal [`true`]]

    /*
    trait testOperator {
        free.assert[`true` && `true`]
        free.assert[(`false` && `true`)#not]
        free.assert[`false` || `true`]
        free.assert[`true` || `false`]
    }
    */

    trait testPropagation {
        type incinc[n <: Peano] = `if`[n# equal[_3], Inc_Nat[n], const0[n]]#apply#asNat#increment#decrement#increment
        free.assertConforms[incinc[_2], Peano]

        free.assert[`if`[_2# equal[_3], Inc_Nat[_2], const0[_2]]#apply#increment# equal[_3]]
        free.assert[incinc[_2]# equal[_3]]
        free.assert[incinc[_3]# equal[_5]]
    }

    class Inc_Nat[e <: Peano](val e: e) extends Function0 {
        override type self = Inc_Nat[e]
        override def apply = e.increment
        override type apply = e#increment
    }
}
