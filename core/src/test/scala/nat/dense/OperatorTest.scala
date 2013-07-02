

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
import okomok.sing.Test.{assertTrue, assertFalse}
//import okomok.sing.nat.Operator._
import okomok.sing.Dense.Literal._
import okomok.sing.Dense


/*
class OperatorTezt {
    trait testTrivial {
        assertTrue[_0 === _0]

        assertTrue[_0 !== _1]
        assertTrue[_1 !== _0]

        assertTrue[_1 === _1]

        assertTrue[_1 !== _2]
        assertTrue[_1 !== _3]
        assertTrue[_2 !== _1]
        assertTrue[_3 !== _1]

        assertTrue[_7 === _7]
        assertTrue[_2 !== _7]
        assertTrue[_7 !== _2]
        assertTrue[_6 !== _7]
        assertTrue[_7 !== _6]
        assertTrue[_0 !== _7]
        assertTrue[_7 !== _0]
        assertTrue[_1 !== _7]
        assertTrue[_7 !== _1]

        assertTrue[_1#increment === _2]
        assertTrue[_1#increment#increment === _3]

        assertTrue[_1#decrement === _0]
        assertTrue[_3#decrement#decrement === _1]
        assertTrue[_4#decrement === _3]
        assertTrue[_7#increment#decrement#decrement === _6]
    }

    trait testAdd {
        assertTrue[_0 + _0 === _0]
        assertTrue[_0 + _3 === _3]
        assertTrue[_4 + _3 === _7]
        assertTrue[_1 + _8 === _9]
        assertTrue[_5 + _2 === _7]
    }

    trait testSubtract {
        assertTrue[_0 - _0 === _0]
        assertTrue[_3 - _0 === _3]
        assertTrue[_4 - _3 === _1]
        assertTrue[_8 - _1 === _7]
        assertTrue[_5 - _2 === _3]
    }
/*
    trait testMultiply {
        assertTrue[_3 ** _2 === _6]
        assertTrue[_0 ** _3 === _0]
        assertTrue[_1 ** _3 === _3]
        assertTrue[_3 ** _1 === _3]
        assertTrue[_2 ** _3 === _6]
        assertTrue[_9 ** _1 === _9]
        assertTrue[_3 ** _3 === _9]
        assertTrue[_4 ** _2 === _8]

    }
*/
    trait testComparison {
        assertTrue[_0 < _2]
        assertTrue[_3 < _5]
        assertTrue[_3 <= _3]
        assertTrue[_5 > _3]
        assertTrue[_4 > _0]
        assertTrue[_4 >= _2]
        assertTrue[_0 <= _0]
        assertTrue[_0 >= _0]
        assertFalse[_3 > _5]
        assertFalse[_0 < _0]
        assertFalse[_0 > _0]
        assertFalse[_4 >= _5]
        assertFalse[_4 <= _2]
        assertFalse[_4 < _4]
        assertFalse[_4 > _4]
    }
/* still crash.
    trait testPropagation {
        type plusPlus[n <: Dense] = n#increment#increment
        type id[n <: Dense] = n#increment#decrement
        type equaL[n <: Dense, m <: Dense] = plusPlus[n] === id[m]

        assertTrue[plusPlus[_4] === _6]
        assertTrue[plusPlus[_7] === _9]
        assertTrue[id[_9] === _9]
        assertTrue[id[_7] === _7]

        assertTrue[equaL[_3, _5]]
        assertTrue[equaL[_4, _6]]

        // Must work; Visitor is no longer used.
        type subsub[n <: Dense, m <: Dense] = n#subtract[m]#subtract[m]
        assertTrue[subsub[_9, _2] === _5]
    }
*/
}

*/
