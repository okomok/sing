

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import junit.framework.Assert._


object AssertInvariant {
    def apply[m <: map.bstree.BSTree](m: m) {
        if (m.isEmpty.unsung) {
            assertEquals(0, m.size.unsung)
        } else  {
            var sz = 1
            if (!m.left.isEmpty.unsung) {
                AssertKeyLT(m.left, m.key)
                AssertInvariant(m.left)
                sz += m.left.size.unsung
            }
            if (!m.right.isEmpty.unsung) {
                AssertKeyGT(m.right, m.key)
                AssertInvariant(m.right)
                sz += m.right.size.unsung
            }
            assertEquals(m.size.unsung, sz)
        }
    }
}

object AssertKeyLT {
    def apply[m <: map.bstree.BSTree, k <: Any](m: m, k: k) {
        if (!m.isEmpty.unsung) {
            assertTrue(m.ord.compare(m.key, k).unsung < 0)
            AssertKeyLT(m.left, k)
            AssertKeyLT(m.right, k)
        }
    }
}

object AssertKeyGT {
    def apply[m <: map.bstree.BSTree, k <: Any](m: m, k: k) {
        if (!m.isEmpty.unsung) {
            assertTrue(m.ord.compare(k, m.key).unsung < 0)
            AssertKeyGT(m.left, k)
            AssertKeyGT(m.right, k)
        }
    }
}
