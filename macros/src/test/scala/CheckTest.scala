

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing.makro._
import CompileError._


class CheckTest extends org.scalatest.junit.JUnit3Suite {

    class Wow
    type No = Nothing with Wow

    def ignore[x]: Unit = ()

    def testTrivial {
    //     ignore[Check.apply[No]]

        ExpectError(AnyError) {"""
//            ignore[Check.apply[No]]
            Check(ignore[No])
        """
        }

    }

}
