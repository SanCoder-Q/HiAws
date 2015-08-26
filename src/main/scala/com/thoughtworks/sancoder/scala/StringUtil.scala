package com.thoughtworks.sancoder.scala

//Created by SanCoder on 8/26/15.
object StringUtil {
  implicit class operator(str : String) {
    val +++ : String => String = {
      case nextStr => str + ", " + nextStr
    }

    def ++++(nextStr : String) = {
      str + ", " + nextStr
    }
  }

  class NewString(val str : String) {
    def +++++(nextStr: String) = {
      str + ", " + nextStr
    }
  }

  implicit def stringWrapper(str : String): NewString = {
    new NewString(str)
  }
}
