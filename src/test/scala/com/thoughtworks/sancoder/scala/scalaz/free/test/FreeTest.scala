package com.thoughtworks.sancoder.scala.scalaz.free.test

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

//Created by SanCoder on 8/28/15.
class FreeTest extends Specification with Mockito{

  "fix" should {
    "give an object of " +
      "Fix(Bell(Fix(Output('StrData', Fix(Done())))))" in {
      import com.thoughtworks.sancoder.scala.scalaz.free.Fix._
import com.thoughtworks.sancoder.scala.scalaz.free.Toy._
//      val obj = fix(bell(fix(output("StrData", fix(done)))))
      // Assert
      1 == 1
    }
  }
}
