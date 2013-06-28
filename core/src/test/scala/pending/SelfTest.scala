

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._


trait SelfTezt {

    import makro._

    trait Foo extends Self.apply

    object Bar extends Self.apply

    class Buz[x, y] extends Self.apply

    Test.cassertEq[Foo#self, Foo]
    Test.cassertEq[Bar.type, Bar.self]
    Test.cassertEq[Buz[Int, Char], Buz[Int, Char]#self]
}
