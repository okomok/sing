# sing 0.1.0

`sing` is a type-level metaprogramming library for Scala.
This is based upon the singleton type system emulation.
"sing" represents "singleton" and "compile-time and runtime methods sing in chorus":
```scala
import com.github.okomok.sing
import sing.{map, Nat, Box}
import sing.nat.dense.Literal._

class AbstractFactoryTest extends org.scalatest.junit.JUnit3Suite {
    // Notice there is no common super trait.
    class WinButton {
        def paint = "I'm a WinButton"
    }
    class OSXButton {
        def paint = "I'm a OSXButton"
    }

    object WinFactory {
        def createButton = new WinButton
    }
    object OSXFactory {
        def createButton = new OSXButton
    }

    // Needs explicit boxing to make a sing object from a non-sing one.
    val factoryMap = map.sorted1(_0, Box(WinFactory)).put(_1, Box(OSXFactory))

    def createFactory[n <: Nat](n: n) = {
        val option = factoryMap.get(n)
        option.get.unsing
    }

    def testTrivial {
        // Concrete types are preserved.
        val factory = createFactory(_0)
        val button = factory.createButton
        expect("I'm a WinButton")(button.paint)
    }
}
```



## Setup Dependencies for sbt

Append this in your project definition:

```scala
val sing = "com.github.okomok" % "sing_2.9.0" % "0.1.0"
val okomokReleases = "okomok releases" at "http://okomok.github.com/maven-repo/releases"
```

Append this to `compileOptions`:

```scala
++ compileOptions("-Yrecursion", "50")
```



## Links

* [Browse Source]
* [Browse Test Source]
* [The Scala Programming Language]


Shunsuke Sogame <<okomok@gmail.com>>


[MIT License]: http://www.opensource.org/licenses/mit-license.php "MIT License"
[Browse Source]: http://github.com/okomok/sing/tree/master/src/main/scala "Browse Source"
[Browse Test Source]: http://github.com/okomok/sing/tree/master/src/test/scala "Browse Test Source"
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

