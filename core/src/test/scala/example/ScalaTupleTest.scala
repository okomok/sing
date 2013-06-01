

// Public domain


// See: https://gist.github.com/1339059


package com.github.okomoktest; package singtest; package example; package projecteuler1


import com.github.okomok.sing._
import scala.language.existentials


class ScalaTupleTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val res0 = (1,"a")
        val res1 = ('geso , new java.util.Date , 9999L )
        val res2 = tuple.Lift2(res0).asList
        val res3 = tuple.Lift3(res1).asList

        val x = ((res2 append res3).force.toSTuple): (Int, String, Symbol, java.util.Date, Long)
        val (1, "a", 'geso , _, 9999L) = x

        ()
    }
}

