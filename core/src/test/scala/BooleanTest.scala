

// Copyright Shunsuke Sogame 2008-2013.
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
        Weak.assertSame[scala.Boolean, `true`#unsing]
        Weak.assertSame[`true`, `true`]
     //   Weak.assert[`false` === if_Boolean[`true`, `false`, `true`]]
     //   Weak.assert[`false` === if_Boolean[`false`, `true`, `false`]]

    //    Weak.assertSame[`false`, if_Boolean[`true`, `false`, `true`]]
    //    Weak.assertSame[`false`, if_Boolean[`false`, `true`, `false`]]
    }

    def testDuality {
        val f: `false`# and [`true`] = `false` and `true`
        val t: `false`# or [`true`] = `false` or `true`
        val x: `false` = f and t
        okomok.sing.assert(x equal `false`)
    }

    Weak.assert[`true`]
    Weak.assertNot[`false`]

    Weak.assert[`true`# equal [`true`]]
    Weak.assert[`false`# equal [`false`]]
    Weak.assert[`true`# nequal [`false`]]
    Weak.assert[`false`# nequal [`true`]]

    type myNot[b <: Boolean] = b#not
    Weak.assert[myNot[`true`]# nequal [`true`]]
    Weak.assert[myNot[`false`]# nequal [`false`]]
    Weak.assert[myNot[`true`]# equal [`false`]]
    Weak.assert[myNot[`false`]# equal [`true`]]

    /*
    trait testOperator {
        Weak.assert[`true` && `true`]
        Weak.assert[(`false` && `true`)#not]
        Weak.assert[`false` || `true`]
        Weak.assert[`true` || `false`]
    }
    */

    trait testPropagation {
        type incinc[n <: Peano] = `if`[n# equal[_3], Inc_Nat[n], const0[n]]#apply#asNat#increment#decrement#increment
        Weak.assertConforms[incinc[_2], Peano]

        Weak.assert[`if`[_2# equal[_3], Inc_Nat[_2], const0[_2]]#apply#increment# equal[_3]]
        Weak.assert[incinc[_2]# equal[_3]]
        Weak.assert[incinc[_3]# equal[_5]]
    }

    class Inc_Nat[e <: Peano](val e: e) extends AsFunction0 {
        override type self = Inc_Nat[e]
        override def apply = e.increment
        override type apply = e#increment
    }
}
