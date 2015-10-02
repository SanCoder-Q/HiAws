package com.thoughtworks.sancoder.scala.test

import com.thoughtworks.sancoder.scala.OrdinaryScalaClass
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

//Created by SanCoder on 9/9/15.
class OrdinaryScalaClassTest extends Specification with Mockito {

  "The test scala class should" >> {
    "give the correct results" >> {
      val ordinaryClass = new OrdinaryScalaClass("First Name", 30)

      ordinaryClass.show

      ordinaryClass.showOff("Ohhhhh ...")

      val ordinaryClass2 = new OrdinaryScalaClass(40)

      ordinaryClass2.show

      val ordinaryInnerClass = new ordinaryClass.OrdinaryInnerClass("Second Name")

      ordinaryInnerClass.iCanShow2

      ordinaryClass.show

      OrdinaryScalaClass.show2

      OrdinaryScalaClass.showOff("La la la ...")

      val ordinaryClass3 = OrdinaryScalaClass("New Guy", 20)

      ordinaryClass3.show

      ordinaryClass3.showOff("Ha ha ha ...")

      success
    }
  }


}
