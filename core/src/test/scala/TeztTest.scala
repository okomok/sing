

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
        Test.assertSame(3, 2)
        */
        Test.assertSame[Int, Int]

        //Test.assertSame(new A, new B)
        /*
        Test.assertSame(new B, new A)
        */

        //Test.assertSame(3, '2')
        //Test.assertSame[Int, Char]
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
