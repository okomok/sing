

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


trait ZeroWidth extends Peg {
    override  def width: width = nat.dense._0
    override type width        = nat.dense._0
}
