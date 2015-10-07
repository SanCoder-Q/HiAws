package com.thoughtworks.sancoder.scala.fp.episode4

import org.specs2.mutable.Specification

import scala.{Either => _, Left => _, Right => _}

//Created by SanCoder on 10/6/15.
class EitherTest extends Specification {

  "method map" should {
    "do some map things" in {
      Right(3).map(_ + 1) === Right(4)
      Left("error").asInstanceOf[Either[String, Int]].map(_ + 1) === Left("error")
    }
  }

  "method flatMap" should {
    "do some flatMap things" in {
      Right(3).flatMap {
        case d if d < 3 => Left("too small")
        case d => Right(d + 1)
      } === Right(4)
      Right(2).flatMap {
        case d if d < 3 => Left("too small")
        case d => Right(d + 1)
      } === Left("too small")
    }
  }

  "method orElse" should {
    "return the correct result" in {
      Right(3).orElse(Right(4)) === Right(3)
      Left(3).orElse(Right(4)) === Right(4)
    }
  }

}
