# sing 0.2.0-SNAPSHOT

`sing` is a type-level metaprogramming library for Scala.
This is based upon the singleton type system emulation.
"sing" represents "singleton" and "compile-time and runtime methods sing in chorus":
```scala
import com.github.okomok.sing._
import Dense._

class PrimesTest extends org.scalatest.junit.JUnit3Suite {

    final class Sieve extends AsFunction1 {
        override type self = Sieve
        override  def apply[ns <: Any](ns: ns) = id(ns).asList.drop(_1).filter(NonDiv(id(ns).asList.head.asNat))
        override type apply[ns <: Any]         = id[ns]#asList#drop[_1]#filter[NonDiv[id[ns]#asList#head#asNat]]
    }
    val Sieve: Sieve = new Sieve

    final case class NonDiv[n <: Nat](n: n) extends AsFunction1 {
        override type self = NonDiv[n]
        override  def apply[x <: Any](x: x): apply[x] = x.asNat.rem(n).nequal(_0)
        override type apply[x <: Any]                 = x#asNat#rem[n]#nequal[_0]
    }

    final class Head extends AsFunction1 {
        override type self = Head
        override  def apply[x <: Any](x: x): apply[x] = x.asList.head
        override type apply[x <: Any]                 = x#asList#head
    }
    val Head: Head = new Head

     def primes: primes = List.iterate( List.rangeFrom(_2), Sieve ).map(Head)
    type primes         = List.iterate[ List.rangeFrom[_2], Sieve ]#map[Head]

    def testMe {
         val some: some = primes.take(_10).force
        type some       = primes#take[_10]#force

        Test.assertSame(some, _2 :: _3 :: _5 :: _7 :: _11 :: _13 :: _17 :: _19 :: _23 :: _29 :: Nil)
        Test.assertSame[some, _2 :: _3 :: _5 :: _7 :: _11 :: _13 :: _17 :: _19 :: _23 :: _29 :: Nil]
    }
}
```



## Links

* [Browse Source]
* [Browse Test Source]
* [The Scala Programming Language]


Shunsuke Sogame <<okomok@gmail.com>>


[MIT License]: http://www.opensource.org/licenses/mit-license.php "MIT License"
[Browse Source]: http://github.com/okomok/sing/tree/master/core/src/main/scala "Browse Source"
[Browse Test Source]: http://github.com/okomok/sing/tree/master/core/src/test/scala "Browse Test Source"
[The Scala Programming Language]: http://www.scala-lang.org/ "The Scala Programming Language"
[PEG]: http://en.wikipedia.org/wiki/Parsing_expression_grammar "PEG"
[MetaScala]: http://www.assembla.com/wiki/show/metascala "MetaScala"
[Michid's Weblog]: http://michid.wordpress.com/ "Michid's Weblog"
[Apocalisp]: http://apocalisp.wordpress.com/ "Apocalisp"
[Boost.Fusion]: http://www.boost.org/doc/libs/release/libs/fusion/ "Boost.Fusion"
[scala.react]: http://lamp.epfl.ch/~imaier/ "scala.react"
[Reactive Extensions]: http://msdn.microsoft.com/en-us/devlabs/ee794896.aspx "Reactive Extensions"
[scala.Responder]: http://scala.sygneca.com/libs/responder "scala.Responder"
[scala.collection.Traversable]: http://www.scala-lang.org/archives/downloads/distrib/files/nightly/docs/library/scala/collection/Traversable.html "scala.collection.Traversable"
[scala-arm]: http://github.com/jsuereth/scala-arm "scala-arm"
[ARM in Java]: http://www.infoq.com/news/2010/08/arm-blocks "Automatic Resource Management in Java"

