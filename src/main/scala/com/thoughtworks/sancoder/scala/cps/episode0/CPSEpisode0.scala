package com.thoughtworks.sancoder.scala.cps.episode0

//Created by SanCoder on 10/5/15.
object CPSEpisode0 {

  def step_0(f: Int => Int): Int => Int = in => {
    f(in + 1)
  }

  def step_1(f: Int => Int): Int => Int = in => {
    f(in * 2)
  }

  def step_2(f: Int => Int): Int => Int = in => {
    f(in + 3)
  }

  def doSomething: Int = {
    val stepAll = step_0 { in =>
      step_1 { in =>
        step_2(identity)(in)
      }(in)
    }

    stepAll(100)
  }

  def doSomething2: Int ={
    val stepAll2 = step_0(step_1(step_2(identity)))

    stepAll2(100)
  }
}
