

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import junit.framework.Assert._


object AssertInvariant {
    def apply[m <: map.bstree.BSTree](m: m) {
        if (m.isEmpty.unsing) {
            assertEquals(0, m.size.unsing)
        } else  {
            var sz = 1
            if (!m.left.isEmpty.unsing) {
                AssertKeyLT(m.left, m.key)
                AssertInvariant(m.left)
                sz += m.left.size.unsing
            }
            if (!m.right.isEmpty.unsing) {
                AssertKeyGT(m.right, m.key)
                AssertInvariant(m.right)
                sz += m.right.size.unsing
            }
            assertEquals(m.size.unsing, sz)
        }
    }
}

object AssertKeyLT {
    def apply[m <: map.bstree.BSTree, k <: Any](m: m, k: k) {
        if (!m.isEmpty.unsing) {
            assertTrue(m.ord.compare(m.key, k).unsing < 0)
            AssertKeyLT(m.left, k)
            AssertKeyLT(m.right, k)
        }
    }
}

object AssertKeyGT {
    def apply[m <: map.bstree.BSTree, k <: Any](m: m, k: k) {
        if (!m.isEmpty.unsing) {
            assertTrue(m.ord.compare(k, m.key).unsing < 0)
            AssertKeyGT(m.left, k)
            AssertKeyGT(m.right, k)
        }
    }
}
