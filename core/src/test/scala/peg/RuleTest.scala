

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._
import Peg.term


class RuleTest extends org.scalatest.junit.JUnit3Suite {


    val MyRule = new MyRule
    final class MyRule extends PegRule {
        override type self = MyRule
        override  def rule: rule = term(_1).seq(self.opt).seq(term(_2))
        override type rule       = term[_1]#seq[self#opt]#seq[term[_2]]
    }

    def testTrivial {
        type xs    = _1 :: _1 :: _2 :: _2 :: Nil
        val xs: xs = _1 :: _1 :: _2 :: _2 :: Nil
        type r   = MyRule#matches[xs]
        val r: r = MyRule.matches(xs)
        Weak.assert[r]
        assertTrue(r.unsing)
    }

    def testTrivialFail {
        type xs    = _1 :: _1 :: _1 :: _2 :: _2 :: Nil
        val xs: xs = _1 :: _1 :: _1 :: _2 :: _2 :: Nil
        type r   = MyRule#matches[xs]
        val r: r = MyRule.matches(xs)
        Weak.assertNot[r]
        assertFalse(r.unsing)
    }

}



/*
object ArithmeticRules {

     val `(`: `(` = _10
    type `(`      = _10
     val `)`: `)` = _11
    type `)`      = _11
     val `*`: `*` = _12
    type `*`      = _12
     val `+`: `+` = _13
    type `+`      = _13
     val `-`: `-` = _14
    type `-`      = _14
     val `/`: `/` = _15
    type `/`      = _15

    val group = new group
    final class group extends Rule {
        override type self = group
        override  def rule: rule = term(`(`).seq(expr).seq(`)`)
        override type rule       = term[`(`]#seq[expr]#seq[`)`]
    }

    val factor = new factor
    final class factor extends Rule {
        override type self = factor
        override  def rule: rule = integer.or(group)
        override type rule       = integer#or[group]
    }

    val factor = new factor
    final class factor extends Rule {
        override type self = factor
        override  def rule: rule = integer.or(group)
        override type rule       = integer#or[group]
    }

}
*/
