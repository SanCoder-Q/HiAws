package com.thoughtworks.sancoder.scala.fp.episode0

import org.specs2.mutable.Specification

//Created by SanCoder on 10/2/15.
class Episode0AppTest extends Specification{
  import Episode0._
  "fib" should {
    "return the specify Fibonacci number" in{
      fib(0) === 0
      fib(1) === 1
      fib(7) === 13
      fib(40) === 102334155
    }
  }
}
