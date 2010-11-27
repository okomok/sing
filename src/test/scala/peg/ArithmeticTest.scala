

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT\-tyle license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.{AsciiLiteral => Ch}
import nat.dense.StrongLiteral._


// too slow to compile


object Arithmetic {
/*
     val PLUS: PLUS = peg.term(Ch.+)
    type PLUS       = peg.term[Ch.+]

     val MINUS: MINUS = peg.term(Ch.-)
    type MINUS        = peg.term[Ch.-]

     val TIMES: TIMES = peg.term(Ch.*)
    type TIMES        = peg.term[Ch.*]

     val DIV: DIV = peg.term(Ch./)
    type DIV      = peg.term[Ch./]

     val LP: LP = peg.term(Ch.`(`)
    type LP     = peg.term[Ch.`(`]

     val RP: RP = peg.term(Ch.`)`)
    type RP     = peg.term[Ch.`)`]
*/


/*
    val expr = new expr
    final class expr extends peg.Rule {
        type self = expr
        override  def rule: rule = term.seq( peg.term(Ch.+).seq(term).or(peg.term(Ch.-).seq(term)).star )
        override type rule       = term#seq[ peg.term[Ch.+]#seq[term]#or[peg.term[Ch.-]#seq[term]]#star ]
    }

    val term = new term
    final class term extends peg.Rule {
        type self = term
        override  def rule: rule = factor.seq( peg.term(Ch.*).seq(factor).or(peg.term(Ch./).seq(factor)).star )
        override type rule       = factor#seq[ peg.term[Ch.*]#seq[factor]#or[peg.term[Ch./]#seq[factor]]#star ]
    }

    val factor = new factor
    final class factor extends peg.Rule {
        type self = factor
        override  def rule: rule = number//.or( peg.term(Ch.`(`).seq(expr).seq(peg.term(Ch.`)`)) )
        override type rule       = number//#or[ peg.term[Ch.`(`]#seq[expr]#seq[peg.term[Ch.`)`]] ]
    }

    val number = new number
    final class number extends peg.Rule {
        type self = number
        override  def rule: rule = peg.term(_1).or(peg.term(_2)).or(peg.term(_3))
        override type rule       = peg.term[_1]#or[peg.term[_2]]#or[peg.term[_3]]
    }
*/

/*
    // order matters.
     val number: number = peg.term(_1).or(peg.term(_2)).or(peg.term(_3))
    type number         = peg.term[_1]#or[peg.term[_2]]#or[peg.term[_3]]

     val factor: factor = number//.or( peg.term(Ch.`(`).seq(expr).seq(peg.term(Ch.`)`)) )
    type factor         = number//#or[ peg.term[Ch.`(`]#seq[expr]#seq[peg.term[Ch.`)`]] ]

     val term: term = factor.seq( peg.term(Ch.*).seq(factor).or(peg.term(Ch./).seq(factor)).star )
    type term       = factor#seq[ peg.term[Ch.*]#seq[factor]#or[peg.term[Ch./]#seq[factor]]#star ]

     val expr: expr = term.seq( peg.term(Ch.+).seq(term).or(peg.term(Ch.-).seq(term)).star )
    type expr       = term#seq[ peg.term[Ch.+]#seq[term]#or[peg.term[Ch.-]#seq[term]]#star ]
*/
/*s.
    val number: number = new number
    final class number extends peg.Strong(peg.term(_1).or(peg.term(_2)).or(peg.term(_3))) { type self = number }

     val factor: factor = number//.or( peg.term(Ch.`(`).seq(expr).seq(peg.term(Ch.`)`)) )
    type factor         = number//#or[ peg.term[Ch.`(`]#seq[expr]#seq[peg.term[Ch.`)`]] ]

    val term: term = new term
    final class term extends peg.Strong(factor.seq( peg.term(Ch.*).seq(factor).or(peg.term(Ch./).seq(factor)).star )) { type self = term }

    val expr: expr = new expr
    final class expr extends peg.Strong(term.seq( peg.term(Ch.+).seq(term).or(peg.term(Ch.-).seq(term)).star )) { type self = expr }
*/

