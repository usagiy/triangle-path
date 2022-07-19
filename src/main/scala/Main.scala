package com.zlatko

import WeightedTriangle.Node

import org.slf4j.LoggerFactory

import scala.collection.mutable.Stack


object Main extends App {

  def logger = LoggerFactory.getLogger(this.getClass)

  //logger.info("---------- Min triangle path ------------ ")



  var triangle = List[List[Node]]()
  for (ln <- io.Source.stdin.getLines) {

    val n: List[Node] = ln.split(" ").map(_.trim).toList.map(s => Node(s.toInt))
    triangle = triangle :+ n
    //println(ln)
  }


  logger.info(s"Triangle: ${triangle}")

  val path = WeightedTriangle.findMinPath(triangle)
  logger.info(s" Minimal path is ${path.nodes.map(n => n.weight).mkString(" + ")} = ${path.length}")


}
