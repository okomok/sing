

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


object AsciiLiteral {

    private[this]  val _0B = `false`
    private[this] type _0B = `false`

    private[this]  val _1B = `true`
    private[this] type _1B = `true`

     val ` `: ` ` = new ` `{}
     val  ! :  !  = new  ! {}
     val `"`: `"` = new `"`{}
     val `#`: `#` = new `#`{}
     val `$`: `$` = new `$`{}
     val  % :  %  = new  % {}
     val  & :  &  = new  & {}
     val `'`: `'` = new `'`{}
     val `(`: `(` = new `(`{}
     val `)`: `)` = new `)`{}
     val  * :  *  = new  * {}
     val  + :  +  = new  + {}
     val `,`: `,` = new `,`{}
     val  - :  -  = new  - {}
     val `.`: `.` = new `.`{}
     val  / :  /  = new  / {}
     val `0`: `0` = new `0`{}
     val `1`: `1` = new `1`{}
     val `2`: `2` = new `2`{}
     val `3`: `3` = new `3`{}
     val `4`: `4` = new `4`{}
     val `5`: `5` = new `5`{}
     val `6`: `6` = new `6`{}
     val `7`: `7` = new `7`{}
     val `8`: `8` = new `8`{}
     val `9`: `9` = new `9`{}
     val `:`: `:` = new `:`{}
     val `;`: `;` = new `;`{}
     val  < :  <  = new  < {}
     val `=`: `=` = new `=`{}
     val  > :  >  = new  > {}
     val  ? :  ?  = new  ? {}
	 val  A :  A  = new  A {}
	 val  B :  B  = new  B {}
	 val  C :  C  = new  C {}
	 val  D :  D  = new  D {}
	 val  E :  E  = new  E {}
	 val  F :  F  = new  F {}
	 val  G :  G  = new  G {}
	 val  H :  H  = new  H {}
	 val  I :  I  = new  I {}
     val  J :  J  = new  J {}
	 val  K :  K  = new  K {}
	 val  L :  L  = new  L {}
	 val  M :  M  = new  M {}
	 val  N :  N  = new  N {}
	 val  O :  O  = new  O {}
	 val  P :  P  = new  P {}
	 val  Q :  Q  = new  Q {}
	 val  R :  R  = new  R {}
	 val  S :  S  = new  S {}
	 val  T :  T  = new  T {}
	 val  U :  U  = new  U {}
	 val  V :  V  = new  V {}
	 val  W :  W  = new  W {}
	 val  X :  X  = new  X {}
	 val  Y :  Y  = new  Y {}
	 val  Z :  Z  = new  Z {}
     val `[`: `[` = new `[`{}
     val BSL: BSL = new BSL{}
     val `]`: `]` = new `]`{}
     val  ^ :  ^  = new  ^ {}
     val UNS: UNS = new UNS{}
     val BQ : BQ  = new BQ {}
     val  a :  a  = new  a {}
     val  b :  b  = new  b {}
     val  c :  c  = new  c {}
     val  d :  d  = new  d {}
     val  e :  e  = new  e {}
     val  f :  f  = new  f {}
     val  g :  g  = new  g {}
     val  h :  h  = new  h {}
     val  i :  i  = new  i {}
     val  j :  j  = new  j {}
     val  k :  k  = new  k {}
     val  l :  l  = new  l {}
     val  m :  m  = new  m {}
     val  n :  n  = new  n {}
     val  o :  o  = new  o {}
     val  p :  p  = new  p {}
     val  q :  q  = new  q {}
     val  r :  r  = new  r {}
     val  s :  s  = new  s {}
     val  t :  t  = new  t {}
     val  u :  u  = new  u {}
     val  v :  v  = new  v {}
     val  w :  w  = new  w {}
     val  x :  x  = new  x {}
     val  y :  y  = new  y {}
     val  z :  z  = new  z {}
     val `{`: `{` = new `{`{}
     val  | :  |  = new  | {}
     val `}`: `}` = new `}`{}
     val  ~ :  ~  = new  ~ {}

