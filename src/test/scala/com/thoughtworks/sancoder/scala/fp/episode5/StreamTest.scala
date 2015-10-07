package com.thoughtworks.sancoder.scala.fp.episode5

import org.specs2.control.Debug
import org.specs2.mutable.Specification

import scala.{Stream => _, Option => _, Some => _, None => _, List => _}
import com.thoughtworks.sancoder.scala.fp.episode3._
import com.thoughtworks.sancoder.scala.fp.episode1._

//Created by SanCoder on 10/7/15.
class StreamTest extends Specification with Debug {

  "method apply" should {
    "create new stream" in {
      val s = Stream(1, 2, 3, 4)
      val u = s.uncons
      u match {
        case Some((head, tail)) => head === 1
        case None => 0 === 1
      }
    }
  }

  "method cons" should {
    "lazy load" in {
      var isLoaded = false
      def data = {
        println("loading..."); isLoaded = true; 30
      }
      val s = Stream.cons(data, Stream.empty)
      isLoaded === false
      s.uncons
      isLoaded === true
    }
  }

  "method toList" should {
    "change a Stream to a List" in {
      Stream(1, 2, 3, 4).toList === List(1, 2, 3, 4)
    }
  }
}
