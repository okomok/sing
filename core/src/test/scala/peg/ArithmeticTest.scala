

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the terms of an MIT\-tyle license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import dense.{AsciiLiteral => Ch}
import Dense.Literal._


// too slow to compile


object Arithmetic {
/*
     val PLUS: PLUS = Peg.term(Ch.+)
    type PLUS       = Peg.term[Ch.+]

     val MINUS: MINUS = Peg.term(Ch.-)
    type MINUS        = Peg.term[Ch.-]

     val TIMES: TIMES = Peg.term(Ch.*)
    type TIMES        = Peg.term[Ch.*]

     val DIV: DIV = Peg.term(Ch./)
    type DIV      = Peg.term[Ch./]

     val LP: LP = Peg.term(Ch.`(`)
    type LP     = Peg.term[Ch.`(`]

     val RP: RP = Peg.term(Ch.`)`)
    type RP     = Peg.term[Ch.`)`]
*/


/*
    val expr = new expr
    final class expr extends PegRule {
        type self = expr
        override  def rule: rule = term.seq( Peg.term(Ch.+).seq(term).or(Peg.term(Ch.-).seq(term)).star )
        override type rule       = term#seq[ Peg.term[Ch.+]#seq[term]#or[Peg.term[Ch.-]#seq[term]]#star ]
    }

    val term = new term
    final class term extends PegRule {
        type self = term
        override  def rule: rule = factor.seq( Peg.term(Ch.*).seq(factor).or(Peg.term(Ch./).seq(factor)).star )
        override type rule       = factor#seq[ Peg.term[Ch.*]#seq[factor]#or[Peg.term[Ch./]#seq[factor]]#star ]
    }

    val factor = new factor
    final class factor extends PegRule {
        type self = factor
        override  def rule: rule = number//.or( Peg.term(Ch.`(`).seq(expr).seq(Peg.term(Ch.`)`)) )
        override type rule       = number//#or[ Peg.term[Ch.`(`]#seq[expr]#seq[Peg.term[Ch.`)`]] ]
    }

    val number = new number
    final class number extends PegRule {
        type self = number
        override  def rule: rule = Peg.term(_1).or(Peg.term(_2)).or(Peg.term(_3))
        override type rule       = Peg.term[_1]#or[Peg.term[_2]]#or[Peg.term[_3]]
    }
*/

/*
    // order matters.
     val number: number = Peg.term(_1).or(Peg.term(_2)).or(Peg.term(_3))
    type number         = Peg.term[_1]#or[Peg.term[_2]]#or[Peg.term[_3]]

     val factor: factor = number//.or( Peg.term(Ch.`(`).seq(expr).seq(Peg.term(Ch.`)`)) )
    type factor         = number//#or[ Peg.term[Ch.`(`]#seq[expr]#seq[Peg.term[Ch.`)`]] ]

     val term: term = factor.seq( Peg.term(Ch.*).seq(factor).or(Peg.term(Ch./).seq(factor)).star )
    type term       = factor#seq[ Peg.term[Ch.*]#seq[factor]#or[Peg.term[Ch./]#seq[factor]]#star ]

     val expr: expr = term.seq( Peg.term(Ch.+).seq(term).or(Peg.term(Ch.-).seq(term)).star )
    type expr       = term#seq[ Peg.term[Ch.+]#seq[term]#or[Peg.term[Ch.-]#seq[term]]#star ]
*/
/*s.
    val number: number = new number
    final class number extends peg.Strong(Peg.term(_1).or(Peg.term(_2)).or(Peg.term(_3))) { type self = number }

     val factor: factor = number//.or( Peg.term(Ch.`(`).seq(expr).seq(Peg.term(Ch.`)`)) )
    type factor         = number//#or[ Peg.term[Ch.`(`]#seq[expr]#seq[Peg.term[Ch.`)`]] ]

    val term: term = new term
    final class term extends peg.Strong(factor.seq( Peg.term(Ch.*).seq(factor).or(Peg.term(Ch./).seq(factor)).star )) { type self = term }

    val expr: expr = new expr
    final class expr extends peg.Strong(term.seq( Peg.term(Ch.+).seq(term).or(Peg.term(Ch.-).seq(term)).star )) { type self = expr }
*/


/*
    // Hmm, nothing changes.
    val T_1: T_1 = new T_1
    final class T_1 extends peg.Strong(Peg.term(_1)) { type self = T_1 }
    val T_2: T_2 = new T_2
    final class T_2 extends peg.Strong(Peg.term(_2)) { type self = T_2 }
    val T_3: T_3 = new T_3
    final class T_3 extends peg.Strong(Peg.term(_3)) { type self = T_3 }
    val T_TIMES: T_TIMES = new T_TIMES
    final class T_TIMES extends peg.Strong(Peg.term(Ch.*)) { type self = T_TIMES }
    val T_DIV: T_DIV = new T_DIV
    final class T_DIV extends peg.Strong(Peg.term(Ch./)) { type self = T_DIV }
    val T_PLUS: T_PLUS = new T_PLUS
    final class T_PLUS extends peg.Strong(Peg.term(Ch.+)) { type self = T_PLUS }
    val T_MINUS: T_MINUS = new T_MINUS
    final class T_MINUS extends peg.Strong(Peg.term(Ch.-)) { type self = T_MINUS }

    val number: number = new number
    final class number extends peg.Strong(T_1 or T_2 or T_3) { type self = number }

     val factor: factor = number//.or( Peg.term(Ch.`(`).seq(expr).seq(Peg.term(Ch.`)`)) )
    type factor         = number//#or[ Peg.term[Ch.`(`]#seq[expr]#seq[Peg.term[Ch.`)`]] ]

    val term: term = new term
    final class term extends peg.Strong(factor seq ((T_TIMES seq factor) or (T_DIV seq factor)).star) { type self = term }

    val expr: expr = new expr
    final class expr extends peg.Strong(term seq   ((T_PLUS seq term) or (T_MINUS seq term)).star ) { type self = expr }
*/

}

