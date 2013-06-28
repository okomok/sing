

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
        Test.cassertEq[scala.Boolean, `true`#unsing]
        Test.cassertEq[`true`, `true`]
     //   Test.cassert[`false` === if_Boolean[`true`, `false`, `true`]]
     //   Test.cassert[`false` === if_Boolean[`false`, `true`, `false`]]

    //    Test.cassertEq[`false`, if_Boolean[`true`, `false`, `true`]]
    //    Test.cassertEq[`false`, if_Boolean[`false`, `true`, `false`]]
    }

    def testDuality {
        val f: `false`# and [`true`] = `false` and `true`
        val t: `false`# or [`true`] = `false` or `true`
        val x: `false` = f and t
        okomok.sing.assert(x equal `false`)
    }

    Test.cassert[`true`]
    Test.cassertNot[`false`]

    Test.cassert[`true`# equal [`true`]]
    Test.cassert[`false`# equal [`false`]]
    Test.cassert[`true`# nequal [`false`]]
    Test.cassert[`false`# nequal [`true`]]

    type myNot[b <: Boolean] = b#not
    Test.cassert[myNot[`true`]# nequal [`true`]]
    Test.cassert[myNot[`false`]# nequal [`false`]]
    Test.cassert[myNot[`true`]# equal [`false`]]
    Test.cassert[myNot[`false`]# equal [`true`]]

    /*
    trait testOperator {
        Test.cassert[`true` && `true`]
        Test.cassert[(`false` && `true`)#not]
        Test.cassert[`false` || `true`]
        Test.cassert[`true` || `false`]
    }
    */

    trait testPropagation {
        type incinc[n <: Peano] = `if`[n# equal[_3], Inc_Nat[n], Const[n]]#apply#asNat#increment#decrement#increment
        Test.assertConforms[incinc[_2], Peano]

        Test.cassert[`if`[_2# equal[_3], Inc_Nat[_2], Const[_2]]#apply#increment# equal[_3]]
        Test.cassert[incinc[_2]# equal[_3]]
        Test.cassert[incinc[_3]# equal[_5]]
    }

    class Inc_Nat[e <: Peano](val e: e) extends AsFunction0 {
        override type self = Inc_Nat[e]
        override def apply = e.increment
        override type apply = e#increment
    }
}
