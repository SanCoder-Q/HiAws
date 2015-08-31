package com.thoughtworks.sancoder.scala.scalaz.free

//Created by SanCoder on 8/28/15.
case class Fix[Do[_]](nextDo: Do[Fix[Do]])
object Fix{
  def fix(nextDo: Toy[Fix[Toy]]) = Fix[Toy](nextDo)
}
