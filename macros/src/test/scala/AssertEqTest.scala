

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing.makro._


class AssertEqTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        AssertEq[Int, Int]
    }

}
