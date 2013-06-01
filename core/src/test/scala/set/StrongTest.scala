

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok
import okomok.sing._
import nat.dense.Literal._


class StrongTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        final class mySet extends set.Strong(set.sorted(nat.naturalOrdering).add(_3).add(_5).add(_1)) {
            type self = mySet
        }
        val mySet = new mySet

        Weak.assert(mySet.contains(_3))
        Weak.assertNot(mySet.contains(_6))
    }

}
