

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


sealed abstract class AssertResult

case object AssertSuccess extends AssertResult
case class AssertFailure(msg: String) extends AssertResult
