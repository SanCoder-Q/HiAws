package com.thoughtworks.sancoder.scala.test

//Created by SanCoder on 9/21/15.
import org.specs2.mutable.Specification

//Created by SanCoder on 9/21/15.
class StepTest extends Specification{
  step {"step1===".pp}
  "------" >> {
    "step1.5".pp
    1 === 1
  }
  step {"step2===".pp}
  "------" >> {
    Thread.sleep(1000)
    "step2.5".pp
    1 === 1
  }
  //  step {"step3===".pp}
  "------" >> {
    "step3.5".pp
    1 === 1
  }
  step {"step4===".pp}
  "------" >> {
    "step4.5".pp
    1 === 1
  }
  step {"step5===".pp}
  "------" >> {
    "step5.5".pp
    1 === 1
  }
  step {"step6===".pp}

}