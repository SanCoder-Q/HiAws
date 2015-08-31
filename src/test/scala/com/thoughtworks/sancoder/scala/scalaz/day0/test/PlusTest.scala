package com.thoughtworks.sancoder.scala.scalaz.day0.test

import org.specs2.mutable.Specification
import org.specs2.mock.Mockito

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

}
