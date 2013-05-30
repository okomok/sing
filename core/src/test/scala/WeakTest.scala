

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


class WeakTest {

    def testTrueFalse {
        weak.assert(`true`)
        weak.assert[`true`]
        weak.assertNot(`false`)
        weak.assertNot[`false`]

        //weak.assert(`false`)
        //weak.assert[`false`]
        //weak.assertNot(`true`)
        //weak.assertNot[`true`]
    }

    class A
    class B extends A

    def testSame {
        /*
        weak.assertSame(3, 2)
        */
        weak.assertSame[Int, Int]

        //weak.assertSame(new A, new B)
        /*
        weak.assertSame(new B, new A)
        */

        //weak.assertSame(3, '2')
        //weak.assertSame[Int, Char]
    }

    def testConforms {
        /*
        weak.assertConforms(new B, new A)
        */
        weak.assertConforms[B, A]
        /*
        weak.assertConforms(new A, new A)
        */
        weak.assertConforms[A, A]

        /*
        weak.assertConforms(new A, new B)
        */
        //weak.assertConforms[A, B]
    }

}
