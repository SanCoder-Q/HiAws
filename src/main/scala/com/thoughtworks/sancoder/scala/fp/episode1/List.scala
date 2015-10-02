package com.thoughtworks.sancoder.scala.fp.episode1

import scala.annotation.tailrec
import scala.{List => _}

//Created by SanCoder on 10/2/15.
trait List[+A] {
  def sum[B >: A] = List.sum[B, A](this) _

  def head: A = List.head(this)

  def tail: List[A] = List.tail(this)

  def take = List.take(this) _

  def takeWhile = List.takeWhile(this) _

  def filter = takeWhile

  def drop = List.drop(this) _

  def dropWhile = List.dropWhile(this) _

  def ++[B >: A] = List.++[B](this) _

  def reverse: List[A] = List.reverse(this)

  def length: Int = List.length(this)

  def get = List.get(this) _

  def map[B] = List.map[A, B](this) _

  def flatMap[B] = List.flatMap[A, B](this) _

  def foldRight[B] = List.foldRight[A, B](this) _

  def foldLeft[B] = List.foldLeft[A, B](this) _

  def reduceLeft[B >: A] = List.reduceLeft[B](this) _

  def reduceRight[B >: A] = List.reduceRight[B](this) _
}

case class Cons[+A](override val head: A, override val tail: List[A]) extends List[A]

case object Nil extends List[Nothing]

object List {
  def apply[A](elem: A*): List[A] = {
    @tailrec
    def go(cur: List[A], elem: Seq[A]): List[A] = elem match {
      case e if e.isEmpty => cur
      case e => go(Cons(e.head, cur), e.tail)
    }
    go(Nil, elem.reverse)
  }

  def sum[A, B <: A](l: List[B])(z: A)(f: (A, A) => A): A = {
    @tailrec
    def go(acc: A, l: List[B])(z: A)(f: (A, A) => A): A = l match {
      case Nil => acc
      case Cons(h, t) => go(f(acc, h), t)(z)(f)
    }
    go(z, l)(z)(f)
  }

  def head[A](l: List[A]): A = l match {
    case Nil => sys.error("Empty List")
    case Cons(h, _) => h
  }

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("Empty List")
    case Cons(_, t) => t
  }

  def take[A](l: List[A])(n: Int) = {
    @tailrec
    def go(l0: List[A], l1: List[A], n: Int): List[A] = l0 match {
      case Nil => sys.error("List not long enough")
      case _ if n == 0 => l1
      case Cons(h, t) => go(t, Cons(h, l1), n - 1)
    }
    go(l, Nil, n).reverse
  }

  def takeWhile[A](l: List[A])(f: A => Boolean) = {
    @tailrec
    def go(l0: List[A], l1: List[A], f: A => Boolean): List[A] = l0 match {
      case Nil => l1
      case Cons(h, t) => go(t, if (f(h)) Cons(h, l1) else l1, f)
    }
    go(l, Nil, f).reverse
  }

  def drop[A](l: List[A])(n: Int) = {
    @tailrec
    def go(l: List[A], n: Int): List[A] = n match {
      case k if k <= 0 => l
      case _ => l match {
        case Nil => sys.error("List not long enough")
        case Cons(h, t) => go(t, n - 1)
      }
    }
    go(l, n)
  }

  def dropWhile[A](l: List[A])(f: A => Boolean) = {
    @tailrec
    def go(l0: List[A], l1: List[A], f: A => Boolean): List[A] = l0 match {
      case Nil => l1
      case Cons(h, t) => go(t, if (f(h)) l1 else Cons(h, l1), f)
    }
    go(l, Nil, f).reverse
  }

  def ++[A](l0: List[A])(l1: List[A]) = {
    @tailrec
    def go(l0: List[A], l1: List[A]): List[A] = l0 match {
      case Nil => l1
      case Cons(h, t) => go(t, Cons(h, l1))
    }
    go(l0.reverse, l1)
  }

  def reverse[A](l: List[A]): List[A] = {
    @tailrec
    def go(l0: List[A], l1: List[A]): List[A] = l0 match {
      case Nil => l1
      case Cons(h, t) => go(t, Cons(h, l1))
    }
    go(l, Nil)
  }

  def length[A](l: List[A]): Int = {
    @tailrec
    def go(l: List[A], count: Int): Int = l match {
      case Nil => count
      case Cons(_, t) => go(t, count + 1)
    }
    go(l, 0)
  }

  @tailrec
  def get[A](l: List[A])(i: Int): A = i match {
    case k if k <= 0 => l.head
    case _ => get(l.tail)(i - 1)
  }

  def map[A, B](l: List[A])(f: A => B): List[B] = {
    @tailrec
    def go(l0: List[A], l1: List[B], f: A => B): List[B] = l0 match {
      case Nil => l1
      case Cons(h, t) => go(t, Cons(f(h), l1), f)
    }
    go(l, Nil, f).reverse
  }

  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = {
    val mapList: List[List[B]] = map(l)(f)
    @tailrec
    def go(l0: List[List[B]], l1: List[B]): List[B] = l0 match {
      case Nil => l1
      case Cons(h, t) => go(t, l1 ++ h)
    }
    go(mapList, Nil)
  }

  def foldRight[A, B](l: List[A])(z: B)(f: (A, B) => B): B = l match {
    case Nil => z
    case Cons(h, t) => f(h, foldRight(t)(z)(f))
  }


  @tailrec
  def foldLeft[A, B](l: List[A])(z: B)(f: (B, A) => B): B = l match {
    case Nil => z
    case Cons(h, t) => foldLeft(t)(f(z, h))(f)
  }

  def reduceLeft[A](l: List[A])(f: (A, A) => A): A = l match {
    case Nil => sys.error("Empty list cannot reduce")
    case Cons(h, t) => foldLeft(t)(h)(f)
  }

  def reduceRight[A](l: List[A])(f: (A, A) => A): A = l match {
    case Cons(h, Nil) => h
    case Cons(h, t) => f(h, reduceRight(t)(f))
  }

  def appendByFoldLeft[A](l0: List[A], l1: List[A]): List[A] = foldLeft(l0.reverse)(l1){
    (l, e) => Cons(e, l)
  }

  def appendByFoldRight[A](l0: List[A], l1: List[A]): List[A] = foldRight(l0)(l1){
    (e, l) => Cons(e, l)
  }

  def sum(acc: Int)(list: List[Int]): Int = sum(list)(0)(_ + _)
}
