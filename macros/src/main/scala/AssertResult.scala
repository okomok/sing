

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


sealed abstract class AssertResult

case object AssertSuccess extends AssertResult
case class AssertFailure(msg: String) extends AssertResult
