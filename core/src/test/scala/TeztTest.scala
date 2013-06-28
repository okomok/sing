

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


class TeztTest {

    def testTrueFalse {
        Test.cassert(`true`)
        Test.cassert[`true`]
        Test.cassertNot(`false`)
        Test.cassertNot[`false`]

        //Test.cassert(`false`)
        //Test.cassert[`false`]
        //Test.assertFalse(`true`)
        //Test.cassertNot[`true`]
    }

    class A
    class B extends A

    def testSame {
        /*
        Test.cassertEq(3, 2)
        */
        Test.cassertEq[Int, Int]

        //Test.cassertEq(new A, new B)
        /*
        Test.cassertEq(new B, new A)
        */

        //Test.cassertEq(3, '2')
        //Test.cassertEq[Int, Char]
    }

    def testConforms {
        /*
        Test.assertConforms(new B, new A)
        */
        Test.assertConforms[B, A]
        /*
        Test.assertConforms(new A, new A)
        */
        Test.assertConforms[A, A]

        /*
        Test.assertConforms(new A, new B)
        */
        //Test.assertConforms[A, B]
    }

}