    sealed abstract class ` ` extends Strong(_0B :: _0B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self = ` `
    }
    sealed abstract class  !  extends Strong(_1B :: _0B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  !
    }
    sealed abstract class `"` extends Strong(_0B :: _1B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self = `"`
    }
    sealed abstract class `#` extends Strong(_0B :: _1B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self = `#`
    }
    sealed abstract class `$` extends Strong(_0B :: _0B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self = `$`
    }
    sealed abstract class  %  extends Strong(_1B :: _0B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  %
    }
    sealed abstract class  &  extends Strong(_0B :: _1B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  &
    }
    sealed abstract class `'` extends Strong(_1B :: _1B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self = `'`
    }
    sealed abstract class `(` extends Strong(_0B :: _0B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self = `(`
    }
    sealed abstract class `)` extends Strong(_1B :: _0B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self = `)`
    }
    sealed abstract class  *  extends Strong(_0B :: _1B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  *
    }
    sealed abstract class  +  extends Strong(_1B :: _1B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  +
    }
    sealed abstract class `,` extends Strong(_0B :: _0B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self = `,`
    }
    sealed abstract class  -  extends Strong(_1B :: _0B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self =  -
    }
    sealed abstract class `.` extends Strong(_0B :: _1B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self = `.`
    }
    sealed abstract class  /  extends Strong(_1B :: _1B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self =  /
    }
    sealed abstract class `0` extends Strong(_0B :: _0B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self = `0`
    }
    sealed abstract class `1` extends Strong(_1B :: _0B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self = `1`
    }
    sealed abstract class `2` extends Strong(_0B :: _1B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self = `2`
    }
    sealed abstract class `3` extends Strong(_1B :: _1B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self = `3`
    }
    sealed abstract class `4` extends Strong(_0B :: _0B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self = `4`
    }
    sealed abstract class `5` extends Strong(_1B :: _0B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self = `5`
    }
    sealed abstract class `6` extends Strong(_0B :: _1B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self = `6`
    }
    sealed abstract class `7` extends Strong(_1B :: _1B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self = `7`
    }
    sealed abstract class `8` extends Strong(_0B :: _0B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self = `8`
    }
    sealed abstract class `9` extends Strong(_1B :: _0B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self = `9`
    }
    sealed abstract class `:` extends Strong(_0B :: _1B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self = `:`
    }
    sealed abstract class `;` extends Strong(_1B :: _1B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self = `;`
    }
    sealed abstract class  <  extends Strong(_0B :: _0B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  <
    }
    sealed abstract class `=` extends Strong(_1B :: _0B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self = `=`
    }
    sealed abstract class  >  extends Strong(_0B :: _1B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  >
    }
    sealed abstract class  ?  extends Strong(_1B :: _1B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  ?
    }
    sealed abstract class `@Annotation.` extends Strong(_0B :: _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self = `@Annotation.`
    }
	sealed abstract class  A  extends Strong(_1B :: _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  A
    }
	sealed abstract class  B  extends Strong(_0B :: _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  B
    }
	sealed abstract class  C  extends Strong(_1B :: _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  C
    }
	sealed abstract class  D  extends Strong(_0B :: _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  D
    }
	sealed abstract class  E  extends Strong(_1B :: _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  E
    }
	sealed abstract class  F  extends Strong(_0B :: _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  F
    }
	sealed abstract class  G  extends Strong(_1B :: _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: Nil) {
        type self =  G
    }
	sealed abstract class  H  extends Strong(_0B :: _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  H
    }
	sealed abstract class  I  extends Strong(_1B :: _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  I
    }
    sealed abstract class  J  extends Strong(_0B :: _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  J
    }
	sealed abstract class  K  extends Strong(_1B :: _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  K
    }
	sealed abstract class  L  extends Strong(_0B :: _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  L
    }
	sealed abstract class  M  extends Strong(_1B :: _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  M
    }
	sealed abstract class  N  extends Strong(_0B :: _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  N
    }
	sealed abstract class  O  extends Strong(_1B :: _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: Nil) {
        type self =  O
    }
	sealed abstract class  P  extends Strong(_0B :: _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  P
    }
	sealed abstract class  Q  extends Strong(_1B :: _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  Q
    }
	sealed abstract class  R  extends Strong(_0B :: _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  R
    }
	sealed abstract class  S  extends Strong(_1B :: _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  S
    }
	sealed abstract class  T  extends Strong(_0B :: _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  T
    }
	sealed abstract class  U  extends Strong(_1B :: _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  U
    }
	sealed abstract class  V  extends Strong(_0B :: _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  V
    }
	sealed abstract class  W  extends Strong(_1B :: _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: Nil) {
        type self =  W
    }
	sealed abstract class  X  extends Strong(_0B :: _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self =  X
    }
	sealed abstract class  Y  extends Strong(_1B :: _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self =  Y
    }
	sealed abstract class  Z  extends Strong(_0B :: _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self =  Z
    }
    sealed abstract class `[` extends Strong(_1B :: _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self = `[`
    }
    sealed abstract class BSL extends Strong(_0B :: _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self = BSL
    }
    sealed abstract class `]` extends Strong(_1B :: _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self = `]`
    }
    sealed abstract class  ^  extends Strong(_0B :: _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self =  ^
    }
    sealed abstract class UNS extends Strong(_1B :: _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: Nil) {
        type self = UNS
    }
    sealed abstract class BQ  extends Strong(_0B :: _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self = BQ
    }
    type a = _AsciiLiteral.a
    type b = _AsciiLiteral.b
    type c = _AsciiLiteral.c
    type d = _AsciiLiteral.d
    type e = _AsciiLiteral.e
    type f = _AsciiLiteral.f
    type g = _AsciiLiteral.g
    type h = _AsciiLiteral.h
    type i = _AsciiLiteral.i
    type j = _AsciiLiteral.j
    type k = _AsciiLiteral.k
    type l = _AsciiLiteral.l
    type m = _AsciiLiteral.m
    type n = _AsciiLiteral.n
    type o = _AsciiLiteral.o
    type p = _AsciiLiteral.p
    type q = _AsciiLiteral.q
    type r = _AsciiLiteral.r
    type s = _AsciiLiteral.s
    type t = _AsciiLiteral.t
    type u = _AsciiLiteral.u
    type v = _AsciiLiteral.v
    type w = _AsciiLiteral.w
    type x = _AsciiLiteral.x
    type y = _AsciiLiteral.y
    type z = _AsciiLiteral.z
    sealed abstract class `{` extends Strong(_1B :: _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self = `{`
    }
    sealed abstract class  |  extends Strong(_0B :: _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  |
    }
    sealed abstract class `}` extends Strong(_1B :: _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self = `}`
    }
    sealed abstract class  ~  extends Strong(_0B :: _1B :: _1B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  ~
    }

}


