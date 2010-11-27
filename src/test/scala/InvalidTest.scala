

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest


import com.github.okomok

import okomok.sing._
import okomok.sing.free._
import okomok.sing.nat.Peano
import okomok.sing.nat.peano.Literal._
// import junit.framework.Assert._


// Overriding generic-metamethod doesn't work.

object GenericMethodOverrideTezt {

    trait B {
        type foo[T, x <: T] <: T // "generic" metamethod (ie, result metatype depends on arguments.)
    }

    trait d extends B {
        override type foo[T, x <: T] = x
    }

    // OK
    type foo1[b <: B, x <: Peano] = b#foo[Peano, x]
    assertSame[foo1[d, _2]#increment, _3]

    // NO
    type foo2[b <: B, x <: Peano] = b#foo[Peano, x]#increment
    // assertSame[foo2[d, _2], _3]

    // NO
    type foo3[b <: B { type foo[Peano, x <: Peano] <: Peano }, x <: Peano] = b#foo[Peano, x]#increment
    type wow = foo3[d, _2] // Scala is smart!
    // assertSame[wow, _3] // but fails.
}

object GenericMethodOverride2Tezt {

    trait B {
        type foo[x]
    }

    trait d extends B {
        override type foo[x] = _3
    }

    // OK
    type foo1[b <: B, x <: Peano] = b#foo[x]
    assertSame[foo1[d, _2]#increment, _4]

    // NO, of course.
    // type foo2[b <: B, x <: Peano] = b#foo[x]#increment
}



object TypeConstraintTezt {

    trait B {
        type R
        type inc[n <: Peano] <: R
    }

    trait d extends B {
        type R = Peano
        override type inc[n <: Peano] = n#increment
    }

    // OK
    type foo1[b <: B { type R = Peano }, n <: Peano] = b#inc[n]
    assertSame[foo1[d, _2]#increment, _4]

    // NO
    type foo2[b <: B { type R = Peano }, n <: Peano] = b#inc[n]#increment
    // assertSame[foo2[d, _2], _4]

}

object TypeConstraint2Tezt {

    trait B[R] {
        type inc[n <: Peano] <: R
    }

    trait d extends B[Peano] {
        override type inc[n <: Peano] = n#increment
    }

    // OK
    type foo1[b <: B[Peano], n <: Peano] = b#inc[n]
    assertSame[foo1[d, _2]#increment, _4]

    // NO
    type foo2[b <: B[Peano], n <: Peano] = b#inc[n]#increment
    // assertSame[foo2[d, _2], _4]

}

object TypeConstraint3Tezt {

    trait B {
        type inc[n <: Peano] <: Peano
    }

    trait d extends B {
        override type inc[n <: Peano] = n#increment
    }

    // OK
    type foo1[b <: B, n <: Peano] = b#inc[n]
    assertSame[foo1[d, _2]#increment, _4]

    // OK
    type foo2[b <: B, n <: Peano] = b#inc[n]#increment
    assertSame[foo2[d, _2], _4]

}


object TypeConstraint4Tezt {

    type inc[n <: Peano] = n#increment

    // OK
    type foo1[_inc[_ <: Peano] <: Peano, n <: Peano] = _inc[n]
    assertSame[foo1[inc, _2]#increment, _4]

    // OK
    type foo2[_inc[_ <: Peano] <: Peano, n <: Peano] = _inc[n]#increment
    assertSame[foo2[inc, _2], _4]

}


object TypeConstraint5Tezt {

    trait B[R] {
        type inc[n <: Peano] <: R
    }

    trait d extends B[Peano] {
        override type inc[n <: Peano] = n#increment
    }

    // OK
    type foo1[b <: B[Peano], n <: Peano] = b#inc[n]
    assertSame[foo1[d, _2]#increment, _4]

    // OK (restate constraint!)
    // See also: http://lampsvn.epfl.ch/trac/scala/ticket/1786
    type foo2[b <: B[_] { type inc[n <: Peano] <: Peano }, n <: Peano] = b#inc[n]#increment
    assertSame[foo2[d, _2], _4]

}


object TypeConstraint6Tezt {

    trait B[R] {
        type inc[n <: Peano] <: R
    }

    trait d extends B[Peano] {
        override type inc[n <: Peano] = n#increment
    }

    // OK
    type foo1[b <: B[Peano], n <: Peano] = b#inc[n]
    assertSame[foo1[d, _2]#increment, _4]

    // NO
    trait Base {
        type foo2[b <: B[Peano], n <: Peano] <: Peano
    }
    trait Derived extends Base {
        override type foo2[b <: B[Peano], n <: Peano] = b#inc[n]#increment
    }
    type callfoo2[x <: Base, b <: B[Peano], n <: Peano] = x#foo2[b, n]
    //assertSame[callfoo2[Derived, d, _2], _4]

}
