package com.thoughtworks.sancoder.scala.test

import java.io.ByteArrayOutputStream

import com.thoughtworks.sancoder.scala.MyApp
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

//Created by SanCoder on 8/26/15.
class AppTest extends Specification with Mockito{

  val stream = new ByteArrayOutputStream()

  "main in App" should {
    "output 'Hello, World'" in {
      Console.withOut(stream) {
        MyApp.main(Array())
        stream.toString() equals("Hello, World\n")
      }
    }
  }

  "'Hello'+++'World'" should {
    "= 'Hello, World'" in {
      import com.thoughtworks.sancoder.scala.StringUtil._
      "Hello" +++ "World" === "Hello, World"
    }
  }

  "'Hello'++++'World'" should {
    "= 'Hello, World'" in {
      import com.thoughtworks.sancoder.scala.StringUtil._
      "Hello" ++++ "World" === "Hello, World"
    }
  }

  "'Hello'+++++'World'" should {
    "= 'Hello, World'" in {
      import com.thoughtworks.sancoder.scala.StringUtil._
      "Hello" +++++ "World" === "Hello, World"
    }
  }

  "'Hello'.+++('World')" should {
    "= 'Hello, World'" in {
      import com.thoughtworks.sancoder.scala.StringUtil._
      "Hello".+++("World") === "Hello, World"
    }
  }


}
