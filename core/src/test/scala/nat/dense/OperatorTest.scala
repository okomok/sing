

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
//import okomok.sing.nat.Operator._
import okomok.sing.Dense.Literal._
import okomok.sing.Dense


/*
class OperatorTezt {
    trait testTrivial {
        AssertTrue[_0 === _0]

        AssertTrue[_0 !== _1]
        AssertTrue[_1 !== _0]

        AssertTrue[_1 === _1]

        AssertTrue[_1 !== _2]
        AssertTrue[_1 !== _3]
        AssertTrue[_2 !== _1]
        AssertTrue[_3 !== _1]

        AssertTrue[_7 === _7]
        AssertTrue[_2 !== _7]
        AssertTrue[_7 !== _2]
        AssertTrue[_6 !== _7]
        AssertTrue[_7 !== _6]
        AssertTrue[_0 !== _7]
        AssertTrue[_7 !== _0]
        AssertTrue[_1 !== _7]
        AssertTrue[_7 !== _1]

        AssertTrue[_1#increment === _2]
        AssertTrue[_1#increment#increment === _3]

        AssertTrue[_1#decrement === _0]
        AssertTrue[_3#decrement#decrement === _1]
        AssertTrue[_4#decrement === _3]
        AssertTrue[_7#increment#decrement#decrement === _6]
    }

    trait testAdd {
        AssertTrue[_0 + _0 === _0]
        AssertTrue[_0 + _3 === _3]
        AssertTrue[_4 + _3 === _7]
        AssertTrue[_1 + _8 === _9]
        AssertTrue[_5 + _2 === _7]
    }

    trait testSubtract {
        AssertTrue[_0 - _0 === _0]
        AssertTrue[_3 - _0 === _3]
        AssertTrue[_4 - _3 === _1]
        AssertTrue[_8 - _1 === _7]
        AssertTrue[_5 - _2 === _3]
    }
/*
    trait testMultiply {
        AssertTrue[_3 ** _2 === _6]
        AssertTrue[_0 ** _3 === _0]
        AssertTrue[_1 ** _3 === _3]
        AssertTrue[_3 ** _1 === _3]
        AssertTrue[_2 ** _3 === _6]
        AssertTrue[_9 ** _1 === _9]
        AssertTrue[_3 ** _3 === _9]
        AssertTrue[_4 ** _2 === _8]

    }
*/
    trait testComparison {
        AssertTrue[_0 < _2]
        AssertTrue[_3 < _5]
        AssertTrue[_3 <= _3]
        AssertTrue[_5 > _3]
        AssertTrue[_4 > _0]
        AssertTrue[_4 >= _2]
        AssertTrue[_0 <= _0]
        AssertTrue[_0 >= _0]
        AssertFalse[_3 > _5]
        AssertFalse[_0 < _0]
        AssertFalse[_0 > _0]
        AssertFalse[_4 >= _5]
        AssertFalse[_4 <= _2]
        AssertFalse[_4 < _4]
        AssertFalse[_4 > _4]
    }
/* still crash.
    trait testPropagation {
        type plusPlus[n <: Dense] = n#increment#increment
        type id[n <: Dense] = n#increment#decrement
        type equaL[n <: Dense, m <: Dense] = plusPlus[n] === id[m]

        AssertTrue[plusPlus[_4] === _6]
        AssertTrue[plusPlus[_7] === _9]
        AssertTrue[id[_9] === _9]
        AssertTrue[id[_7] === _7]

        AssertTrue[equaL[_3, _5]]
        AssertTrue[equaL[_4, _6]]

        // Must work; Visitor is no longer used.
        type subsub[n <: Dense, m <: Dense] = n#subtract[m]#subtract[m]
        AssertTrue[subsub[_9, _2] === _5]
    }
*/
}

*/
