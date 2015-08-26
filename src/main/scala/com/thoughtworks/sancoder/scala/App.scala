package com.thoughtworks.sancoder.scala

//Created by SanCoder on 8/26/15.
object App {
  def main(args: Array[String]) {
    import com.thoughtworks.sancoder.scala.StringUtil._;
    val welcomeStr: String = "Hello"
    var welcomeStr2: String = "World"
    welcomeStr2 = "World"
    println(welcomeStr +++ welcomeStr2)
  }
}
