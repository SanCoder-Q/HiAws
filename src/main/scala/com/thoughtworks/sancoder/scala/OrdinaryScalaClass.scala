package com.thoughtworks.sancoder.scala

//Created by SanCoder on 9/8/15.
class OrdinaryScalaClass( val name: String = "default name", private var age:Int ) extends ShowOff{ self =>

  class OrdinaryInnerClass(var whyHasTwoName: String) {
    val howAboutThreeName = whyHasTwoName

    println("I have two names, maybe three.")

    self.age = howAboutThreeName.length

    def iCanShow2 {
      println("My name is " + self.name + " " + howAboutThreeName + ", and I am " + self.age + " years old :(")
    }
  }

  def this(newAge: Int) {
    this(age = newAge)
    this.age += 1
  }

  def show {
    println("My name is " + name + ", and I am " + age + " years old :(")
  }

  override def showOff(blablabla: String): Unit = {
    println(blablabla + ":(")
  }
}

object OrdinaryScalaClass extends ShowOff{

  def apply(name: String, age: Int) = {
    new OrdinaryScalaClass(name, age)
  }

  def show2 {
    println("I don't have a name because i am a singleton.")
  }

  override def showOff(blablabla: String): Unit = {
    println(blablabla + "LoL")
  }
}

abstract class ShowOff {
  def showOff(blablabla: String): Unit
}
