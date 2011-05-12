

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


trait Forwarder extends List with sing.Forwarder {
    override protected type delegate <: List

    protected  def around[that <: List](that: that): around[that]
    protected type around[that <: List] <: List

    final private[this]  def around2[that <: Product2](that: that): around2[that] =
        Tuple2(around(that._1.asList), around(that._2.asList))
    final private[this] type around2[that <: Product2] =
        Tuple2[around[that#_1#asList], around[that#_2#asList]]

    final override  def isEmpty: isEmpty = delegate.isEmpty
    final override type isEmpty          = delegate#isEmpty

    final override  def head: head = delegate.head
    final override type head       = delegate#head

    final override  def tail: tail = around(delegate.tail)
    final override type tail       = around[delegate#tail]

    final override  def ::[e <: Any](e: e): ::[e] = around(delegate. ::(e))
    final override type ::[e <: Any]              = around[delegate# ::[e]]

    final override  def clear: clear = around(delegate.clear)
    final override type clear        = around[delegate#clear]

    final override  def foreach[f <: Function1](f: f): foreach[f] = delegate.foreach(f)
    final override type foreach[f <: Function1]                   = delegate#foreach[f]

    final override  def length: length = delegate.length
    final override type length         = delegate#length

    final override  def append[that <: List](that: that): append[that] = around(delegate.append(that))
    final override type append[that <: List]                           = around[delegate#append[that]]

    final override  def map[f <: Function1](f: f): map[f] = around(delegate.map(f))
    final override type map[f <: Function1]               = around[delegate#map[f]]

    final override  def flatMap[f <: Function1](f: f): flatMap[f] = around(delegate.flatMap(f))
    final override type flatMap[f <: Function1]                   = around[delegate#flatMap[f]]

    final override  def flatten: flatten = around(delegate.flatten)
    final override type flatten          = around[delegate#flatten]

    final override  def filter[f <: Function1](f: f): filter[f] = around(delegate.filter(f))
    final override type filter[f <: Function1]                  = around[delegate#filter[f]]

    final override  def partition[f <: Function1](f: f): partition[f] = around2(delegate.partition(f))
    final override type partition[f <: Function1]                     = around2[delegate#partition[f]]

    final override  def sort: sort = around(delegate.sort)
    final override type sort       = around[delegate#sort]

    final override  def sortWith[o <: Ordering](o: o): sortWith[o] = around(delegate.sortWith(o))
    final override type sortWith[o <: Ordering]                    = around[delegate#sortWith[o]]

    final override  def isSorted: isSorted = delegate.isSorted
    final override type isSorted           = delegate#isSorted

    final override  def isSortedWith[o <: Ordering](o: o): isSortedWith[o] = delegate.isSortedWith(o)
    final override type isSortedWith[o <: Ordering]                        = delegate#isSortedWith[o]

    final override  def forall[f <: Function1](f: f): forall[f] = delegate.forall(f)
    final override type forall[f <: Function1]                  = delegate#forall[f]

    final override  def exists[f <: Function1](f: f): exists[f] = delegate.exists(f)
    final override type exists[f <: Function1]                  = delegate#exists[f]

    final override  def count[f <: Function1](f: f): count[f] = delegate.count(f)
    final override type count[f <: Function1]                 = delegate#count[f]

    final override  def find[f <: Function1](f: f): find[f] = delegate.find(f)
    final override type find[f <: Function1]                = delegate#find[f]

    final override  def foldLeft[z <: Any, f <: Function2](z: z, f: f): foldLeft[z, f] = delegate.foldLeft(z, f)
    final override type foldLeft[z <: Any, f <: Function2]                             = delegate#foldLeft[z, f]

    final override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = delegate.foldRight(z, f)
    final override type foldRight[z <: Any, f <: Function2]                              = delegate#foldRight[z, f]

    final override  def reduceLeft[f <: Function2](f: f): reduceLeft[f] = delegate.reduceLeft(f)
    final override type reduceLeft[f <: Function2]                      = delegate#reduceLeft[f]

    final override  def reduceRight[f <: Function2](f: f): reduceRight[f] = delegate.reduceRight(f)
    final override type reduceRight[f <: Function2]                       = delegate#reduceRight[f]

    final override  def scanLeft[z <: Any, f <: Function2](z: z, f: f): scanLeft[z, f] = around(delegate.scanLeft(z, f))
    final override type scanLeft[z <: Any, f <: Function2]                             = around[delegate#scanLeft[z, f]]

    final override  def scanRight[z <: Any, f <: Function2](z: z, f: f): scanRight[z, f] = around(delegate.scanRight(z, f))
    final override type scanRight[z <: Any, f <: Function2]                              = around[delegate#scanRight[z, f]]

    final override  def nth[n <: Nat](n: n): nth[n] = delegate.nth(n)
    final override type nth[n <: Nat]               = delegate#nth[n]

    final override  def last: last = delegate.last
    final override type last       = delegate#last

    final override  def init: init = around(delegate.init)
    final override type init       = around[delegate#init]

    final override  def take[n <: Nat](n: n): take[n] = around(delegate.take(n))
    final override type take[n <: Nat]                = around[delegate#take[n]]

    final override  def drop[n <: Nat](n: n): drop[n] = around(delegate.drop(n))
    final override type drop[n <: Nat]                = around[delegate#drop[n]]

    final override  def slice[n <: Nat, m <: Nat](n: n, m: m): slice[n, m] = around(delegate.slice(n, m))
    final override type slice[n <: Nat, m <: Nat]                          = around[delegate#slice[n, m]]

    final override  def takeWhile[f <: Function1](f: f): takeWhile[f] = around(delegate.takeWhile(f))
    final override type takeWhile[f <: Function1]                     = around[delegate#takeWhile[f]]

    final override  def dropWhile[f <: Function1](f: f): dropWhile[f] = around(delegate.dropWhile(f))
    final override type dropWhile[f <: Function1]                     = around[delegate#dropWhile[f]]

    final override  def span[f <: Function1](f: f): span[f] = around2(delegate.span(f))
    final override type span[f <: Function1]                = around2[delegate#span[f]]

    final override  def splitAt[n <: Nat](n: n): splitAt[n] = around2(delegate.splitAt(n))
    final override type splitAt[n <: Nat]                   = around2[delegate#splitAt[n]]

    final override  def equal[that <: List](that: that): equal[that] = delegate.equal(that)
    final override type equal[that <: List]                          = delegate#equal[that]

    final override  def equalWith[that <: List, e <: Equiv](that: that, e: e): equalWith[that, e] = delegate.equalWith(that, e)
    final override type equalWith[that <: List, e <: Equiv]                                       = delegate#equalWith[that, e]

    final override  def reverse: reverse = around(delegate.reverse)
    final override type reverse          = around[delegate#reverse]

    final override  def zip[that <: List](that: that): zip[that] = around(delegate.zip(that))
    final override type zip[that <: List]                        = around[delegate#zip[that]]

    final override  def unzip: unzip = around2(delegate.unzip)
    final override type unzip        = around2[delegate#unzip]

    final override  def force: force = around(delegate.force)
    final override type force        = around[delegate#force]

    final override  def step[n <: Nat](n: n): step[n] = around(delegate.step(n))
    final override type step[n <: Nat]                = around[delegate#step[n]]

    final override  def times[n <: Nat](n: n): times[n] = around(delegate.times(n))
    final override type times[n <: Nat]                 = around[delegate#times[n]]
}


trait TrivialForwarder extends Forwarder {
    final override protected  def around[that <: List](that: that): around[that] = that
    final override protected type around[that <: List]                           = that
}

