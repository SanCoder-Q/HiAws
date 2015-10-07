package com.thoughtworks.sancoder.scala.fp.episode5

import scala.annotation.tailrec
import scala.{Stream => _, Option => _, List => _}

import com.thoughtworks.sancoder.scala.fp.episode3._
import com.thoughtworks.sancoder.scala.fp.episode1._

//Created by SanCoder on 10/7/15.
trait Stream[+A] {

  def uncons: Option[(A, Stream[A])]

  def isEmpty: Boolean = uncons.isEmpty

  def toList = Stream.toList(this)
}

object Stream {

  def empty[A]: Stream[A] = new Stream[A] {
    override def uncons = None
  }

  def cons[A](head: => A, tail: => Stream[A]): Stream[A] = new Stream[A] {
    override def uncons = Some((head, tail))
  }

  def apply[A](as: A*): Stream[A] = {
    @tailrec
    def go(s: Stream[A], as: A*): Stream[A] = {
      if (as.isEmpty) s
      else go(cons(as.head, s), as.tail: _*)
    }
    go(Stream.empty, as.reverse: _*)
  }

  def toList[A](s: Stream[A]): List[A] = {
    @tailrec
    def go(s: Stream[A], l: List[A]): List[A] = {
      s.uncons match {
        case Some((h, t)) => go(t, Cons(h, l))
        case _ => l
      }
    }
    go(s, Nil).reverse
  }
}