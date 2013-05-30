

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package weak


import scala.annotation.implicitNotFound


@implicitNotFound("sing.printe: ${T}")
sealed trait Printe[T]
