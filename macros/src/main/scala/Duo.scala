

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.existentials
import scala.reflect.macros.Context


case class Duo[ct <: Context with Singleton](term: ct#Expr[_], tpe: ct#Type)
