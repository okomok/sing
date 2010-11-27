

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


trait OneWidth extends Peg {
    override  def width: width = nat.dense._1
    override type width        = nat.dense._1
}
