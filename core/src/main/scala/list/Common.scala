

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


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
    def fromSTuple[T1](from: scala.Tuple1[T1])(implicit _T1: BoxKind[T1]): Box[T1, _T1.self] :: Nil = Box(from._1)(_T1) :: Nil
    def fromSTuple[T1, T2](from: scala.Tuple2[T1, T2])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Nil
    def fromSTuple[T1, T2, T3](from: scala.Tuple3[T1, T2, T3])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Box[T3, _T3.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Box(from._3)(_T3) :: Nil
    def fromSTuple[T1, T2, T3, T4](from: scala.Tuple4[T1, T2, T3, T4])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3], _T4: BoxKind[T4]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Box[T3, _T3.self] :: Box[T4, _T4.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Box(from._3)(_T3) :: Box(from._4)(_T4) :: Nil
    def fromSTuple[T1, T2, T3, T4, T5](from: scala.Tuple5[T1, T2, T3, T4, T5])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3], _T4: BoxKind[T4], _T5: BoxKind[T5]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Box[T3, _T3.self] :: Box[T4, _T4.self] :: Box[T5, _T5.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Box(from._3)(_T3) :: Box(from._4)(_T4) :: Box(from._5)(_T5) :: Nil

    def fromSTuple1[T1](from: scala.Tuple1[T1])(implicit _T1: BoxKind[T1]): Box[T1, _T1.self] :: Nil = Box(from._1)(_T1) :: Nil
    def fromSTuple2[T1, T2](from: scala.Tuple2[T1, T2])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Nil
    def fromSTuple3[T1, T2, T3](from: scala.Tuple3[T1, T2, T3])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Box[T3, _T3.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Box(from._3)(_T3) :: Nil
    def fromSTuple4[T1, T2, T3, T4](from: scala.Tuple4[T1, T2, T3, T4])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3], _T4: BoxKind[T4]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Box[T3, _T3.self] :: Box[T4, _T4.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Box(from._3)(_T3) :: Box(from._4)(_T4) :: Nil
    def fromSTuple5[T1, T2, T3, T4, T5](from: scala.Tuple5[T1, T2, T3, T4, T5])(implicit _T1: BoxKind[T1], _T2: BoxKind[T2], _T3: BoxKind[T3], _T4: BoxKind[T4], _T5: BoxKind[T5]): Box[T1, _T1.self] :: Box[T2, _T2.self] :: Box[T3, _T3.self] :: Box[T4, _T4.self] :: Box[T5, _T5.self] :: Nil = Box(from._1)(_T1) :: Box(from._2)(_T2) :: Box(from._3)(_T3) :: Box(from._4)(_T4) :: Box(from._5)(_T5) :: Nil

}





















