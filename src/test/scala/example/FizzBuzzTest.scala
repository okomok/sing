

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package example

    import com.github.okomok.sing
    import sing.nat.dense.Literal._

    trait FizzBuzzCompile {
        trait Fizz extends sing.Any
        trait Buzz extends sing.Any
        trait FizzBuzz extends sing.Any

        trait fizzbuzz extends sing.Function1 {
            override type self = fizzbuzz
            override type apply[x <: sing.Any] =
                sing.`if`[x#asNat#rem[_15]#equal[_0],
                    sing.const0[FizzBuzz],
                    sing.`if`[x#asNat#rem[_3]#equal[_0],
                        sing.const0[Fizz],
                        sing.`if`[x#asNat#rem[_5]#equal[_0],
                            sing.const0[Buzz],
                            sing.const0[x]
                        ]
                    ]
                ]#apply
        }

        trait testTrivial {
            import sing.::

            // print[sing.List.range[_1, _16]#map[fizzbuzz]#force]

            sing.free.assertSame[sing.List.range[_1, _16]#map[fizzbuzz]#force,
                _1 :: _2 :: Fizz :: _4 :: Buzz :: Fizz :: _7 :: _8 :: Fizz :: Buzz :: _11 :: Fizz :: _13 :: _14 :: FizzBuzz :: sing.Nil]

        }

        // type-alias not expanded.
        @scala.annotation.implicitNotFound("print: ${T}")
        trait Print[T]
        def print[T : Print] = ()
    }



/*
        trait Never
        def print[a <: scala.Nothing] = ()
*/



        /*
        case object Fizz extends sing.Any {
            override type self = Fizz.type
            override type unsing = Fizz.type
            override def unsing: unsing = this
            override def toString = "Fizz"
        }
        case object Buzz extends sing.Any {
            override type self = Buzz.type
            override type unsing = Buzz.type
            override def unsing: unsing = this
            override def toString = "Buzz"
        }
        case object FizzBuzz extends sing.Any {
            override type self = FizzBuzz.type
            override type unsing = FizzBuzz.type
            override def unsing: unsing = this
            override def toString = "FizzBuzz"
        }

        implicit object UnmetaFizz extends sing.Unmeta[Fizz.type] {
            override def apply = Fizz
        }

        implicit object UnmetaBuzz extends sing.Unmeta[Buzz.type] {
            override def apply = Buzz
        }

        implicit object UnmetaFizzBuzz extends sing.Unmeta[FizzBuzz.type] {
            override def apply = FizzBuzz
        }

        trait fizzbuzz extends sing.Function1 {
            override type self = fizzbuzz
            override type apply[x <: sing.Any] =
                sing.`if`[x#asNat#rem[_15]#equal[_0],
                    sing.const0[FizzBuzz.type],
                    sing.`if`[x#asNat#rem[_3]#equal[_0],
                        sing.const0[Fizz.type],
                        sing.`if`[x#asNat#rem[_5]#equal[_0],
                            sing.const0[Buzz.type],
                            sing.const0[x]
                        ]
                    ]
                ]#apply
        }

        def testTrivial {
            type result = sing.List.range[_0, _10]#map[fizzbuzz]#force
            println(sing.unmeta[result])
        }
        */
