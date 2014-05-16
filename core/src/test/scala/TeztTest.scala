

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


class TeztTest {

    def testTrueFalse {
        AssertTrue(`true`)
        AssertTrue[`true`]
        AssertFalse(`false`)
        AssertFalse[`false`]

        //AssertTrue(`false`)
        //AssertTrue[`false`]
        //AssertFalse(`true`)
        //AssertFalse[`true`]
    }

    class A
    class B extends A

    def testSame {
        /*
        AssertEq(3, 2)
        */
        AssertEq[Int, Int]

        //AssertEq(new A, new B)
        /*
        AssertEq(new B, new A)
        */

        //AssertEq(3, '2')
        //AssertEq[Int, Char]
    }

    def testConforms {
        /*
        AssertConforms(new B, new A)
        */
        AssertConforms[B, A]
        /*
        AssertConforms(new A, new A)
        */
        AssertConforms[A, A]

        /*
        AssertConforms(new A, new B)
        */
        //AssertConforms[A, B]
    }

}
