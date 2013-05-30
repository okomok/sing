

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


trait ZeroWidth extends Peg {
    override  def width: width = nat.dense._0
    override type width        = nat.dense._0
}
