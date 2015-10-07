package com.thoughtworks.sancoder.scala.fp.episode4

import scala.{Either => _, Left => _, Right => _}

//Created by SanCoder on 10/6/15.
trait Either[+E, +A] {

  def map[B] = Either.map[E, A, B](this) _

  def flatMap[Err >: E, B] = Either.flatMap[Err, A, B](this) _

  def orElse[Err >: E, B >: A] = Either.orElse[Err, B](this) _
}

case class Left[+E](value: E) extends Either[E, Nothing]

case class Right[+A](value: A) extends Either[Nothing, A]

object Either {

  def map[E, A, B](d: Either[E, A])(f: A => B): Either[E, B] = d match {
    case l@Left(_) => l
    case Right(a) => Right(f(a))
  }

  def flatMap[E, A, B](d: Either[E, A])(f: A => Either[E, B]): Either[E, B] = d match {
    case l@Left(_) => l
    case Right(a) => f(a)
  }

  def orElse[E, A](d: Either[E, A])(default: Either[E, A]): Either[E, A] = d match {
    case Left(_) => default
    case r@Right(_) => r
  }
}
