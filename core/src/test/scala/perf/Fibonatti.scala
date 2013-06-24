

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest.singtest
package perf


import com.github.okomok.sing._
import Dense._


object FastFibonacci {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = `if`(n.lt(_2), Const(n), FibElse(n)).apply.asNat
    type fibonacci[n <: Nat]                     = `if`[n#lt[_2], Const[n], FibElse[n]]#apply#asNat

    case class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        override  def apply: apply = fibonacci(id(n).decrement).plus(fibonacci(id(n).decrement.decrement))
        override type apply        = fibonacci[id[n]#decrement]#plus[fibonacci[id[n]#decrement#decrement]]
    }
}

object SlowFibonacci {
     def fibonacci[n <: Nat](n: n): fibonacci[n] = `if`(n.lt(_2), Const(n), FibElse(n)).apply.asNat
    type fibonacci[n <: Nat]                     = `if`[n#lt[_2], Const[n], FibElse[n]]#apply#asNat

    case class FibElse[n <: Nat](n: n) extends AsFunction0 {
        override type self = FibElse[n]
        // Now child-node type-expressions are different.
        override  def apply: apply = fibonacci(id(n).minus(_1)).plus(fibonacci(id(n).decrement.decrement))
        override type apply        = fibonacci[id[n]#minus[_1]]#plus[fibonacci[id[n]#decrement#decrement]]
    }
}
