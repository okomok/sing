

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


// by @akihiro4chawon https://ideone.com/YRcNt https://ideone.com/LR6zh


package com.github.okomoktest; package singtest; package example; package projecteuler1

import com.github.okomok.sing

class ProjectEuler1Test extends org.scalatest.junit.JUnit3Suite {

  //import sing.nat.peano.Literal._
  import sing.nat.dense.Literal._

  final case class isMultipleOf[n <: sing.nat.Nat](val n: n) extends sing.Function1 {
    override type self = isMultipleOf[n]
    override  def apply[m <: sing.Any](m: m): apply[m] = m.asNat.rem(n).isZero
    override type apply[m <: sing.Any]                 = m#asNat#rem[n]#isZero
  }
  final case class shouldBeSummed() extends sing.Function1 {
    override type self = shouldBeSummed
    override  def apply[m <: sing.Any](m: m): apply[m] = isMultipleOf(_5).apply(m) or isMultipleOf(_3).apply(m)
    override type apply[m <: sing.Any]                 = isMultipleOf[_5]#apply[m]#or[isMultipleOf[_3]#apply[m]]
  }
  final case class plus() extends sing.Function2 {
    override type self = plus
    override  def apply[x <: sing.Any, y <: sing.Any](x: x, y: y): apply[x, y] = x.asNat.plus(y.asNat)
    override type apply[x <: sing.Any, y <: sing.Any]                          = x#asNat#plus[y#asNat]
  }
  final case class sumOfArithmeticSeq() extends sing.Function3 {
    override type self = sumOfArithmeticSeq
    def  n[begin <: sing.Any, end <: sing.Any, step <: sing.Any](begin: begin, end: end, step: step): n[begin, end, step] =
      end.asNat.minus(begin.asNat).plus(step.asNat).decrement.quot(step.asNat).asInstanceOf[n[begin, end, step]]
//      end.asNat.decrement.minus(begin.asNat).quot(step.asNat)
    type n[begin <: sing.Any, end <: sing.Any, step <: sing.Any] =
      end#asNat#minus[begin#asNat]#plus[step#asNat]#decrement#quot[step#asNat]
//      end#asNat#decrement#minus[begin#asNat]#quot[step#asNat]
    override  def apply[begin <: sing.Any, end <: sing.Any, step <: sing.Any](begin: begin, end: end, step: step): apply[begin,end, step] =
      n(begin, end, step).times(begin.asNat.times(_2).plus(n(begin, end, step).decrement.times(step.asNat))).quot(_2).asInstanceOf[apply[begin, end, step]]
    override type apply[begin <: sing.Any, end <: sing.Any, step <: sing.Any] =
      n[begin, end, step]#times[begin#asNat#times[_2]#plus[n[begin, end, step]#decrement#times[step#asNat]]]#quot[_2]#asDense
  }


  def testMain : Unit = {
    class make1000 {
      import sing.nat.dense.Nil
      private type _0B = sing.`false`
      private type _1B = sing.`true`
      private type __::[x <: sing.Boolean, xs <: sing.nat.Dense] = sing.nat.dense.Cons[x, xs]

      // 1000.toBinaryString.reverse.iterator.mkString("type _1000 = _", "B __:: _", "B __:: Nil")
      type _1000 = _10#times[_10]#times[_10] //
      //type _1000 = _0B __:: _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: _1B __:: _1B __:: _1B __:: _1B __:: Nil
    }

    type _N = make1000#_1000//_10

    // too slow
    //type ans = sing.list.range[_1, _N]#filter[shouldBeSummed]#reduceLeft[plus]
    //println(sing.weak.termOf[ans])

    // type level (compile time)
    type sumOfm3 = sumOfArithmeticSeq#apply[_3, _N, _3]
    type sumOfm5 = sumOfArithmeticSeq#apply[_5, _N, _5]
    type sumOfm15= sumOfArithmeticSeq#apply[_15, _N, _15]
    type ans2 = sumOfm3#plus[sumOfm5]#minus[sumOfm15]
    //println(sing.weak.termOf[ans2])
    expectResult(233168)(sing.weak.termOf[ans2].unsing)

    // run time
    val _N = _10 times _10 times _10
    val sumOfm3 = sumOfArithmeticSeq().apply(_3, _N, _3)
    val sumOfm5 = sumOfArithmeticSeq().apply(_5, _N, _5)
    val sumOfm15= sumOfArithmeticSeq().apply(_15, _N, _15)
    val ans2 = sumOfm3.plus(sumOfm5).minus(sumOfm15)
    //println(ans2)
    expectResult(233168)(ans2.unsing)

    ()
  }
}

