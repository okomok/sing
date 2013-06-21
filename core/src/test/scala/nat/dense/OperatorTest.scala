

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
import okomok.sing.Test.{cassert, cassertNot}
//import okomok.sing.nat.Operator._
import okomok.sing.Dense.Literal._
import okomok.sing.Dense


/*
class OperatorTezt {
    trait testTrivial {
        cassert[_0 === _0]

        cassert[_0 !== _1]
        cassert[_1 !== _0]

        cassert[_1 === _1]

        cassert[_1 !== _2]
        cassert[_1 !== _3]
        cassert[_2 !== _1]
        cassert[_3 !== _1]

        cassert[_7 === _7]
        cassert[_2 !== _7]
        cassert[_7 !== _2]
        cassert[_6 !== _7]
        cassert[_7 !== _6]
        cassert[_0 !== _7]
        cassert[_7 !== _0]
        cassert[_1 !== _7]
        cassert[_7 !== _1]

        cassert[_1#increment === _2]
        cassert[_1#increment#increment === _3]

        cassert[_1#decrement === _0]
        cassert[_3#decrement#decrement === _1]
        cassert[_4#decrement === _3]
        cassert[_7#increment#decrement#decrement === _6]
    }

    trait testAdd {
        cassert[_0 + _0 === _0]
        cassert[_0 + _3 === _3]
        cassert[_4 + _3 === _7]
        cassert[_1 + _8 === _9]
        cassert[_5 + _2 === _7]
    }

    trait testSubtract {
        cassert[_0 - _0 === _0]
        cassert[_3 - _0 === _3]
        cassert[_4 - _3 === _1]
        cassert[_8 - _1 === _7]
        cassert[_5 - _2 === _3]
    }
/*
    trait testMultiply {
        cassert[_3 ** _2 === _6]
        cassert[_0 ** _3 === _0]
        cassert[_1 ** _3 === _3]
        cassert[_3 ** _1 === _3]
        cassert[_2 ** _3 === _6]
        cassert[_9 ** _1 === _9]
        cassert[_3 ** _3 === _9]
        cassert[_4 ** _2 === _8]

    }
*/
    trait testComparison {
        cassert[_0 < _2]
        cassert[_3 < _5]
        cassert[_3 <= _3]
        cassert[_5 > _3]
        cassert[_4 > _0]
        cassert[_4 >= _2]
        cassert[_0 <= _0]
        cassert[_0 >= _0]
        cassertNot[_3 > _5]
        cassertNot[_0 < _0]
        cassertNot[_0 > _0]
        cassertNot[_4 >= _5]
        cassertNot[_4 <= _2]
        cassertNot[_4 < _4]
        cassertNot[_4 > _4]
    }
/* still crash.
    trait testPropagation {
        type plusPlus[n <: Dense] = n#increment#increment
        type id[n <: Dense] = n#increment#decrement
        type equaL[n <: Dense, m <: Dense] = plusPlus[n] === id[m]

        cassert[plusPlus[_4] === _6]
        cassert[plusPlus[_7] === _9]
        cassert[id[_9] === _9]
        cassert[id[_7] === _7]

        cassert[equaL[_3, _5]]
        cassert[equaL[_4, _6]]

        // Must work; Visitor is no longer used.
        type subsub[n <: Dense, m <: Dense] = n#subtract[m]#subtract[m]
        cassert[subsub[_9, _2] === _5]
    }
*/
}

*/
