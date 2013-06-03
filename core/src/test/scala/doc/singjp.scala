

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package doctest; package singjp


import com.github.okomok
import okomok.sing
import junit.framework.Assert.assertEquals
import scala.language.existentials


class SingityTest extends org.scalatest.junit.JUnit3Suite {

    def myAssert(a: sing.`true`) = ()

    def testSingity {
        import sing.Peano.Literal._
        val i: _3 = _3
        val j: _5#minus[_2] = _5.minus(_2)
        myAssert(i.equal(j)) // compile-time check
    }


    class PrintSquare1[n <: sing.Nat] {
        type i = n#times[n]
        //val a: scala.Int = ???
        //println(a)
    }

    class PrintSquare2[n <: sing.Nat](n: n) {
        val a: scala.Int = n.times(n).unsing
        println(a)
    }

}



class FibonacciTest1 {

    import sing.Peano.Literal._

    type fibonacci[n <: sing.Nat] = sing.`if`[n#lt[_2], sing.const0[n], FibElse[n]]#apply#asNat

    trait FibElse[n <: sing.Nat] extends sing.AsFunction0 {
        override type self = FibElse[n]
        override type apply = fibonacci[n#decrement]#plus[fibonacci[n#decrement#decrement]]
    }

}

class FibonacciTest2 {

    import sing.Peano.Literal._

    type fibonacci[n <: sing.Nat] = sing.`if`[n#lt[_2], sing.const0[n], FibElse[n]]#apply#asNat

    trait FibElse[n <: sing.Nat] extends sing.AsFunction0 {
        override type self = FibElse[n]
        override type apply = fibonacci[n#minus[_1]]#plus[fibonacci[n#decrement#decrement]]
    }

}


class ImplementationProblemTest {

    trait MyMetatype extends sing.Any {
        type foo <: sing.Nat
        type bar = foo#plus[foo] // !!?
    }

    class Outer[m <: sing.Nat](m: m) {
        type apply[n <: sing.Nat] = Nothing

        abstract class Inner[n <: sing.Nat](n: n) extends sing.AsFunction0 {
            override type self = Inner[n]
            override type apply = Nothing
        }
    }

}



class ListTest extends org.scalatest.junit.JUnit3Suite {

    import sing.Peano.Literal._

    object add2 extends sing.AsFunction1 {
        override type self = add2.type
        override  def apply[x <: sing.Any](x: x): apply[x] = x.asNat plus _2
        override type apply[x <: sing.Any] = x#asNat#plus[_2]
    }

    def testTrivial {
        val xs = _3 :: _4 :: _5 :: _6 :: sing.Nil
        val u = xs.map(add2) // returns a view
        assertEquals(5 :: 6 :: 7 :: 8 :: Nil, u.unsing)
        locally {
            import sing.::
            val v: _5 :: _6 :: _7 :: _8 :: sing.Nil = u.force
        }
    }

}

class NormalTest extends org.scalatest.junit.JUnit3Suite {

    import sing.Peano.Literal._

    import sing._ // workaround for implicit lookup

    def testUnsing {
        val i: scala.Int = _3.times(_2).unsing
        assertEquals(6, i)
    }

    def testBox {
        val j = sing.Tuple2(_Box(2), _Box(3))
        assertEquals(3, j._2.unsing)
    }

    def testLift {
        val j = sing.Tuple.lift2(2, 3)
        val xs = 3 #:: 4 #:: 5 #:: sing.Nil
        val y = xs.foldLeft(j._1, sing.Function.lift2((y: Int, x: Int) => y + x))
        assertEquals(2+3+4+5, y.unsing)
    }

}
