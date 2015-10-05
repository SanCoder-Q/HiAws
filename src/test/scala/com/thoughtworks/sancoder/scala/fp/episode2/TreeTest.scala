package com.thoughtworks.sancoder.scala.fp.episode2

import org.specs2.mutable.Specification

//Created by SanCoder on 10/5/15.
class TreeTest extends Specification {

  val tree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(3), Leaf(4)), Leaf(5)))

  "method size" should {
    "return correct size of a Tree" in {
      tree.size === 9
      Tree.sizeCPS(tree) === 9
    }
  }

  "method countLeafs" should {
    "return the number of leafs of a Tree" in {
      tree.countLeafs === 5
    }
  }

  "method countBranches" should {
    "return the number of branches of a Tree" in {
      tree.countBranches === 4
    }
  }

  "all depth methods" should {
    "return the same depth of a Tree" in {
      tree.depth == 3
      Tree.depthCPS(tree) === 3
      Tree.depthNormal(tree) === 3
      Tree.depthNormal2(tree) === 3
      Tree.depthNormal3(tree) === 3
    }
  }

  "method maxValue" should {
    "return the max value of a tree" in {
      Tree.maxValue(tree) === 5
    }
  }
}
