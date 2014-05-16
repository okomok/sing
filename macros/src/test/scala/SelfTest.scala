

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singmakrotest


import com.github.okomok.sing.makro._

class SelfTest extends org.scalatest.junit.JUnit3Suite {

    class Abc {
        @Self type me
    }

    class Foo[x] {
        @Self type self
    }

    class DDD {
        @Self type self[x]
    }

    def testTrivial {
        type x = Int

        implicitly[Abc#me =:= Abc]
        implicitly[Foo[x]#self =:= Foo[x]]
        implicitly[DDD#self[x] =:= DDD]
    }
}
