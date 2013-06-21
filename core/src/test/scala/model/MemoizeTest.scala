

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package modeltest


import com.github.okomok
import okomok.sing._
import okomok.sing.{assert => dassert}
import junit.framework.Assert._


import okomok.sing.Dense.Literal._
import okomok.sing.Dense.{_1B, _0B}
import FastFibonacci._


class MemoizeTest {

    trait Bar[t] {
        type kk = t
    }


    trait testMemoize {
        type t = fibonacci[_15#plus[_12]]
        Test.cassertSame[`true`, t# equal[_0B D_::_1B D_::_0B D_::_0B D_::_0B D_::_0B D_::_1B D_::_0B D_::_1B D_::_1B D_::_1B D_::_1B D_::_1B D_::_1B D_::_1B D_::_1B D_::_0B D_::_1B D_:: DNil]]
    }

}

