package com.thoughtworks.sancoder.scala.fp.episode1

import org.specs2.mutable.Specification

import scala.Int

//Created by SanCoder on 10/2/15.
class ListTest extends Specification {

  import scala.{List => _}

  class ParentInt(val inner: Int)

  object ParentInt {
    def apply(inner: Int) = new ParentInt(inner)
  }

  case class ChildInt(inner2: Int) extends ParentInt(inner2)

  "method append" should {
    "append tow lists" in {
      List(1, 2) ++ List(3, 4) === List(1, 2, 3, 4)
      List.appendByFoldLeft(List(1, 2), List(3, 4)) === List(1, 2, 3, 4)
      List.appendByFoldRight(List(1, 2), List(3, 4)) === List(1, 2, 3, 4)
    }
  }

  "method apply" should {
    "return a new List" in {
      List() === Nil
      List(1, 2, 3, 4) === Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
      List("1", "2", "3") === Cons("1", Cons("2", Cons("3", Nil)))
    }
  }

  "method sum" should {
    "return sum" in {
      List(1, 2, 3, 4).sum(0)(_ + _) === 10

      val sum = List[ChildInt](ChildInt(1), ChildInt(2), ChildInt(3), ChildInt(4))
        .sum[ParentInt](ParentInt(0))((a, b) => ParentInt(a.inner + b.inner))
      sum must beAnInstanceOf[ParentInt]
      sum.inner === 10
    }
  }

  "method head and method tail" should {
    "return head and tail of List" in {
      List(1, 2, 3, 4).head === 1
      List(1, 2, 3, 4).tail === List(2, 3, 4)
    }
  }

  "method take" should {
    "return a List of first n elements" in {
      (List(1, 2, 3, 4) take 3) === List(1, 2, 3)
    }
  }

  "method reverse" should {
    "reverse the List" in {
      List(1, 2, 3, 4).reverse === List(4, 3, 2, 1)
    }
  }

  "method takeWhile" should {
    "return the List of elements satisfying the condition" in {
      List(1, 2, 3, 4).takeWhile(_ % 2 == 0) === List(2, 4)
    }
  }

  "method filter" should {
    "return the List of elements satisfying the condition" in {
      List(1, 2, 3, 4).filter(_ % 2 == 0) === List(2, 4)
    }
  }

  "method drop" should {
    "drop the first n elements of List" in {
      List(1, 2, 3, 4).drop(3) === List(4)
    }
  }

  "method dropWhile" should {
    "drop the elements satisfying the condition" in {
      List(1, 2, 3, 4).dropWhile(_ % 2 == 0) === List(1, 3)
    }
  }

  "method ++" should {
    "concatenate two list" in {
      List(1, 2) ++ List(3, 4) === List(1, 2, 3, 4)
      val conc = List[ChildInt](ChildInt(1), ChildInt(2)) ++ List[ParentInt](ParentInt(3), ParentInt(4))
      conc must beAnInstanceOf[List[ParentInt]] // doesn't work
    }
  }

  "method length" should {
    "return the length of a List" in {
      List(1, 2, 3, 4).length === 4
    }
  }

  "method get" should {
    "get the element of given index" in {
      List(1, 2, 3, 4).get(3) === 4
    }
  }

  "method map" should {
    "do some map work" in {
      List(1, 2, 3, 4).map(_ * 2 + "th") === List("2th", "4th", "6th", "8th")
    }
  }

  "method flatMap" should {
    "do some map and flatten work" in {
      val r = List(1, 2)
        .flatMap(i => List(i.toString, (i * 2).toString, (i * 3).toString))
      r === List("1", "2", "3", "2", "4", "6")
    }
  }

  "method foldRight" should {
    "do some fold work" in {
      List(1, 2, 3, 4).foldRight("0")(_ + _) === "12340"
    }
  }

  "method foldLeft" should {
    "do some fold work" in {
      List(1, 2, 3, 4).foldLeft("0")(_ + _) === "01234"
    }
  }

  "method reduceLeft" should {
    "do some reduce work" in {
      List("1", "2", "3", "4").reduceLeft(_ + "{" + _ + "}") === "1{2}{3}{4}"
    }
  }

  "method reduceRight" should {
    "do some reduce work" in {
      List("1", "2", "3", "4").reduceRight(_ + "{" + _ + "}") === "1{2{3{4}}}"
    }
  }
}
