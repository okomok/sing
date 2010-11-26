

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


trait AbstractList extends List {
    final override  def asList: asList = self
    final override type asList         = self

    final override  def unsing: unsing = if (isEmpty.unsing) scala.collection.immutable.Nil else (head.unsing :: tail.unsing.toList)
    final override type unsing         = scala.collection.immutable.List[scala.Any]

    final override  def ::[x <: Any](x: x): ::[x] = Cons(x, self)
    final override type ::[x <: Any]              = Cons[x, self]

    final override  def clear: clear = Nil
    final override type clear        = Nil

    final override  def foreach[f <: Function1](f: f): foreach[f] = Foreach.apply(self, f)
    final override type foreach[f <: Function1]                   = Foreach.apply[self, f]

    final override lazy val length: length = Length.apply(self)
    final override     type length         = Length.apply[self]

    final override  def append[that <: List](that: that): append[that] = Append.apply(self, that)
    final override type append[that <: List]                           = Append.apply[self, that]

    final override  def map[f <: Function1](f: f): map[f] = Map.apply(self, f)
    final override type map[f <: Function1]               = Map.apply[self, f]

    final override  def flatMap[f <: Function1](f: f): flatMap[f] = map(f).flatten
    final override type flatMap[f <: Function1]                   = map[f]#flatten

    final override  def flatten: flatten = Flatten.apply(self)
    final override type flatten          = Flatten.apply[self]

    final override  def filter[f <: Function1](f: f): filter[f] = Filter.apply(self, f)
    final override type filter[f <: Function1]                  = Filter.apply[self, f]

