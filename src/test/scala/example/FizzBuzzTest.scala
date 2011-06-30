

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

            // sing.free.printe[sing.List.range[_1, _16]#map[fizzbuzz]#force]

            sing.free.assertSame[sing.List.range[_1, _16]#map[fizzbuzz]#force,
                _1 :: _2 :: Fizz :: _4 :: Buzz :: Fizz :: _7 :: _8 :: Fizz :: Buzz :: _11 :: Fizz :: _13 :: _14 :: FizzBuzz :: sing.Nil]

        }
    }
