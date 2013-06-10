

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import list._


object List extends ToSTuple with AsListKind {

    @Annotation.equivalentTo("Nil")
     val empty: empty = Nil
    type empty        = Nil

    @Annotation.equivalentTo("Nil.::(x)")
     def single[x <: Any](x: x): single[x] = Nil. ::(x)
    type single[x <: Any]                  = Nil# ::[x]

     def range[n <: Nat, m <: Nat](n: n, m: m): range[n, m] = Range.apply(n, m)
    type range[n <: Nat, m <: Nat]                          = Range.apply[n, m]

     def iterate[z <: Any, f <: Function1](z: z, f: f): iterate[z, f] = Iterate.apply(z, f)
    type iterate[z <: Any, f <: Function1]                            = Iterate.apply[z, f]

     def unfoldRight[z <: Any, f <: Function1](z: z, f: f): unfoldRight[z, f] = UnfoldRight.apply(z, f)
    type unfoldRight[z <: Any, f <: Function1]                                = UnfoldRight.apply[z, f]

     def repeat[z <: Any](z: z): repeat[z] = iterate(z, Identity)
    type repeat[z <: Any]                  = iterate[z, Identity]

    /**
     * Forces tuple elements.
     */
     def force2[t <: Product2](t: t): force2[t] = Tuple2(t._1.asList.force, t._2.asList.force)
    type force2[t <: Product2]                  = Tuple2[t#_1#asList#force, t#_2#asList#force]

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


/**
* The sing List
*/
trait List extends Any {
    override type self <: List
    override type unsing <: scala.collection.immutable.Seq[scala.Any]

    @Annotation.constantTime
     def isEmpty: isEmpty
    type isEmpty <: Boolean

    @Annotation.constantTime
     def head: head
    type head <: Any

    @Annotation.constantTime
     def tail: tail
    type tail <: List

     def ::[e <: Any](e: e): ::[e]
    type ::[e <: Any] <: List

     def #::[A](x: A)(implicit _A: BoxKind[A]): ::[Box[A, _A.self]] = ::(Box(x)(_A))

    @Annotation.constantTime
     def clear: clear
    type clear <: List

     def foreach[f <: Function1](f: f): foreach[f]
    type foreach[f <: Function1] <: Unit

    @Annotation.linearTime
     def length: length
    type length <: Nat

     def append[that <: List](that: that): append[that]
    type append[that <: List] <: List

     def map[f <: Function1](f: f): map[f]
    type map[f <: Function1] <: List

     def flatMap[f <: Function1](f: f): flatMap[f]
    type flatMap[f <: Function1] <: List

     def flatten: flatten
    type flatten <: List

     def filter[f <: Function1](f: f): filter[f]
    type filter[f <: Function1] <: List

     def partition[f <: Function1](f: f): partition[f]
    type partition[f <: Function1] <: Product2

     def sort: sort
    type sort <: List

     def sortWith[o <: Ordering](o: o): sortWith[o]
    type sortWith[o <: Ordering] <: List

     def isSorted: isSorted
    type isSorted <: Boolean

     def isSortedWith[o <: Ordering](o: o): isSortedWith[o]
    type isSortedWith[o <: Ordering] <: Boolean

     def forall[f <: Function1](f: f): forall[f]
    type forall[f <: Function1] <: Boolean

     def exists[f <: Function1](f: f): exists[f]
    type exists[f <: Function1] <: Boolean

     def count[f <: Function1](f: f): count[f]
    type count[f <: Function1] <: Nat

     def find[f <: Function1](f: f): find[f]
    type find[f <: Function1] <: Option

     def foldLeft[z <: Any, f <: Function2](z: z, f: f): foldLeft[z, f]
    type foldLeft[z <: Any, f <: Function2] <: Any

     def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f]
    type foldRight[z <: Any, f <: Function2] <: Any

     def reduceLeft[f <: Function2](f: f): reduceLeft[f]
    type reduceLeft[f <: Function2] <: Any

     def reduceRight[f <: Function2](f: f): reduceRight[f]
    type reduceRight[f <: Function2] <: Any

     def scanLeft[z <: Any, f <: Function2](z: z, f: f): scanLeft[z, f]
    type scanLeft[z <: Any, f <: Function2] <: List

     def scanRight[z <: Any, f <: Function2](z: z, f: f): scanRight[z, f]
    type scanRight[z <: Any, f <: Function2] <: List

    @Annotation.linearTime
     def nth[n <: Nat](n: n): nth[n]
    type nth[n <: Nat] <: Any

     def last: last
    type last <: Any

     def init: init
    type init <: List

     def take[n <: Nat](n: n): take[n]
    type take[n <: Nat] <: List

     def drop[n <: Nat](n: n): drop[n]
    type drop[n <: Nat] <: List

     def slice[n <: Nat, m <: Nat](n: n, m: m): slice[n, m]
    type slice[n <: Nat, m <: Nat] <: List

     def takeWhile[f <: Function1](f: f): takeWhile[f]
    type takeWhile[f <: Function1] <: List

     def dropWhile[f <: Function1](f: f): dropWhile[f]
    type dropWhile[f <: Function1] <: List

     def span[f <: Function1](f: f): span[f]
    type span[f <: Function1] <: Product2

     def splitAt[n <: Nat](n: n): splitAt[n]
    type splitAt[n <: Nat] <: Product2

     def equalWith[that <: List, e <: Equiv](that: that, e: e): equalWith[that, e]
    type equalWith[that <: List, e <: Equiv] <: Boolean

     def reverse: reverse
    type reverse <: List

     def zip[that <: List](that: that): zip[that]
    type zip[that <: List] <: List

     def zipBy[that <: List, f <: Function2](that: that, f: f): zipBy[that, f]
    type zipBy[that <: List, f <: Function2] <: List

     def unzip: unzip
    type unzip <: Product2

     def force: force
    type force <: List

     def step[n <: Nat](n: n): step[n]
    type step[n <: Nat] <: List

     def times[n <: Nat](n: n): times[n]
    type times[n <: Nat] <: List
}
