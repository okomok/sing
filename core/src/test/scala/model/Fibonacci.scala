

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package modeltest


import com.github.okomok
import okomok.sing._
import okomok.sing.Dense.Literal._
import okomok.sing.Dense.{::, _1B, _0B}


object FastFibonacci {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = `if`(n  lt _2,  const0(n), FibElse(n)).apply.asNat
    type fibonacci[n <: Nat]                     = `if`[n#lt[_2], const0[n], FibElse[n]]#apply#asNat

    case class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        override  def apply: apply = (fibonacci(n.decrement)  plus fibonacci(n.decrement.decrement)).asInstanceOf[apply]
        override type apply        =  fibonacci[n#decrement]#plus[fibonacci[n#decrement#decrement]]
    }
}

object SlowFibonacci {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = `if`(n  lt _2,  const0(n), FibElse(n)).apply.asNat
    type fibonacci[n <: Nat]                     = `if`[n#lt[_2], const0[n], FibElse[n]]#apply#asNat

    case class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        // Now child-node type-expressions are different.
        override  def apply: apply = (fibonacci(n  minus _1)   plus fibonacci(n.decrement.decrement)).asInstanceOf[apply]
        override type apply        =  fibonacci[n# minus[_1]]#plus[fibonacci[n#decrement#decrement]]
    }
}


object FastFibonacci2 {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = new _FastFibonacci2(n).apply
    type fibonacci[n <: Nat]                     =     _FastFibonacci2[n]#apply

}

class _FastFibonacci2[n <: Nat](n: n) {
     def apply: apply = `if`(n  lt _2,  const0(n), new Fib2Else(n)).apply.asNat
    type apply        = `if`[n#lt[_2], const0[n],     Fib2Else[n]]#apply#asNat
}

    class Fib2Else[n <: Nat](n: n) extends AsFunction0 {
        override type self = Fib2Else[n]
        override  def apply: apply = (new _FastFibonacci2(n.decrement).apply  plus new _FastFibonacci2(n.decrement.decrement).apply).asInstanceOf[apply]
        override type apply        =      _FastFibonacci2[n#decrement]#apply#plus    [_FastFibonacci2[n#decrement#decrement]#apply]
    }


object SlowFibonacci2 {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = new _SlowFibonacci2(n).apply
    type fibonacci[n <: Nat]                     =     _SlowFibonacci2[n]#apply
}

class _SlowFibonacci2[n <: Nat](n: n) {
     def apply: apply = `if`(n  lt _2,  const0(n), new FibElse(n)).apply.asNat
    type apply        = `if`[n#lt[_2], const0[n],     FibElse[n]]#apply#asNat

    class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        override  def apply: apply = (new _SlowFibonacci2(n.decrement).apply  plus new _SlowFibonacci2(n.decrement.decrement).apply).asInstanceOf[apply]
        override type apply        =      _SlowFibonacci2[n#decrement]#apply#plus    [_SlowFibonacci2[n#decrement#decrement]#apply]
    }
}


object FastFibonacci3 {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = new _FastFibonacci3().apply(n)
    type fibonacci[n <: Nat]                     =     _FastFibonacci3#apply[n]

}

class _FastFibonacci3 {
     def apply[n <: Nat](n: n): apply[n] = `if`(n  lt _2,  const0(n), new FibElse(n)).apply.asNat
    type apply[n <: Nat]                 = `if`[n#lt[_2], const0[n],     FibElse[n]]#apply#asNat

    class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        override  def apply: apply = (new _FastFibonacci3().apply(n.decrement)  plus new _FastFibonacci3().apply(n.decrement.decrement)).asInstanceOf[apply]
        override type apply        =      _FastFibonacci3#apply[n#decrement]#plus    [_FastFibonacci3#apply[n#decrement#decrement]]
    }
}


object SlowFibonacci4 {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = new _SlowFibonacci4(n).apply(n)
    type fibonacci[n <: Nat]                     =     _SlowFibonacci4[n]#apply[n]

}

class _SlowFibonacci4[m <: Nat](m: m) {
     def apply[n <: Nat](n: n): apply[n] = `if`(n  lt _2,  const0(n), new FibElse(n)).apply.asNat
    type apply[n <: Nat]                 = `if`[n#lt[_2], const0[n],     FibElse[n]]#apply#asNat

    class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        override  def apply: apply = (new _SlowFibonacci4(m).apply(n.decrement)  plus new _SlowFibonacci4(m).apply(n.decrement.decrement)).asInstanceOf[apply]
        override type apply        =      _SlowFibonacci4[m]#apply[n#decrement]#plus    [_SlowFibonacci4[m]#apply[n#decrement#decrement]]
    }
}


object SlowFibonacci5 {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = new _SlowFibonacci5().apply(n)
    type fibonacci[n <: Nat]                     =     _SlowFibonacci5#apply[n]

    class _SlowFibonacci5 {
         def apply[n <: Nat](n: n): apply[n] = `if`(n  lt _2,  const0(n), new FibElse(n)).apply.asNat
        type apply[n <: Nat]                 = `if`[n#lt[_2], const0[n],     FibElse[n]]#apply#asNat

        class FibElse[n <: Nat](n: n) extends AsFunction0 {
            override type self = FibElse[n]
            override  def apply: apply = (new _SlowFibonacci5().apply(n.decrement)  plus new _SlowFibonacci5().apply(n.decrement.decrement)).asInstanceOf[apply]
            override type apply        =      _SlowFibonacci5#apply[n#decrement]#plus    [_SlowFibonacci5#apply[n#decrement#decrement]]
        }
    }
}



object ShouldBeFastFibonacci {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = `if`(n  lt _2,  const0(n), Fib(_0, _1, n)).apply.asNat
    type fibonacci[n <: Nat]                     = `if`[n# lt[_2], const0[n], Fib[_0, _1, n]]#apply#asNat

    case class Fib[a <: Nat, b <: Nat, c <: Nat](a: a, b: b, c: c) extends AsFunction0 {
        override type self = Fib[a, b, c]
        override  def apply: apply = `if`(c.isZero, const0(a), FibElse(a, b, c)).apply.asNat
        override type apply        = `if`[c#isZero, const0[a], FibElse[a, b, c]]#apply#asNat
    }

    case class FibElse[a <: Nat, b <: Nat, c <: Nat](a: a, b: b, c: c) extends AsFunction0 {
        override type self = FibElse[a, b, c]
        override  def apply: apply = Fib(a  plus b,  a, c.decrement).apply.asInstanceOf[apply]
        override type apply        = Fib[a# plus[b], a, c#decrement]#apply
    }
}
