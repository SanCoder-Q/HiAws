package com.thoughtworks.sancoder.scala.fp.episode2

import com.thoughtworks.sancoder.scala.fp.episode1._
import scala.math._

import scala.annotation.tailrec

//Created by SanCoder on 10/5/15.
trait Tree[+A] {
  def size = Tree.size(this)

  def countLeafs = Tree.countLeafs(this)

  def countBranches = Tree.countBranches(this)

  def depth = Tree.depth(this)
}

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](t: Tree[A]): Int = {
    @tailrec
    def go(tStack: List[Tree[A]], acc: Int): Int = tStack match {
      case Nil => acc
      case Cons(Leaf(_), t) => go(t, acc + 1)
      case Cons(Branch(l, r), t) => go(Cons(l, Cons(r, t)), acc + 1)
    }
    go(List(t), 0)
  }

  def countLeafs[A](t: Tree[A]): Int = {
    @tailrec
    def go(tStack: List[Tree[A]], acc: Int): Int = tStack match {
      case Nil => acc
      case Cons(Leaf(_), t) => go(t, acc + 1)
      case Cons(Branch(l, r), t) => go(Cons(l, Cons(r, t)), acc)
    }
    go(List(t), 0)
  }

  def countBranches[A](t: Tree[A]): Int = {
    @tailrec
    def go(tStack: List[Tree[A]], acc: Int): Int = tStack match {
      case Nil => acc
      case Cons(Leaf(_), tail) => go(tail, acc)
      case Cons(Branch(l, r), tail) => go(Cons(l, Cons(r, tail)), acc + 1)
    }
    go(List(t), 0)
  }

  def depth[A](t: Tree[A]): Int = {
    @tailrec
    def go(tStack: List[Tree[A]], acc: Int): Int = tStack match {
      case Nil => acc
      case ts => go(ts.flatMap{
        case Leaf(_) => Nil
        case Branch(l, r) => List(l, r)
      }, acc + 1)
    }
    go(List(t), 0)
  }

  def maxValue(t: Tree[Int]): Int = {
    @tailrec
    def go(tStack: List[Tree[Int]], maxV: Int): Int = tStack match {
      case Nil => maxV
      case Cons(Leaf(v), tail) => go(tail, max(v, maxV))
      case Cons(Branch(l, r), tail) => go(Cons(l, Cons(r, tail)), maxV)
    }
    go(List(t), Int.MinValue)
  }

  def sizeCPS[A](t: Tree[A]): Int = {
    def go(t: Tree[A])(f: Int => Int): Int = t match {
      case Leaf(_) => f(1)
      case Branch(l, r) => go(l) { dl =>
        go(r) { dr =>
          f(1 + dl + dr)
        }
      }
    }
    go(t)(identity)
  }

  def depthCPS[A](t: Tree[A]): Int = {
    def go(t: Tree[A])(f: Int => Int): Int = t match {
      case Leaf(_) => f(0)
      case Branch(l, r) => go(l) { dl =>
        go(r) { dr =>
          f(1 + max(dl, dr))
        }
      }
    }
    go(t)(identity)
  }

  def depthNormal[A](t: Tree[A]): Int = {
    def go(t: Tree[A]): Int = t match {
      case Leaf(_) => 0
      case Branch(l, r) => 1 + max(go(l), go(r))
    }
    go(t)
  }

  def depthNormal2[A](t: Tree[A]): Int = {
    def go(t: Tree[A])(f: Int => Int): Int = t match {
      case Leaf(_) => f(0)
      case Branch(l, r) => f(1 + max(go(l)(identity), go(r)(identity)))
    }
    go(t)(identity)
  }

  def depthNormal3[A](t: Tree[A]): Int = {
    def go(t: Tree[A])(f: Int => Int): Int = t match {
      case Leaf(_) => f(0)
      case Branch(l, r) => go(r) { dr =>
        f(1 + max(go(l)(identity), dr))
      }
    }
    go(t)(identity)
  }
}