

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._


// `object Helper` would fall in weird compiler error.
// Also, don't import multiple times.
class Helper {
    type natOrd = Nat.naturalOrdering
    val natOrd: natOrd = Nat.naturalOrdering

    type node[k <: Peano, l <: BSTree, r <: BSTree] =
        BSNode[k, k, l, r]
    def node[k <: Peano, l <: BSTree, r <: BSTree](k: k, l: l, r: r): node[k, l, r] =
        BSNode(k, k, l, r).asInstanceOf[node[k, l, r]]

    type nil = BSNil[natOrd]
    val nil: nil = BSNil(natOrd)

    type leaf[k <: Peano] = BSNil[natOrd]#put[k, k]
    def leaf[k <: Peano](k: k) = BSNil(natOrd).put(k, k)
}
