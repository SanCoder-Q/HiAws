package com.thoughtworks.sancoder.scala

//Created by SanCoder on 8/26/15.
object StringUtil {
  implicit class operator(str : String) {
    def +++ : String => String = {
      println("----------implicit class val function----------")
      str + ", " + _
    }

    def ++++(nextStr : String) : String = {
      println("----------implicit class def method----------")
      str + ", " + nextStr
    }
  }

  class NewString(val str : String) {
    def +++++(nextStr: String) : String = {
      str + ", " + nextStr
    }
  }

  implicit def stringWrapper(str : String): NewString = {
    new NewString(str)
  }

  def dealWithNewString(newStr : NewString, nextStr : String) : String = {
    newStr +++++ nextStr
  }

  def dealWithNewString2(implicit newStrs : Array[String]) = {
    newStrs.reduce(_ + ", " + _)
  }
}
