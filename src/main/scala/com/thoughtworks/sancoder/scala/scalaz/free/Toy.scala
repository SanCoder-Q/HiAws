package com.thoughtworks.sancoder.scala.scalaz.free

//Created by SanCoder on 8/28/15.
sealed trait Toy[+Next]
object Toy {
  case class Output[Next](a: String, next: Next) extends Toy[Next]
  case class Bell[Next](next: Next) extends Toy[Next]
  case class Done() extends Toy[Nothing]

  def output[Next](a: String, next: Next): Toy[Next] = Output(a, next)
  def bell[Next](next: Next): Toy[Next] = Bell(next)
  def done(): Toy[Nothing] = Done()
}