    // Hmm, nothing changes.
    val T_1: T_1 = new T_1
    final class T_1 extends peg.Strong(peg.term(_1)) { type self = T_1 }
    val T_2: T_2 = new T_2
    final class T_2 extends peg.Strong(peg.term(_2)) { type self = T_2 }
    val T_3: T_3 = new T_3
    final class T_3 extends peg.Strong(peg.term(_3)) { type self = T_3 }
    val T_TIMES: T_TIMES = new T_TIMES
    final class T_TIMES extends peg.Strong(peg.term(Ch.*)) { type self = T_TIMES }
    val T_DIV: T_DIV = new T_DIV
    final class T_DIV extends peg.Strong(peg.term(Ch./)) { type self = T_DIV }
    val T_PLUS: T_PLUS = new T_PLUS
    final class T_PLUS extends peg.Strong(peg.term(Ch.+)) { type self = T_PLUS }
    val T_MINUS: T_MINUS = new T_MINUS
    final class T_MINUS extends peg.Strong(peg.term(Ch.-)) { type self = T_MINUS }

    val number: number = new number
    final class number extends peg.Strong(T_1 or T_2 or T_3) { type self = number }

     val factor: factor = number//.or( peg.term(Ch.`(`).seq(expr).seq(peg.term(Ch.`)`)) )
    type factor         = number//#or[ peg.term[Ch.`(`]#seq[expr]#seq[peg.term[Ch.`)`]] ]

    val term: term = new term
    final class term extends peg.Strong(factor seq ((T_TIMES seq factor) or (T_DIV seq factor)).star) { type self = term }

    val expr: expr = new expr
    final class expr extends peg.Strong(term seq   ((T_PLUS seq term) or (T_MINUS seq term)).star ) { type self = expr }


}

/*
final case class ArithmeticC[num <: Peg](num: num) extends Peg {
    override  def parse[xs <: List](xs: xs): parse[xs] =
        term(num).seq( peg.term(Ch.+).seq(term(num)).or(peg.term(Ch.-).seq(term(num))).star ).parse(xs)
    override type parse[xs <: List] =
        term[num]#seq[ peg.term[Ch.+]#seq[term[num]]#or[peg.term[Ch.-]#seq[term[num]]]#star ]#parse[xs]

     def factor[num <: Peg](num: num): factor[num] =
        num.or( peg.term(Ch.`(`).seq(self).seq(peg.term(Ch.`)`)) )
    type factor[num <: Peg] =
        num#or[ peg.term[Ch.`(`]#seq[self]#seq[peg.term[Ch.`)`]] ]

     def term[num <: Peg](num: num): term[num] =
        factor(num).seq( peg.term(Ch.*).seq(factor(num)).or(peg.term(Ch./).seq(factor(num))).star )
    type term[num <: Peg] =
        factor[num]#seq[ peg.term[Ch.*]#seq[factor[num]]#or[peg.term[Ch./]#seq[factor[num]]]#star ]}
*/

class ArithmeticTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {

        final class myList extends list.Strong(_3 :: Ch.+ /*:: _2 :: Ch.-*/ :: _1 :: Nil) { type self = myList }
        val myList = new myList
        //println(Arithmetic.expr.parse(myList))
       free.assert(Arithmetic.expr.matches(myList))

    //   free.assert(Arithmetic.expr.matches(_3 :: Ch.+ :: _2 :: Ch.- :: _1 :: Nil))

   //    free.assert(Arithmetic.expr.matches(_3 :: Ch.+ :: _2 :: Nil))



//       println(ArithmeticC(Arithmetic.number).parse(_3 :: Ch.+ :: _2 :: Ch.- :: _1 :: Nil))
//       free.assert(Arithmetic.expr.matches(_2 :: Ch.+ :: Ch.`(` :: _3 :: Ch.+ :: _1 :: Ch.`)` :: Nil))
        ()
    }

}

