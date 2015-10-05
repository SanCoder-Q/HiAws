package com.thoughtworks.sancoder.scala.cps.episode0

import org.specs2.mutable.Specification

//Created by SanCoder on 10/5/15.
class CPSEpisode0Test extends Specification {

  import CPSEpisode0._

  "doSomething" should {
    "return correct result" in {
      doSomething === 205
    }
  }

  "doSomething" should {
    "return correct result" in {
      doSomething2 === 205
    }
  }
}
