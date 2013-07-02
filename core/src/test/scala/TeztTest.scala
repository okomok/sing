

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


class TeztTest {

    def testTrueFalse {
        Test.assertTrue(`true`)
        Test.assertTrue[`true`]
        Test.assertFalse(`false`)
        Test.assertFalse[`false`]

        //Test.assertTrue(`false`)
        //Test.assertTrue[`false`]
        //Test.assertFalse(`true`)
        //Test.assertFalse[`true`]
    }

    class A
    class B extends A

    def testSame {
        /*
        Test.assertEq(3, 2)
        */
        Test.assertEq[Int, Int]

        //Test.assertEq(new A, new B)
        /*
        Test.assertEq(new B, new A)
        */

        //Test.assertEq(3, '2')
        //Test.assertEq[Int, Char]
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
