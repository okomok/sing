

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import makro.Unspecified


/**
 * Annotation to make a singmethod from typemethod
 */
class singmethod extends StaticAnnotation {
    def macroTransform(annottees: scala.Any*): Unspecified = macro makro.SingMethodImpl.annot_impl
}
