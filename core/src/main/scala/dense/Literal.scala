

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package dense


private[sing]
trait Literal {

    @Annotation.returnThis
    val Literal: Literal = this

    @Annotation.aliasOf("`false`")
     val _0B = `false`
    type _0B = `false`

    @Annotation.aliasOf("`true`")
     val _1B = `true`
    type _1B = `true`

    private[this] type __::[x <: Boolean, xs <: Dense] = DCons[x, xs]

	 val  _0:  _0 = DNil

	 val  _1:  _1 = _1B :: DNil
	 val  _2:  _2 = _0B :: _1B :: DNil
	 val  _3:  _3 = _1B :: _1B :: DNil
	 val  _4:  _4 = _0B :: _0B :: _1B :: DNil
	 val  _5:  _5 = _1B :: _0B :: _1B :: DNil
	 val  _6:  _6 = _0B :: _1B :: _1B :: DNil
	 val  _7:  _7 = _1B :: _1B :: _1B :: DNil
	 val  _8:  _8 = _0B :: _0B :: _0B :: _1B :: DNil
	 val  _9:  _9 = _1B :: _0B :: _0B :: _1B :: DNil
	 val _10: _10 = _0B :: _1B :: _0B :: _1B :: DNil

	 val _11: _11 = _1B :: _1B :: _0B :: _1B :: DNil
	 val _12: _12 = _0B :: _0B :: _1B :: _1B :: DNil
	 val _13: _13 = _1B :: _0B :: _1B :: _1B :: DNil
	 val _14: _14 = _0B :: _1B :: _1B :: _1B :: DNil
	 val _15: _15 = _1B :: _1B :: _1B :: _1B :: DNil
	 val _16: _16 = _0B :: _0B :: _0B :: _0B :: _1B :: DNil
     val _17: _17 = _1B :: _0B :: _0B :: _0B :: _1B :: DNil
     val _18: _18 = _0B :: _1B :: _0B :: _0B :: _1B :: DNil
     val _19: _19 = _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	 val _20: _20 = _0B :: _0B :: _1B :: _0B :: _1B :: DNil

     val _21: _21 = _1B :: _0B :: _1B :: _0B :: _1B :: DNil
     val _22: _22 = _0B :: _1B :: _1B :: _0B :: _1B :: DNil
     val _23: _23 = _1B :: _1B :: _1B :: _0B :: _1B :: DNil
	 val _24: _24 = _0B :: _0B :: _0B :: _1B :: _1B :: DNil
     val _25: _25 = _1B :: _0B :: _0B :: _1B :: _1B :: DNil
     val _26: _26 = _0B :: _1B :: _0B :: _1B :: _1B :: DNil
     val _27: _27 = _1B :: _1B :: _0B :: _1B :: _1B :: DNil
	 val _28: _28 = _0B :: _0B :: _1B :: _1B :: _1B :: DNil
     val _29: _29 = _1B :: _0B :: _1B :: _1B :: _1B :: DNil
     val _30: _30 = _0B :: _1B :: _1B :: _1B :: _1B :: DNil

     val _31: _31 = _1B :: _1B :: _1B :: _1B :: _1B :: DNil
     val _32: _32 = _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
     val _33: _33 = _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
     val _34: _34 = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
     val _35: _35 = _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
     val _36: _36 = _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
     val _37: _37 = _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
     val _38: _38 = _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
     val _39: _39 = _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
     val _40: _40 = _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil

     val _41: _41 = _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
     val _42: _42 = _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
     val _43: _43 = _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
     val _44: _44 = _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
     val _45: _45 = _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
     val _46: _46 = _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
     val _47: _47 = _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
     val _48: _48 = _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
     val _49: _49 = _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
     val _50: _50 = _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil

	type  _0 = DNil

	type  _1 = _1B __:: DNil
	type  _2 = _0B __:: _1B __:: DNil
	type  _3 = _1B __:: _1B __:: DNil
	type  _4 = _0B __:: _0B __:: _1B __:: DNil
	type  _5 = _1B __:: _0B __:: _1B __:: DNil
	type  _6 = _0B __:: _1B __:: _1B __:: DNil
	type  _7 = _1B __:: _1B __:: _1B __:: DNil
	type  _8 = _0B __:: _0B __:: _0B __:: _1B __:: DNil
	type  _9 = _1B __:: _0B __:: _0B __:: _1B __:: DNil
	type _10 = _0B __:: _1B __:: _0B __:: _1B __:: DNil

	type _11 = _1B __:: _1B __:: _0B __:: _1B __:: DNil
	type _12 = _0B __:: _0B __:: _1B __:: _1B __:: DNil
	type _13 = _1B __:: _0B __:: _1B __:: _1B __:: DNil
	type _14 = _0B __:: _1B __:: _1B __:: _1B __:: DNil
	type _15 = _1B __:: _1B __:: _1B __:: _1B __:: DNil
	type _16 = _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: DNil
    type _17 = _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: DNil
    type _18 = _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: DNil
    type _19 = _1B __:: _1B __:: _0B __:: _0B __:: _1B __:: DNil
	type _20 = _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: DNil

    type _21 = _1B __:: _0B __:: _1B __:: _0B __:: _1B __:: DNil
    type _22 = _0B __:: _1B __:: _1B __:: _0B __:: _1B __:: DNil
    type _23 = _1B __:: _1B __:: _1B __:: _0B __:: _1B __:: DNil
	type _24 = _0B __:: _0B __:: _0B __:: _1B __:: _1B __:: DNil
    type _25 = _1B __:: _0B __:: _0B __:: _1B __:: _1B __:: DNil
    type _26 = _0B __:: _1B __:: _0B __:: _1B __:: _1B __:: DNil
    type _27 = _1B __:: _1B __:: _0B __:: _1B __:: _1B __:: DNil
	type _28 = _0B __:: _0B __:: _1B __:: _1B __:: _1B __:: DNil
    type _29 = _1B __:: _0B __:: _1B __:: _1B __:: _1B __:: DNil
    type _30 = _0B __:: _1B __:: _1B __:: _1B __:: _1B __:: DNil

    type _31 = _1B __:: _1B __:: _1B __:: _1B __:: _1B __:: DNil
    type _32 = _0B __:: _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: DNil
    type _33 = _1B __:: _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: DNil
    type _34 = _0B __:: _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: DNil
    type _35 = _1B __:: _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: DNil
    type _36 = _0B __:: _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: DNil
    type _37 = _1B __:: _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: DNil
    type _38 = _0B __:: _1B __:: _1B __:: _0B __:: _0B __:: _1B __:: DNil
    type _39 = _1B __:: _1B __:: _1B __:: _0B __:: _0B __:: _1B __:: DNil
    type _40 = _0B __:: _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: DNil

    type _41 = _1B __:: _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: DNil
    type _42 = _0B __:: _1B __:: _0B __:: _1B __:: _0B __:: _1B __:: DNil
    type _43 = _1B __:: _1B __:: _0B __:: _1B __:: _0B __:: _1B __:: DNil
    type _44 = _0B __:: _0B __:: _1B __:: _1B __:: _0B __:: _1B __:: DNil
    type _45 = _1B __:: _0B __:: _1B __:: _1B __:: _0B __:: _1B __:: DNil
    type _46 = _0B __:: _1B __:: _1B __:: _1B __:: _0B __:: _1B __:: DNil
    type _47 = _1B __:: _1B __:: _1B __:: _1B __:: _0B __:: _1B __:: DNil
    type _48 = _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: _1B __:: DNil
    type _49 = _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: _1B __:: DNil
    type _50 = _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: _1B __:: DNil

}