/*
final case class ArithmeticC[num <: Peg](num: num) extends Peg {
    override  def parse[xs <: List](xs: xs): parse[xs] =
        term(num).seq( Peg.term(Ch.+).seq(term(num)).or(Peg.term(Ch.-).seq(term(num))).star ).parse(xs)
    override type parse[xs <: List] =
        term[num]#seq[ Peg.term[Ch.+]#seq[term[num]]#or[Peg.term[Ch.-]#seq[term[num]]]#star ]#parse[xs]

     def factor[num <: Peg](num: num): factor[num] =
        num.or( Peg.term(Ch.`(`).seq(self).seq(Peg.term(Ch.`)`)) )
    type factor[num <: Peg] =
        num#or[ Peg.term[Ch.`(`]#seq[self]#seq[Peg.term[Ch.`)`]] ]

     def term[num <: Peg](num: num): term[num] =
        factor(num).seq( Peg.term(Ch.*).seq(factor(num)).or(Peg.term(Ch./).seq(factor(num))).star )
    type term[num <: Peg] =
        factor[num]#seq[ Peg.term[Ch.*]#seq[factor[num]]#or[Peg.term[Ch./]#seq[factor[num]]]#star ]}
*/

class ArithmeticTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
/*
        final class myList extends list.Strong(_3 :: Ch.+ /*:: _2 :: Ch.-*/ :: _1 :: Nil) { type self = myList }
        val myList = new myList
        //println(Arithmetic.expr.parse(myList))
       Weak.assert(Arithmetic.expr.matches(myList))
*/
    //   Weak.assert(Arithmetic.expr.matches(_3 :: Ch.+ :: _2 :: Ch.- :: _1 :: Nil))

   //    Weak.assert(Arithmetic.expr.matches(_3 :: Ch.+ :: _2 :: Nil))



//       println(ArithmeticC(Arithmetic.number).parse(_3 :: Ch.+ :: _2 :: Ch.- :: _1 :: Nil))
//       Weak.assert(Arithmetic.expr.matches(_2 :: Ch.+ :: Ch.`(` :: _3 :: Ch.+ :: _1 :: Ch.`)` :: Nil))
        ()
    }

}

