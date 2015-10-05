package com.thoughtworks.sancoder.scala.fp.episode3

import scala.{Option => _, Some => _, None => _}

//Created by SanCoder on 10/5/15.
trait Option[+A] {

  def map[B] = Option.map[A, B](this) _

  def flatMap[B] = Option.flatMap[A, B](this) _

  def filter = Option.filter(this) _

  def getOrElse[B >: A] = Option.getOrElse[B](this) _

  def orElse[B >: A] = Option.orElse[B](this) _
}

case class Some[+A](value: A) extends Option[A]

case object None extends Option[Nothing]

object Option {

  def map[A, B](o: Option[A])(f: A => B): Option[B] = o match {
    case Some(a) => Some(f(a))
    case _ => None
  }

  def flatMap[A, B](o: Option[A])(f: A => Option[B]): Option[B] = o match {
    case Some(a) => f(a)
    case _ => None
  }

  def filter[A](o: Option[A])(f: A => Boolean): Option[A] = o match {
    case o@Some(a) if f(a) => o
    case _ => None
  }

  def getOrElse[A](o: Option[A])(default: A): A = o match {
    case Some(a) => a
    case _ => default
  }

  def orElse[A](o: Option[A])(default: Option[A]): Option[A] = o match {
    case o@Some(_) => o
    case _ => default
  }
}