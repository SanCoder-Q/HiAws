package com.thoughtworks.sancoder.scala.fp.episode3

import scala.{Option => _, Some => _, None => _}

import org.specs2.mutable.Specification

//Created by SanCoder on 10/5/15.
class OptionTest extends Specification {
  "method map" should {
    "do some map work" in {
      Some(1).map(_ + 2) === Some(3)
      None.asInstanceOf[Option[Int]].map(_ + 2) === None
    }
  }

  "method flatMap" should {
    "do some flat map work" in {
      Some(1).flatMap(v => Some(v + 2)) === Some(3)
      None.asInstanceOf[Option[Int]].flatMap(v => Some(v + 2)) === None
    }
  }

  "method filter" should {
    "filter the false" in {
      Some(1).filter(_ < 2) === Some(1)
      Some(2).filter(_ < 2) === None
    }
  }

  "method getOrElse" should {
    "get the correct result" in {
      Some(1).getOrElse(0) === 1
      None.asInstanceOf[Option[Int]].getOrElse(0) === 0
    }
  }

  "method orElse" should {
    "get the correct result" in {
      Some(1).orElse(Some(0)) === Some(1)
      None.asInstanceOf[Option[Int]].orElse(Some(0)) === Some(0)
    }
  }
}
