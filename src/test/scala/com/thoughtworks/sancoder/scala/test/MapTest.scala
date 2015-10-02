package com.thoughtworks.sancoder.scala.test

import java.util.NoSuchElementException

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

//Created by SanCoder on 9/7/15.
class MapTest extends Specification with Mockito {

  "The operations of the data structure 'Map'" should {
    "give the correct results" in {

      val testMap = Map(1 -> "1", 2 -> "2", 3 -> "3")

      testMap apply 2 must_== "2"

      testMap apply 4 must throwA[NoSuchElementException]

      testMap contains 2 must beTrue

      testMap getOrElse(4, 4) must_== 4

      testMap get 1 must beSome[String]("1")

      val testMutableMap: collection.mutable.Map[Int, String] = testMap.map(identity)(collection.breakOut)

      testMutableMap.isInstanceOf[collection.mutable.Map[Int, String]] must beTrue

      testMutableMap +=(4 -> "4", 5 -> "5")

      testMutableMap apply 5 must_== "5"

      testMutableMap -= 5

      testMutableMap apply 5 must throwA[NoSuchElementException]

      val newTestMap = testMap +(3 -> "4", 4 -> "3")

      newTestMap get 3 must beSome[String]("4")

      newTestMap.foreach((x) => println(x._1.toString + " => " + x._2.toString))

      success
    }
  }

  "The operations of Tuple" should {
    "give the correct results" in {

      val keys = Array(1, 2, 3)
      val values = Array("1", "2", "3")
      val testTuples = keys zip values  // Array(1 -> "1", 2 -> "2", 3 -> "3")

      (testTuples apply 2)._2 must_== "3"

      success
    }
  }

}
