package com.thoughtworks.sancoder.scala

//Created by SanCoder on 8/26/15.
object StringUtil {
  implicit class operator(str : String) {
    def +++(nextStr: String) = {
      str + ", " + nextStr
    }
  }
}
