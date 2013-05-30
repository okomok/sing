

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
trait CommonLiteral {

    @annotation.aliasOf("`false`")
     val _0B = `false`
    type _0B = `false`

    @annotation.aliasOf("`true`")
     val _1B = `true`
    type _1B = `true`

    private[this]  val __Nil: Nil = _Dense.Nil
    private[this] type __::[x <: Boolean, xs <: Dense] = Cons[x, xs]

	 val  _0:  _0 = __Nil

	 val  _1:  _1 = _1B :: __Nil
	 val  _2:  _2 = _0B :: _1B :: __Nil
	 val  _3:  _3 = _1B :: _1B :: __Nil
	 val  _4:  _4 = _0B :: _0B :: _1B :: __Nil
	 val  _5:  _5 = _1B :: _0B :: _1B :: __Nil
	 val  _6:  _6 = _0B :: _1B :: _1B :: __Nil
	 val  _7:  _7 = _1B :: _1B :: _1B :: __Nil
	 val  _8:  _8 = _0B :: _0B :: _0B :: _1B :: __Nil
	 val  _9:  _9 = _1B :: _0B :: _0B :: _1B :: __Nil
	 val _10: _10 = _0B :: _1B :: _0B :: _1B :: __Nil

	 val _11: _11 = _1B :: _1B :: _0B :: _1B :: __Nil
	 val _12: _12 = _0B :: _0B :: _1B :: _1B :: __Nil
	 val _13: _13 = _1B :: _0B :: _1B :: _1B :: __Nil
	 val _14: _14 = _0B :: _1B :: _1B :: _1B :: __Nil
	 val _15: _15 = _1B :: _1B :: _1B :: _1B :: __Nil
	 val _16: _16 = _0B :: _0B :: _0B :: _0B :: _1B :: __Nil
     val _17: _17 = _1B :: _0B :: _0B :: _0B :: _1B :: __Nil
     val _18: _18 = _0B :: _1B :: _0B :: _0B :: _1B :: __Nil
     val _19: _19 = _1B :: _1B :: _0B :: _0B :: _1B :: __Nil
	 val _20: _20 = _0B :: _0B :: _1B :: _0B :: _1B :: __Nil

     val _21: _21 = _1B :: _0B :: _1B :: _0B :: _1B :: __Nil
     val _22: _22 = _0B :: _1B :: _1B :: _0B :: _1B :: __Nil
     val _23: _23 = _1B :: _1B :: _1B :: _0B :: _1B :: __Nil
	 val _24: _24 = _0B :: _0B :: _0B :: _1B :: _1B :: __Nil
     val _25: _25 = _1B :: _0B :: _0B :: _1B :: _1B :: __Nil
     val _26: _26 = _0B :: _1B :: _0B :: _1B :: _1B :: __Nil
     val _27: _27 = _1B :: _1B :: _0B :: _1B :: _1B :: __Nil
	 val _28: _28 = _0B :: _0B :: _1B :: _1B :: _1B :: __Nil
     val _29: _29 = _1B :: _0B :: _1B :: _1B :: _1B :: __Nil
     val _30: _30 = _0B :: _1B :: _1B :: _1B :: _1B :: __Nil

     val _31: _31 = _1B :: _1B :: _1B :: _1B :: _1B :: __Nil
     val _32: _32 = _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: __Nil
     val _33: _33 = _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: __Nil
     val _34: _34 = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: __Nil
     val _35: _35 = _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: __Nil
     val _36: _36 = _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: __Nil
     val _37: _37 = _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: __Nil
     val _38: _38 = _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: __Nil
     val _39: _39 = _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: __Nil
     val _40: _40 = _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: __Nil

     val _41: _41 = _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: __Nil
     val _42: _42 = _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: __Nil
     val _43: _43 = _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: __Nil
     val _44: _44 = _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: __Nil
     val _45: _45 = _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: __Nil
     val _46: _46 = _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: __Nil
     val _47: _47 = _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: __Nil
     val _48: _48 = _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: __Nil
     val _49: _49 = _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: __Nil
     val _50: _50 = _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: __Nil

	type  _0 = Nil

