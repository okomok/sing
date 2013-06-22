

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest
package pending


import com.github.okomok.sing
import sing._


class SelfTest extends org.scalatest.junit.JUnit3Suite {

    import makro._

    trait Foo extends Self.apply

    object Bar extends Self.apply

    class Buz[x, y] extends Self.apply

    Test.cassertSame[Foo#self, Foo]
    Test.cassertSame[Bar.type, Bar.self]
    Test.cassertSame[Buz[Int, Char], Buz[Int, Char]#self]
}
