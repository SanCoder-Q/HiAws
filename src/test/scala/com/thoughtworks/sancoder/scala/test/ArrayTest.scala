package com.thoughtworks.sancoder.scala.test

import scala.collection.mutable.ArrayBuffer

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

//Created by SanCoder on 9/7/15.
class ArrayTest extends Specification with Mockito {
  "The array buffer operations" should {
    "give the correct results" in {

      val arrayBuffer = new ArrayBuffer[Int]

      arrayBuffer += 1
      arrayBuffer sameElements Array(1) must beTrue

      arrayBuffer +=(2, 3, 4) // append
      arrayBuffer sameElements (1 to 4) must beTrue

      arrayBuffer ++= Array(5, 6) // appendAll
      arrayBuffer sameElements (1 to 6) must beTrue

      arrayBuffer.trimEnd(2)
      arrayBuffer sameElements (1 to 4) must beTrue

      arrayBuffer.insert(2, 2, 3)
      arrayBuffer sameElements Array(1, 2, 2, 3, 3, 4) must beTrue

      arrayBuffer.remove(2, 2)
      arrayBuffer sameElements (1 to 4) must beTrue

      arrayBuffer.toArray.isInstanceOf[Array[Int]] must beTrue

      success
    }
  }

  "The array buffer methods" should {
    "give the correct results" in {
      val arrayBuffer = ArrayBuffer(3,2,4,1,5)

      arrayBuffer.sum must_== 15

      arrayBuffer.max must_== 5

      arrayBuffer.min === 1

      arrayBuffer.sorted.foldLeft((true, Int.MinValue))((acc, x)=>(acc._1 & x > acc._2, x))._1 must beTrue

      arrayBuffer.mkString("<", ",", ">") must_== "<3,2,4,1,5>"

      success
    }
  }

  "The two dimension array operations" should {
    "give the correct results" in {

      val matrix = Array(Array(1,2,3), Array(1,2,3), Array(1,2,3))

      matrix.isInstanceOf[Array[Array[Int]]] must beTrue

      matrix(1)(2) must_== 3

      success
    }
  }

}