	type  _1 = _1B __:: Nil
	type  _2 = _0B __:: _1B __:: Nil
	type  _3 = _1B __:: _1B __:: Nil
	type  _4 = _0B __:: _0B __:: _1B __:: Nil
	type  _5 = _1B __:: _0B __:: _1B __:: Nil
	type  _6 = _0B __:: _1B __:: _1B __:: Nil
	type  _7 = _1B __:: _1B __:: _1B __:: Nil
	type  _8 = _0B __:: _0B __:: _0B __:: _1B __:: Nil
	type  _9 = _1B __:: _0B __:: _0B __:: _1B __:: Nil
	type _10 = _0B __:: _1B __:: _0B __:: _1B __:: Nil

	type _11 = _1B __:: _1B __:: _0B __:: _1B __:: Nil
	type _12 = _0B __:: _0B __:: _1B __:: _1B __:: Nil
	type _13 = _1B __:: _0B __:: _1B __:: _1B __:: Nil
	type _14 = _0B __:: _1B __:: _1B __:: _1B __:: Nil
	type _15 = _1B __:: _1B __:: _1B __:: _1B __:: Nil
	type _16 = _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: Nil
    type _17 = _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: Nil
    type _18 = _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: Nil
    type _19 = _1B __:: _1B __:: _0B __:: _0B __:: _1B __:: Nil
	type _20 = _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: Nil

    type _21 = _1B __:: _0B __:: _1B __:: _0B __:: _1B __:: Nil
    type _22 = _0B __:: _1B __:: _1B __:: _0B __:: _1B __:: Nil
    type _23 = _1B __:: _1B __:: _1B __:: _0B __:: _1B __:: Nil
	type _24 = _0B __:: _0B __:: _0B __:: _1B __:: _1B __:: Nil
    type _25 = _1B __:: _0B __:: _0B __:: _1B __:: _1B __:: Nil
    type _26 = _0B __:: _1B __:: _0B __:: _1B __:: _1B __:: Nil
    type _27 = _1B __:: _1B __:: _0B __:: _1B __:: _1B __:: Nil
	type _28 = _0B __:: _0B __:: _1B __:: _1B __:: _1B __:: Nil
    type _29 = _1B __:: _0B __:: _1B __:: _1B __:: _1B __:: Nil
    type _30 = _0B __:: _1B __:: _1B __:: _1B __:: _1B __:: Nil

    type _31 = _1B __:: _1B __:: _1B __:: _1B __:: _1B __:: Nil
    type _32 = _0B __:: _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: Nil
    type _33 = _1B __:: _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: Nil
    type _34 = _0B __:: _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: Nil
    type _35 = _1B __:: _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: Nil
    type _36 = _0B __:: _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: Nil
    type _37 = _1B __:: _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: Nil
    type _38 = _0B __:: _1B __:: _1B __:: _0B __:: _0B __:: _1B __:: Nil
    type _39 = _1B __:: _1B __:: _1B __:: _0B __:: _0B __:: _1B __:: Nil
    type _40 = _0B __:: _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: Nil

    type _41 = _1B __:: _0B __:: _0B __:: _1B __:: _0B __:: _1B __:: Nil
    type _42 = _0B __:: _1B __:: _0B __:: _1B __:: _0B __:: _1B __:: Nil
    type _43 = _1B __:: _1B __:: _0B __:: _1B __:: _0B __:: _1B __:: Nil
    type _44 = _0B __:: _0B __:: _1B __:: _1B __:: _0B __:: _1B __:: Nil
    type _45 = _1B __:: _0B __:: _1B __:: _1B __:: _0B __:: _1B __:: Nil
    type _46 = _0B __:: _1B __:: _1B __:: _1B __:: _0B __:: _1B __:: Nil
    type _47 = _1B __:: _1B __:: _1B __:: _1B __:: _0B __:: _1B __:: Nil
    type _48 = _0B __:: _0B __:: _0B __:: _0B __:: _1B __:: _1B __:: Nil
    type _49 = _1B __:: _0B __:: _0B __:: _0B __:: _1B __:: _1B __:: Nil
    type _50 = _0B __:: _1B __:: _0B __:: _0B __:: _1B __:: _1B __:: Nil

}
