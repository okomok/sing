

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


object List extends Common with ToSTuple


/**
* The sing List
*/
trait List extends Any {
    type self <: List
    type unsing <: scala.collection.immutable.Seq[scala.Any]

    @annotation.constantTime
     def isEmpty: isEmpty
    type isEmpty <: Boolean

    @annotation.constantTime
     def head: head
    type head <: Any

    @annotation.constantTime
     def tail: tail
    type tail <: List

     def ::[e <: Any](e: e): ::[e]
    type ::[e <: Any] <: List
    final def #::[e](e: e): ::[Box[e]] = ::(Box(e))
//    final def ::[e](e: e, o: util.Overload = ()): ::[Box[e]] = ::(Box(e))

    @annotation.constantTime
     def clear: clear
    type clear <: List

     def foreach[f <: Function1](f: f): foreach[f]
    type foreach[f <: Function1] <: Unit

    @annotation.linearTime
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

    @annotation.linearTime
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

     def equal[that <: List](that: that): equal[that]
    type equal[that <: List] <: Boolean

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
