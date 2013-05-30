

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package free


import scala.annotation.implicitNotFound


@implicitNotFound("sing.printe: ${T}")
sealed trait Printe[T]
