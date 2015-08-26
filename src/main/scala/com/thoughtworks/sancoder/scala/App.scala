package com.thoughtworks.sancoder.scala

//Created by SanCoder on 8/26/15.
object MyApp extends App {

  import com.thoughtworks.sancoder.scala.StringUtil._;
  val welcomeStr: String = "Hello"
  var welcomeStr2: String = "World"
  welcomeStr2 = "World"
//  println(welcomeStr +++ welcomeStr2)
  implicit val strs : Array[String] = Array("Hello", "World")
  println(dealWithNewString2)
}
