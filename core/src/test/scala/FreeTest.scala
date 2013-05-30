

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


class FreeTezt {

    def testTrueFalse {
        free.assert(`true`)
        free.assert[`true`]
        free.assertNot(`false`)
        free.assertNot[`false`]

        //free.assert(`false`)
        //free.assert[`false`]
        //free.assertNot(`true`)
        //free.assertNot[`true`]
    }

    class A
    class B extends A

    def testSame {
        /*
        free.assertSame(3, 2)
        */
        free.assertSame[Int, Int]

        //free.assertSame(new A, new B)
        /*
        free.assertSame(new B, new A)
        */

        //free.assertSame(3, '2')
        //free.assertSame[Int, Char]
    }

    def testConforms {
        /*
        free.assertConforms(new B, new A)
        */
        free.assertConforms[B, A]
        /*
        free.assertConforms(new A, new A)
        */
        free.assertConforms[A, A]

        /*
        free.assertConforms(new A, new B)
        */
        //free.assertConforms[A, B]
    }

}
