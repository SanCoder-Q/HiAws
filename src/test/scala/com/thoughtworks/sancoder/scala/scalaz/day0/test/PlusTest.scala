package com.thoughtworks.sancoder.scala.scalaz.day0.test

import org.specs2.mutable.Specification
import org.specs2.mock.Mockito

import scalaz._, Scalaz._

//Created by SanCoder on 8/31/15.
class PlusTest extends Specification with Mockito {

  import com.thoughtworks.sancoder.scala.scalaz.day0.Plus

  "Ad-hoc polymorphism: 1 plus 2" should {
    "give 3" in {
      implicit val plusImpl = new Plus[Int] {
        override def plus(a1: Int, a2: Int): Int = a1 + a2
      }

      def plus[A: Plus](a1: A, a2: A): A = implicitly[Plus[A]].plus(a1, a2)

      plus(1, 2) == 3
    }
  }

  "validation" should {
    "do something" in {
      val ss = "1a"::"100"::"-100"::Nil

      implicit val em = new Monoid[NumberFormatException] {
        override def zero: NumberFormatException = new NumberFormatException()

        override def append(f1: NumberFormatException, f2: => NumberFormatException): NumberFormatException = {
          new NumberFormatException(f1.getMessage + "," + f2.getMessage)
        }
      }

      def validate(str: String) = {
        str.parseInt.filter(_ > 0)
      }


      ss.map(validate).map{
        case Success(i) => println("::" + i)
        case Failure(e) => println("::" + e.getMessage)
      }

      1 == 1

    }
  }

}
