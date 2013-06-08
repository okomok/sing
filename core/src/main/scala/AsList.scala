

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import list._


trait AsList extends List with AsAny with UnsingEquals with AsListKind {
    override  def asList: asList = self
    override type asList         = self

    override  def unsing: unsing = if (isEmpty.unsing) scala.collection.immutable.Nil else (head.unsing :: tail.unsing.toList)
    override type unsing         = scala.collection.immutable.List[scala.Any]

    override  def ::[x <: Any](x: x): ::[x] = Cons(x, self)
    override type ::[x <: Any]              = Cons[x, self]

    override  def clear: clear = Nil
    override type clear        = Nil

    override  def foreach[f <: Function1](f: f): foreach[f] = Foreach.apply(self, f)
    override type foreach[f <: Function1]                   = Foreach.apply[self, f]

    @Annotation.compilerWorkaround("2.9.0") // crashes in `override lazy val`.
    private[this] lazy val _length: length = Length.apply(self)
    override  def length: length = _length
    override type length         = Length.apply[self]

    override  def append[that <: List](that: that): append[that] = Append.apply(self, that)
    override type append[that <: List]                           = Append.apply[self, that]

    override  def map[f <: Function1](f: f): map[f] = list.Map.apply(self, f)
    override type map[f <: Function1]               = list.Map.apply[self, f]

    override  def flatMap[f <: Function1](f: f): flatMap[f] = map(f).flatten
    override type flatMap[f <: Function1]                   = map[f]#flatten

    override  def flatten: flatten = Flatten.apply(self)
    override type flatten          = Flatten.apply[self]

    override  def filter[f <: Function1](f: f): filter[f] = Filter.apply(self, f)
    override type filter[f <: Function1]                  = Filter.apply[self, f]

    override  def partition[f <: Function1](f: f): partition[f] = Tuple2(filter(f), filter(f.not))
    override type partition[f <: Function1]                     = Tuple2[filter[f], filter[f#not]]

    override  def sort: sort = Sort.apply(self, None)
    override type sort       = Sort.apply[self, None]

    override  def sortWith[o <: Ordering](o: o): sortWith[o] = Sort.apply(self, Some(o))
    override type sortWith[o <: Ordering]                    = Sort.apply[self, Some[o]]

    override  def isSorted: isSorted = IsSorted.apply(self, None)
    override type isSorted           = IsSorted.apply[self, None]

    override  def isSortedWith[o <: Ordering](o: o): isSortedWith[o] = IsSorted.apply(self, Some(o))
    override type isSortedWith[o <: Ordering]                        = IsSorted.apply[self, Some[o]]

    override  def forall[f <: Function1](f: f): forall[f] = exists(f.not).not.asInstanceOf[forall[f]]
    override type forall[f <: Function1]                  = exists[f#not]#not

    override  def exists[f <: Function1](f: f): exists[f] = find(f).isEmpty.not
    override type exists[f <: Function1]                  = find[f]#isEmpty#not

    override  def count[f <: Function1](f: f): count[f] = filter(f).length
    override type count[f <: Function1]                 = filter[f]#length

    override  def find[f <: Function1](f: f): find[f] = Find.apply(self, f)
    override type find[f <: Function1]                = Find.apply[self, f]

    override  def foldLeft[z <: Any, f <: Function2](z: z, f: f): foldLeft[z, f] = FoldLeft.apply(self, z, f)
    override type foldLeft[z <: Any, f <: Function2]                             = FoldLeft.apply[self, z, f]

    override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = FoldRight.apply(self, z, f)
    override type foldRight[z <: Any, f <: Function2]                              = FoldRight.apply[self, z, f]

    override  def reduceLeft[f <: Function2](f: f): reduceLeft[f] = tail.foldLeft(head, f)
    override type reduceLeft[f <: Function2]                      = tail#foldLeft[head, f]

    override  def reduceRight[f <: Function2](f: f): reduceRight[f] = tail.foldRight(head, f)
    override type reduceRight[f <: Function2]                       = tail#foldRight[head, f]

    override  def scanLeft[z <: Any, f <: Function2](z: z, f: f): scanLeft[z, f] = ScanLeft.apply(self, z, f)
    override type scanLeft[z <: Any, f <: Function2]                             = ScanLeft.apply[self, z, f]

    override  def scanRight[z <: Any, f <: Function2](z: z, f: f): scanRight[z, f] = ScanRight.apply(self, z, f)
    override type scanRight[z <: Any, f <: Function2]                              = ScanRight.apply[self, z, f]

    override  def nth[n <: Nat](n: n): nth[n] = Nth.apply(self, n)
    override type nth[n <: Nat]               = Nth.apply[self, n]

    override  def last: last = Last.apply(self)
    override type last       = Last.apply[self]

    override  def init: init = Init.apply(self)
    override type init       = Init.apply[self]

    override  def take[n <: Nat](n: n): take[n] = Take.apply(self, n)
    override type take[n <: Nat]                = Take.apply[self, n]

    override  def drop[n <: Nat](n: n): drop[n] = Drop.apply(self, n)
    override type drop[n <: Nat]                = Drop.apply[self, n]

    override  def slice[n <: Nat, m <: Nat](n: n, m: m): slice[n, m] = take(m).drop(n)
    override type slice[n <: Nat, m <: Nat]                          = take[m]#drop[n]

    override  def takeWhile[f <: Function1](f: f): takeWhile[f] = TakeWhile.apply(self, f)
    override type takeWhile[f <: Function1]                     = TakeWhile.apply[self, f]

    override  def dropWhile[f <: Function1](f: f): dropWhile[f] = DropWhile.apply(self, f)
    override type dropWhile[f <: Function1]                     = DropWhile.apply[self, f]

    override  def span[f <: Function1](f: f): span[f] = Tuple2(takeWhile(f), dropWhile(f))
    override type span[f <: Function1]                = Tuple2[takeWhile[f], dropWhile[f]]

    override  def splitAt[n <: Nat](n: n): splitAt[n] = Tuple2(take(n), drop(n))
    override type splitAt[n <: Nat]                   = Tuple2[take[n], drop[n]]

    override  def equal[that <: List](that: that): equal[that] = Equal.apply(self, that, None)
    override type equal[that <: List]                          = Equal.apply[self, that, None]

    override  def equalWith[that <: List, e <: Equiv](that: that, e: e): equalWith[that, e] = Equal.apply(self, that, Some(e))
    override type equalWith[that <: List, e <: Equiv]                                       = Equal.apply[self, that, Some[e]]

    override  def reverse: reverse = ReverseAppend.apply(self, Nil)
    override type reverse          = ReverseAppend.apply[self, Nil]

    override  def zip[that <: List](that: that): zip[that] = Zip.apply(self, that)
    override type zip[that <: List]                        = Zip.apply[self, that]

    override  def zipBy[that <: List, f <: Function2](that: that, f: f): zipBy[that, f] = ZipBy.apply(self, that, f)
    override type zipBy[that <: List, f <: Function2]                                   = ZipBy.apply[self, that, f]

    override  def unzip: unzip = Unzip.apply(self)
    override type unzip        = Unzip.apply[self]

    override  def force: force = Force.apply(self)
    override type force        = Force.apply[self]

    override  def step[n <: Nat](n: n): step[n] = Step.apply(self, n)
    override type step[n <: Nat]                = Step.apply[self, n]

    override  def times[n <: Nat](n: n): times[n] = Times.apply(self, n)
    override type times[n <: Nat]                 = Times.apply[self, n]

    override  def canEqual(that: scala.Any) = that.isInstanceOf[List]
}
