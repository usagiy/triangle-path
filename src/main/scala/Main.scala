package com.zlatko

import WeightedTriangle.Node

import org.slf4j.LoggerFactory

import scala.collection.mutable.Stack


object Main extends App {

  def logger = LoggerFactory.getLogger(this.getClass)

  //logger.info("---------- Min triangle path ------------ ")

  var s = Stack[List[Node]]()
  for (ln <- io.Source.stdin.getLines) {

    val n = ln.split(" ").map(_.trim).toList.map(s => Node(s.toInt))
    s.push(n)
    //println(ln)
  }

  //logger.info(s"Stack: ${s}")

  val path = WeightedTriangle.findMinPath(s)
  logger.info(s" Minimal path is ${path.nodes.map(n => n.weight).mkString(" + ")} = ${path.nodes.map(n => n.weight).foldLeft(0)(_ + _)}")





}
