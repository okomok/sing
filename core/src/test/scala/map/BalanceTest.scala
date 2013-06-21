

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class BalanceTest extends org.scalatest.junit.JUnit3Suite {

    val h = new Helper
    import h._

    def testRotateLSingleL {

        type t1    = node[_1, leaf[_0], nil]
        val t1: t1 = node(_1, leaf(_0), nil)

        type t2    = node[_7,
            node[_5, leaf[_4], leaf[_6]],
            node[_9, leaf[_8], leaf[_10]]
        ]
        val t2: t2 = node(_7,
            node(_5, leaf(_4), leaf(_6)),
            node(_9, leaf(_8), leaf(_10))
        )

        type t3    = node[_13,
            leaf[_12],
            node[_15, leaf[_14], nil]
        ]
        val t3: t3 = node(_13,
            leaf(_12),
            node(_15, leaf(_14), nil)
        )

        AssertInvariant(t1)
        AssertInvariant(t2)
        AssertInvariant(t3)

        type l     = t1
        val l: l   = t1
        type r     = node[_11, t2, t3]
        val r: r   = node(_11, t2, t3)
        AssertInvariant(l)
        AssertInvariant(r)

        type bm = _bstree.Balance.apply[_3, _3, l, r]
        val bm: bm = _bstree.Balance.apply(_3, _3, l, r)
        Test.cassertSame[node[_11, node[_3, t1, t2], t3], bm]
        assertEquals(_15, bm.size)
        AssertInvariant(bm)
    }

    def testRotateLDoubleL {
        type t1    = node[_1, leaf[_0], nil]
        val t1: t1 = node(_1, leaf(_0), nil)

        type t2    = node[_5, leaf[_4], leaf[_6]]
        val t2: t2 = node(_5, leaf(_4), leaf(_6))

        type t3    = node[_9, leaf[_8], leaf[_10]]
        val t3: t3 = node(_9, leaf(_8), leaf(_10))

        type t4    = node[_13, leaf[_12], nil]
        val t4: t4 = node(_13, leaf(_12), nil)

        AssertInvariant(t1)
        AssertInvariant(t2)
        AssertInvariant(t3)
        AssertInvariant(t4)

        type l     = t1
        val l: l   = t1
        type r     = node[_11, node[_7, t2, t3], t4]
        val r: r   = node(_11, node(_7, t2, t3), t4)
        AssertInvariant(l)
        AssertInvariant(r)

        type bm = _bstree.Balance.apply[_3, _3, l, r]
        val bm: bm = _bstree.Balance.apply(_3, _3, l, r)
        Test.cassertSame[node[_7, node[_3, t1, t2], node[_11, t3, t4]], bm]
        assertEquals(_13, bm.size)
        AssertInvariant(bm)
    }
}
