

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


sealed abstract class AssertionResult

case object AssertionSuccess extends AssertionResult
case class AssertionFailure(msg: String) extends AssertionResult
