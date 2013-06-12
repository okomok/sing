

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
        Test.assertSame[scala.Boolean, `true`#unsing]
        Test.assertSame[`true`, `true`]
     //   Test.assertTrue[`false` === if_Boolean[`true`, `false`, `true`]]
     //   Test.assertTrue[`false` === if_Boolean[`false`, `true`, `false`]]

    //    Test.assertSame[`false`, if_Boolean[`true`, `false`, `true`]]
    //    Test.assertSame[`false`, if_Boolean[`false`, `true`, `false`]]
    }

    def testDuality {
        val f: `false`# and [`true`] = `false` and `true`
        val t: `false`# or [`true`] = `false` or `true`
        val x: `false` = f and t
        okomok.sing.assert(x equal `false`)
    }

    Test.assertTrue[`true`]
    Test.assertFalse[`false`]

    Test.assertTrue[`true`# equal [`true`]]
    Test.assertTrue[`false`# equal [`false`]]
    Test.assertTrue[`true`# nequal [`false`]]
    Test.assertTrue[`false`# nequal [`true`]]

    type myNot[b <: Boolean] = b#not
    Test.assertTrue[myNot[`true`]# nequal [`true`]]
    Test.assertTrue[myNot[`false`]# nequal [`false`]]
    Test.assertTrue[myNot[`true`]# equal [`false`]]
    Test.assertTrue[myNot[`false`]# equal [`true`]]

    /*
    trait testOperator {
        Test.assertTrue[`true` && `true`]
        Test.assertTrue[(`false` && `true`)#not]
        Test.assertTrue[`false` || `true`]
        Test.assertTrue[`true` || `false`]
    }
    */

    trait testPropagation {
        type incinc[n <: Peano] = `if`[n# equal[_3], Inc_Nat[n], Const[n]]#apply#asNat#increment#decrement#increment
        Test.assertConforms[incinc[_2], Peano]

        Test.assertTrue[`if`[_2# equal[_3], Inc_Nat[_2], Const[_2]]#apply#increment# equal[_3]]
        Test.assertTrue[incinc[_2]# equal[_3]]
        Test.assertTrue[incinc[_3]# equal[_5]]
    }

    class Inc_Nat[e <: Peano](val e: e) extends AsFunction0 {
        override type self = Inc_Nat[e]
        override def apply = e.increment
        override type apply = e#increment
    }
}
