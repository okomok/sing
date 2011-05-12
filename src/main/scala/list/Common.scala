

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[list]
trait Common {

    @annotation.equivalentTo("new Nil{}")
     val Nil = _Nil.value

    @annotation.equivalentTo("Cons")
     val :: = Cons
    @annotation.equivalentTo("x# ::[xs]")
    type ::[x <: Any, xs <: List] = xs# ::[x]

    @annotation.equivalentTo("Nil")
     val empty: empty = Nil
    type empty        = Nil

    @annotation.equivalentTo("Nil.::(x)")
     def single[x <: Any](x: x): single[x] = Nil. ::(x)
    type single[x <: Any]                  = Nil# ::[x]
//     def single[x](x: x, o: util.Overload = ()): single[Box[x]] = single(Box(x)) // scalac sucks.

     def range[n <: Nat, m <: Nat](n: n, m: m): range[n, m] = Range.apply(n, m)
    type range[n <: Nat, m <: Nat]                          = Range.apply[n, m]

     def iterate[z <: Any, f <: Function1](z: z, f: f): iterate[z, f] = Iterate.apply(z, f)
    type iterate[z <: Any, f <: Function1]                            = Iterate.apply[z, f]

     def unfoldRight[z <: Any, f <: Function1](z: z, f: f): unfoldRight[z, f] = UnfoldRight.apply(z, f)
    type unfoldRight[z <: Any, f <: Function1]                                = UnfoldRight.apply[z, f]

     def repeat[z <: Any](z: z): repeat[z] = iterate(z, function.identity)
    type repeat[z <: Any]                  = iterate[z, function.identity]

    /**
     * Forces tuple elements.
     */
     def force2[t <: Product2](t: t): force2[t] = Tuple2(t._1.asList.force, t._2.asList.force)
    type force2[t <: Product2]                  = Tuple2[t#_1#asList#force, t#_2#asList#force]

    /**
     * Makes a lexicographical Ordering from element natural ordering.
     */
    // `lazy` because `None` is initialized later in `package sing`.
    lazy val naturalOrdering: naturalOrdering = LexicographicalOrdering.apply(None)
        type naturalOrdering                  = LexicographicalOrdering.apply[None]

    /**
     * Makes a lexicographical Ordering from element Ordering.
     */
     def lexicographicalOrdering[eo <: Ordering](eo: eo): lexicographicalOrdering[eo] = LexicographicalOrdering.apply(Some(eo))
    type lexicographicalOrdering[eo <: Ordering]                                      = LexicographicalOrdering.apply[Some[eo]]

    /**
     * Lifts `scala.TupleN` to sing one.
     */
    def fromSTuple[T1](from: scala.Tuple1[T1]): Box[T1] :: Nil = fromSTuple1(from)
    def fromSTuple[T1, T2](from: scala.Tuple2[T1, T2]): Box[T1] :: Box[T2] :: Nil = fromSTuple2(from)
    def fromSTuple[T1, T2, T3](from: scala.Tuple3[T1, T2, T3]): Box[T1] :: Box[T2] :: Box[T3] :: Nil = fromSTuple3(from)
    def fromSTuple[T1, T2, T3, T4](from: scala.Tuple4[T1, T2, T3, T4]): Box[T1] :: Box[T2] :: Box[T3] :: Box[T4] :: Nil = fromSTuple4(from)
    def fromSTuple[T1, T2, T3, T4, T5](from: scala.Tuple5[T1, T2, T3, T4, T5]): Box[T1] :: Box[T2] :: Box[T3] :: Box[T4] :: Box[T5] :: Nil = fromSTuple5(from)
    def fromSTuple1[T1](from: scala.Tuple1[T1]): Box[T1] :: Nil = Box(from._1) :: Nil
    def fromSTuple2[T1, T2](from: scala.Tuple2[T1, T2]): Box[T1] :: Box[T2] :: Nil = Box(from._1) :: Box(from._2) :: Nil
    def fromSTuple3[T1, T2, T3](from: scala.Tuple3[T1, T2, T3]): Box[T1] :: Box[T2] :: Box[T3] :: Nil = Box(from._1) :: Box(from._2) :: Box(from._3) :: Nil
    def fromSTuple4[T1, T2, T3, T4](from: scala.Tuple4[T1, T2, T3, T4]): Box[T1] :: Box[T2] :: Box[T3] :: Box[T4] :: Nil = Box(from._1) :: Box(from._2) :: Box(from._3) :: Box(from._4) :: Nil
    def fromSTuple5[T1, T2, T3, T4, T5](from: scala.Tuple5[T1, T2, T3, T4, T5]): Box[T1] :: Box[T2] :: Box[T3] :: Box[T4] :: Box[T5] :: Nil = Box(from._1) :: Box(from._2) :: Box(from._3) :: Box(from._4) :: Box(from._5) :: Nil

}