    final override  def partition[f <: Function1](f: f): partition[f] = Tuple2(filter(f), filter(f.not))
    final override type partition[f <: Function1]                     = Tuple2[filter[f], filter[f#not]]

    final override  def sort: sort = Sort.apply(self, None)
    final override type sort       = Sort.apply[self, None]

    final override  def sortWith[o <: Ordering](o: o): sortWith[o] = Sort.apply(self, Some(o))
    final override type sortWith[o <: Ordering]                    = Sort.apply[self, Some[o]]

    final override  def isSorted: isSorted = IsSorted.apply(self, None)
    final override type isSorted           = IsSorted.apply[self, None]

    final override  def isSortedWith[o <: Ordering](o: o): isSortedWith[o] = IsSorted.apply(self, Some(o))
    final override type isSortedWith[o <: Ordering]                        = IsSorted.apply[self, Some[o]]

    final override  def forall[f <: Function1](f: f): forall[f] = exists(f.not).not.asInstanceOf[forall[f]]
    final override type forall[f <: Function1]                  = exists[f#not]#not

    final override  def exists[f <: Function1](f: f): exists[f] = find(f).isEmpty.not
    final override type exists[f <: Function1]                  = find[f]#isEmpty#not

    final override  def count[f <: Function1](f: f): count[f] = filter(f).length
    final override type count[f <: Function1]                 = filter[f]#length

    final override  def find[f <: Function1](f: f): find[f] = Find.apply(self, f)
    final override type find[f <: Function1]                = Find.apply[self, f]

    final override  def foldLeft[z <: Any, f <: Function2](z: z, f: f): foldLeft[z, f] = FoldLeft.apply(self, z, f)
    final override type foldLeft[z <: Any, f <: Function2]                             = FoldLeft.apply[self, z, f]

    final override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = FoldRight.apply(self, z, f)
    final override type foldRight[z <: Any, f <: Function2]                              = FoldRight.apply[self, z, f]

    final override  def reduceLeft[f <: Function2](f: f): reduceLeft[f] = tail.foldLeft(head, f)
    final override type reduceLeft[f <: Function2]                      = tail#foldLeft[head, f]

    final override  def reduceRight[f <: Function2](f: f): reduceRight[f] = tail.foldRight(head, f)
    final override type reduceRight[f <: Function2]                       = tail#foldRight[head, f]

    final override  def scanLeft[z <: Any, f <: Function2](z: z, f: f): scanLeft[z, f] = ScanLeft.apply(self, z, f)
    final override type scanLeft[z <: Any, f <: Function2]                             = ScanLeft.apply[self, z, f]

    final override  def scanRight[z <: Any, f <: Function2](z: z, f: f): scanRight[z, f] = ScanRight.apply(self, z, f)
    final override type scanRight[z <: Any, f <: Function2]                              = ScanRight.apply[self, z, f]

    final override  def nth[n <: Nat](n: n): nth[n] = Nth.apply(self, n)
    final override type nth[n <: Nat]               = Nth.apply[self, n]

    final override  def last: last = Last.apply(self)
    final override type last       = Last.apply[self]

    final override  def init: init = Init.apply(self)
    final override type init       = Init.apply[self]

    final override  def take[n <: Nat](n: n): take[n] = Take.apply(self, n)
    final override type take[n <: Nat]                = Take.apply[self, n]

    final override  def drop[n <: Nat](n: n): drop[n] = Drop.apply(self, n)
    final override type drop[n <: Nat]                = Drop.apply[self, n]

    final override  def slice[n <: Nat, m <: Nat](n: n, m: m): slice[n, m] = take(m).drop(n)
    final override type slice[n <: Nat, m <: Nat]                          = take[m]#drop[n]

    final override  def takeWhile[f <: Function1](f: f): takeWhile[f] = TakeWhile.apply(self, f)
    final override type takeWhile[f <: Function1]                     = TakeWhile.apply[self, f]

    final override  def dropWhile[f <: Function1](f: f): dropWhile[f] = DropWhile.apply(self, f)
    final override type dropWhile[f <: Function1]                     = DropWhile.apply[self, f]

    final override  def span[f <: Function1](f: f): span[f] = Tuple2(takeWhile(f), dropWhile(f))
    final override type span[f <: Function1]                = Tuple2[takeWhile[f], dropWhile[f]]

    final override  def splitAt[n <: Nat](n: n): splitAt[n] = Tuple2(take(n), drop(n))
    final override type splitAt[n <: Nat]                   = Tuple2[take[n], drop[n]]

    final override  def equal[that <: List](that: that): equal[that] = Equal.apply(self, that, None)
    final override type equal[that <: List]                          = Equal.apply[self, that, None]

    final override  def equalWith[that <: List, e <: Equiv](that: that, e: e): equalWith[that, e] = Equal.apply(self, that, Some(e))
    final override type equalWith[that <: List, e <: Equiv]                                       = Equal.apply[self, that, Some[e]]

    final override  def reverse: reverse = ReverseAppend.apply(self, Nil)
    final override type reverse          = ReverseAppend.apply[self, Nil]

    final override  def zip[that <: List](that: that): zip[that] = Zip.apply(self, that)
    final override type zip[that <: List]                        = Zip.apply[self, that]

    final override  def zipBy[that <: List, f <: Function2](that: that, f: f): zipBy[that, f] = ZipBy.apply(self, that, f)
    final override type zipBy[that <: List, f <: Function2]                                   = ZipBy.apply[self, that, f]

    final override  def unzip: unzip = Unzip.apply(self)
    final override type unzip        = Unzip.apply[self]

    final override  def force: force = Force.apply(self)
    final override type force        = Force.apply[self]

    final override  def step[n <: Nat](n: n): step[n] = Step.apply(self, n)
    final override type step[n <: Nat]                = Step.apply[self, n]

    final override  def times[n <: Nat](n: n): times[n] = Times.apply(self, n)
    final override type times[n <: Nat]                 = Times.apply[self, n]

    final override  def naturalOrdering: naturalOrdering = list.naturalOrdering
    final override type naturalOrdering                  = list.naturalOrdering

    override  def canEqual(that: scala.Any) = that.isInstanceOf[List]
}
