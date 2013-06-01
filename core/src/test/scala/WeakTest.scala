

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


class WeakTest {

    def testTrueFalse {
        Weak.assert(`true`)
        Weak.assert[`true`]
        Weak.assertNot(`false`)
        Weak.assertNot[`false`]

        //Weak.assert(`false`)
        //Weak.assert[`false`]
        //Weak.assertNot(`true`)
        //Weak.assertNot[`true`]
    }

    class A
    class B extends A

    def testSame {
        /*
        Weak.assertSame(3, 2)
        */
        Weak.assertSame[Int, Int]

        //Weak.assertSame(new A, new B)
        /*
        Weak.assertSame(new B, new A)
        */

        //Weak.assertSame(3, '2')
        //Weak.assertSame[Int, Char]
    }

    def testConforms {
        /*
        Weak.assertConforms(new B, new A)
        */
        Weak.assertConforms[B, A]
        /*
        Weak.assertConforms(new A, new A)
        */
        Weak.assertConforms[A, A]

        /*
        Weak.assertConforms(new A, new B)
        */
        //Weak.assertConforms[A, B]
    }

}
