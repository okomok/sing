

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._


// `object Helper` would fall in weird compiler error.
// Also, don't import multiple times.
class Helper {
    type natOrd = nat.naturalOrdering
    val natOrd: natOrd = nat.naturalOrdering

    type node[k <: nat.Peano, l <: map.bstree.BSTree, r <: map.bstree.BSTree] =
        map.bstree.Node[k, k, l, r]
    def node[k <: nat.Peano, l <: map.bstree.BSTree, r <: map.bstree.BSTree](k: k, l: l, r: r): node[k, l, r] =
        map.bstree.Node(k, k, l, r).asInstanceOf[node[k, l, r]]

    type nil = map.bstree.Nil[natOrd]
    val nil: nil = map.bstree.Nil(natOrd)

    type leaf[k <: nat.Peano] = map.bstree.Nil[natOrd]#put[k, k]
    def leaf[k <: nat.Peano](k: k) = map.bstree.Nil(natOrd).put(k, k)
}
