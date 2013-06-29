

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing.makro._
import CompileError._


class CheckTest extends org.scalatest.junit.JUnit3Suite {

    class Wow
    type No = Nothing with Wow

    def ignore[x](x: x): Unit = ()

    def testTrivial {
//        type res = Check.apply[No]

        ExpectErrorOf(NothingType) {
            ignore[Check.apply[No]]
        }

    }

}
