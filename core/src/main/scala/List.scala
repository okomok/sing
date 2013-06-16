

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object List extends AsKind with _list.ToSTuple {
    import _list._

    override  def kindId: kindId = KindId.ofList
    override type kindId         = KindId.ofList

    // `lazy` because `None` is initialized later in `package sing`.
    override lazy val naturalOrdering: naturalOrdering = LexicographicalOrdering.apply(None)
    override     type naturalOrdering                  = LexicographicalOrdering.apply[None]

    @Annotation.equivalentTo("Nil")
     val empty: empty = Nil
    type empty        = Nil

    @Annotation.equivalentTo("Nil.::(x)")
     def single[x <: Any](x: x): single[x] = Nil. ::(x)
    type single[x <: Any]                  = Nil# ::[x]

     def range[n <: Nat, m <: Nat](n: n, m: m): range[n, m] = Range.apply(n, m)
    type range[n <: Nat, m <: Nat]                          = Range.apply[n, m]

     def rangeFrom[n <: Nat](n: n): rangeFrom[n] = RangeFrom.apply(n)
    type rangeFrom[n <: Nat]                     = RangeFrom.apply[n]

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
    def fromSTuple[T1](from: scala.Tuple1[T1])(implicit _T1: Boxer[T1]): _T1.box :: Nil = _T1.box(from._1) :: Nil
    def fromSTuple[T1, T2](from: scala.Tuple2[T1, T2])(implicit _T1: Boxer[T1], _T2: Boxer[T2]): _T1.box :: _T2.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: Nil
    def fromSTuple[T1, T2, T3](from: scala.Tuple3[T1, T2, T3])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3]): _T1.box :: _T2.box :: _T3.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: _T3.box(from._3) :: Nil
    def fromSTuple[T1, T2, T3, T4](from: scala.Tuple4[T1, T2, T3, T4])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3], _T4: Boxer[T4]): _T1.box :: _T2.box :: _T3.box :: _T4.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: _T3.box(from._3) :: _T4.box(from._4) :: Nil
    def fromSTuple[T1, T2, T3, T4, T5](from: scala.Tuple5[T1, T2, T3, T4, T5])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3], _T4: Boxer[T4], _T5: Boxer[T5]): _T1.box :: _T2.box :: _T3.box :: _T4.box :: _T5.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: _T3.box(from._3) :: _T4.box(from._4) :: _T5.box(from._5) :: Nil

    def fromSTuple1[T1](from: scala.Tuple1[T1])(implicit _T1: Boxer[T1]): _T1.box :: Nil = _T1.box(from._1) :: Nil
    def fromSTuple2[T1, T2](from: scala.Tuple2[T1, T2])(implicit _T1: Boxer[T1], _T2: Boxer[T2]): _T1.box :: _T2.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: Nil
    def fromSTuple3[T1, T2, T3](from: scala.Tuple3[T1, T2, T3])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3]): _T1.box :: _T2.box :: _T3.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: _T3.box(from._3) :: Nil
    def fromSTuple4[T1, T2, T3, T4](from: scala.Tuple4[T1, T2, T3, T4])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3], _T4: Boxer[T4]): _T1.box :: _T2.box :: _T3.box :: _T4.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: _T3.box(from._3) :: _T4.box(from._4) :: Nil
    def fromSTuple5[T1, T2, T3, T4, T5](from: scala.Tuple5[T1, T2, T3, T4, T5])(implicit _T1: Boxer[T1], _T2: Boxer[T2], _T3: Boxer[T3], _T4: Boxer[T4], _T5: Boxer[T5]): _T1.box :: _T2.box :: _T3.box :: _T4.box :: _T5.box :: Nil = _T1.box(from._1) :: _T2.box(from._2) :: _T3.box(from._3) :: _T4.box(from._4) :: _T5.box(from._5) :: Nil
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

     def #::[A](x: A)(implicit _A: Boxer[A]): ::[_A.box] = ::(_A.box(x))

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

     def caseNil[ifNil <: Function0, _else <: Function2](ifNil: ifNil, _else: _else): caseNil[ifNil, _else]
    type caseNil[ifNil <: Function0, _else <: Function2] <: Function0
}


trait AsList extends ListImpl {
    override  def kind: kind = List
    override type kind       = List.type
}


trait ListImpl extends List with AnyImpl with UnsingEquals {
    import _list._

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

    override  def map[f <: Function1](f: f): map[f] = _list.Map.apply(self, f)
    override type map[f <: Function1]               = _list.Map.apply[self, f]

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

    override  def forall[f <: Function1](f: f): forall[f] = exists(id(f).not).not
    override type forall[f <: Function1]                  = exists[id[f]#not]#not

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

    override  def equal[that <: Any](that: that): equal[that] = Equal.apply(self, that.asList, None)
    override type equal[that <: Any]                          = Equal.apply[self, that#asList, None]

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

    override  def caseNil[ifNil <: Function0, _else <: Function2](ifNil: ifNil, _else: _else): caseNil[ifNil, _else] = CaseNil.apply(self, ifNil, _else)
    override type caseNil[ifNil <: Function0, _else <: Function2]                                                    = CaseNil.apply[self, ifNil, _else]

    override def canEqual(that: scala.Any) = that.isInstanceOf[List]
}
