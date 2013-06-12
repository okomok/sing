

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package dense


import Dense.{::, _0B, _1B}


object AsciiLiteral {

    val ` ` : ` ` = _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
    val  !  :  !  = _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
    val `"` : `"` = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
    val `#` : `#` = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
    val `$` : `$` = _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
    val  %  :  %  = _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
    val  &  :  &  = _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
    val `'` : `'` = _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
    val `(` : `(` = _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
    val `)` : `)` = _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
    val  *  :  *  = _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
    val  +  :  +  = _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
    val `,` : `,` = _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    val  -  :  -  = _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    val `.` : `.` = _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    val  /  :  /  = _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    val `0` : `0` = _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    val `1` : `1` = _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    val `2` : `2` = _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    val `3` : `3` = _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    val `4` : `4` = _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    val `5` : `5` = _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    val `6` : `6` = _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    val `7` : `7` = _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    val `8` : `8` = _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    val `9` : `9` = _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    val `:` : `:` = _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    val `;` : `;` = _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  <  :  <  = _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    val `=` : `=` = _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    val  >  :  >  = _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil
    val  ?  :  ?  = _1B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil

    val `@` : `@` = _0B :: _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  A  :  A  = _1B :: _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  B  :  B  = _0B :: _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  C  :  C  = _1B :: _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  D  :  D  = _0B :: _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  E  :  E  = _1B :: _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  F  :  F  = _0B :: _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  G  :  G  = _1B :: _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	val  H  :  H  = _0B :: _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  I  :  I  = _1B :: _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
    val  J  :  J  = _0B :: _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  K  :  K  = _1B :: _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  L  :  L  = _0B :: _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  M  :  M  = _1B :: _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  N  :  N  = _0B :: _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  O  :  O  = _1B :: _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	val  P  :  P  = _0B :: _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  Q  :  Q  = _1B :: _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  R  :  R  = _0B :: _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  S  :  S  = _1B :: _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  T  :  T  = _0B :: _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  U  :  U  = _1B :: _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  V  :  V  = _0B :: _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  W  :  W  = _1B :: _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	val  X  :  X  = _0B :: _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
	val  Y  :  Y  = _1B :: _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
	val  Z  :  Z  = _0B :: _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    val `[` : `[` = _1B :: _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    val BSL : BSL = _0B :: _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    val `]` : `]` = _1B :: _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    val  ^  :  ^  = _0B :: _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    val UNS : UNS = _1B :: _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    val BQ  : BQ  = _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil

    val  a  :  a  = _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  b  :  b  = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  c  :  c  = _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  d  :  d  = _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  e  :  e  = _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  f  :  f  = _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  g  :  g  = _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    val  h  :  h  = _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  i  :  i  = _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  j  :  j  = _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  k  :  k  = _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  l  :  l  = _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  m  :  m  = _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  n  :  n  = _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  o  :  o  = _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    val  p  :  p  = _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  q  :  q  = _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  r  :  r  = _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  s  :  s  = _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  t  :  t  = _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  u  :  u  = _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  v  :  v  = _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  w  :  w  = _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    val  x  :  x  = _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    val  y  :  y  = _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    val  z  :  z  = _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil

    val `{` : `{` = _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    val  |  :  |  = _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil
    val `}` : `}` = _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil
    val  ~  :  ~  = _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil


    type ` ` = _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
    type  !  = _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
    type `"` = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
    type `#` = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
    type `$` = _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
    type  %  = _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
    type  &  = _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
    type `'` = _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
    type `(` = _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
    type `)` = _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
    type  *  = _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
    type  +  = _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
    type `,` = _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    type  -  = _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    type `.` = _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    type  /  = _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    type `0` = _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    type `1` = _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    type `2` = _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    type `3` = _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    type `4` = _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    type `5` = _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    type `6` = _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    type `7` = _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    type `8` = _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    type `9` = _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    type `:` = _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    type `;` = _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  <  = _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    type `=` = _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    type  >  = _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil
    type  ?  = _1B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil

    type `@` = _0B :: _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  A  = _1B :: _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  B  = _0B :: _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  C  = _1B :: _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  D  = _0B :: _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  E  = _1B :: _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  F  = _0B :: _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  G  = _1B :: _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: DNil
	type  H  = _0B :: _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  I  = _1B :: _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
    type  J  = _0B :: _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  K  = _1B :: _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  L  = _0B :: _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  M  = _1B :: _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  N  = _0B :: _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  O  = _1B :: _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: DNil
	type  P  = _0B :: _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  Q  = _1B :: _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  R  = _0B :: _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  S  = _1B :: _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  T  = _0B :: _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  U  = _1B :: _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  V  = _0B :: _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  W  = _1B :: _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: DNil
	type  X  = _0B :: _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
	type  Y  = _1B :: _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
	type  Z  = _0B :: _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    type `[` = _1B :: _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: DNil
    type BSL = _0B :: _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    type `]` = _1B :: _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    type  ^  = _0B :: _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    type UNS = _1B :: _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: DNil
    type BQ  = _0B :: _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil

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

    type `{` = _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    type  |  = _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil
    type `}` = _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil
    type  ~  = _0B :: _1B :: _1B :: _1B :: _1B :: _1B :: _1B :: DNil

}


@Annotation.compilerWorkaround("2.8.0") // One-letter names confuse JVM.
private[sing]
object _AsciiLiteral {

    type  a  = _1B :: _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  b  = _0B :: _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  c  = _1B :: _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  d  = _0B :: _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  e  = _1B :: _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  f  = _0B :: _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  g  = _1B :: _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: DNil
    type  h  = _0B :: _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  i  = _1B :: _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  j  = _0B :: _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  k  = _1B :: _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  l  = _0B :: _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  m  = _1B :: _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  n  = _0B :: _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  o  = _1B :: _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: DNil
    type  p  = _0B :: _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  q  = _1B :: _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  r  = _0B :: _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  s  = _1B :: _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  t  = _0B :: _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  u  = _1B :: _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  v  = _0B :: _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  w  = _1B :: _1B :: _1B :: _0B :: _1B :: _1B :: _1B :: DNil
    type  x  = _0B :: _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    type  y  = _1B :: _0B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil
    type  z  = _0B :: _1B :: _0B :: _1B :: _1B :: _1B :: _1B :: DNil

}
