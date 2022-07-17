package com.zlatko

import org.scalatest.funsuite.AnyFunSuite
import WeightedTriangle.{Node, logger}

import scala.collection.mutable


class WeightedTriangleTest extends AnyFunSuite{


  test("min path") {
    var s: mutable.Stack[List[Node]] = mutable.Stack(List( Node(1), Node(6), Node(7)), List( Node(3), Node(9)), List(Node(2)))

    val p =  WeightedTriangle.findMinPath(s)
    logger.info(s"Path: ${p}")
    assert(p.length ==6 )
  }


}
