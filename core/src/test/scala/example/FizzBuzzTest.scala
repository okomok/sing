

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package example

    import com.github.okomok.sing
    import sing.Dense.Literal._

    trait FizzBuzzCompile {
        trait Fizz extends sing.Any
        trait Buzz extends sing.Any
        trait FizzBuzz extends sing.Any

        trait doFizzBuzz extends sing.AsFunction1 {
            override type self = doFizzBuzz
            override type apply[x <: sing.Any] =
                sing.`if`[x#asNat#rem[_15]#equal[_0],
                    sing.Const[FizzBuzz],
                    sing.`if`[x#asNat#rem[_3]#equal[_0],
                        sing.Const[Fizz],
                        sing.`if`[x#asNat#rem[_5]#equal[_0],
                            sing.Const[Buzz],
                            sing.Const[x]
                        ]
                    ]
                ]#apply
        }


        trait testTrivial {
            import sing.::

            type res = sing.List.range[_1, _16]#map[doFizzBuzz]#force

           // sing.echo[res]

            sing.Test.assertSame[res,
                _1 :: _2 :: Fizz :: _4 :: Buzz :: Fizz :: _7 :: _8 :: Fizz :: Buzz :: _11 :: Fizz :: _13 :: _14 :: FizzBuzz :: sing.Nil]

        }
    }
