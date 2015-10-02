package com.thoughtworks.sancoder.scala.fp.episode0

import scala.annotation.tailrec

//Created by SanCoder on 10/2/15.
object Episode0 {

  def fib(n: Int): Int = {
    @tailrec
    def go(n: Int, last: Int, lastOfLast: Int): Int = n match {
      case i if i <= 0 => lastOfLast
      case i => go(i-1, last + lastOfLast, last)
    }
    go(n, 1, 0)
  }
}