@Annotation.compilerWorkaround("2.8.0") // One-letter names confuse JVM.
private[sing]
object _AsciiLiteral {

    sealed abstract class  a  extends Strong(_1B :: _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  a
    }
    sealed abstract class  b  extends Strong(_0B :: _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  b
    }
    sealed abstract class  c  extends Strong(_1B :: _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  c
    }
    sealed abstract class  d  extends Strong(_0B :: _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  d
    }
    sealed abstract class  e  extends Strong(_1B :: _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  e
    }
    sealed abstract class  f  extends Strong(_0B :: _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  f
    }
    sealed abstract class  g  extends Strong(_1B :: _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: Nil) {
        type self =  g
    }
    sealed abstract class  h  extends Strong(_0B :: _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  h
    }
    sealed abstract class  i  extends Strong(_1B :: _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  i
    }
    sealed abstract class  j  extends Strong(_0B :: _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  j
    }
    sealed abstract class  k  extends Strong(_1B :: _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  k
    }
    sealed abstract class  l  extends Strong(_0B :: _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  l
    }
    sealed abstract class  m  extends Strong(_1B :: _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  m
    }
    sealed abstract class  n  extends Strong(_0B :: _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  n
    }
    sealed abstract class  o  extends Strong(_1B :: _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: Nil) {
        type self =  o
    }
    sealed abstract class  p  extends Strong(_0B :: _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  p
    }
    sealed abstract class  q  extends Strong(_1B :: _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  q
    }
    sealed abstract class  r  extends Strong(_0B :: _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  r
    }
    sealed abstract class  s  extends Strong(_1B :: _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  s
    }
    sealed abstract class  t  extends Strong(_0B :: _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  t
    }
    sealed abstract class  u  extends Strong(_1B :: _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  u
    }
    sealed abstract class  v  extends Strong(_0B :: _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  v
    }
    sealed abstract class  w  extends Strong(_1B :: _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: Nil) {
        type self =  w
    }
    sealed abstract class  x  extends Strong(_0B :: _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  x
    }
    sealed abstract class  y  extends Strong(_1B :: _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  y
    }
    sealed abstract class  z  extends Strong(_0B :: _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: Nil) {
        type self =  z
    }

}
