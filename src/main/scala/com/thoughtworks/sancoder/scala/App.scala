package com.thoughtworks.sancoder.scala

import com.thoughtworks.sancoder.scala.scalaz.day0.Plus

//Created by SanCoder on 8/26/15.


object MyApp {

  def main(args: Array[String]) {

    import com.thoughtworks.sancoder.scala.StringUtil._;
    val welcomeStr: String = "Hello"
    var welcomeStr2: String = "World"
    welcomeStr2 = "World"
    //  println(welcomeStr +++ welcomeStr2)
    implicit val strs: Array[String] = Array("Hello", "World")
    println(dealWithNewString2)
  }


}
