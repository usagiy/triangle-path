package com.zlatko

import org.slf4j.LoggerFactory

import scala.collection.mutable

object WeightedTriangle {

  def logger = LoggerFactory.getLogger(this.getClass)


  case class Node(weight: Int) extends AnyVal
  case class Path(length:Int, nodes:List[Node]){
    def this(n:Node) = this(n.weight, List(n))
    def addNode(n:Node) = Path(length + n.weight, n::nodes)
  }




  def findMinPath(triangle: List[List[Node]]): Path = {

    val p: List[Path] = triangle.foldRight(List.fill(triangle.last.size)(Path(0, List())))((row, path) => {
      row.length match {
        case 1 =>
          path.map(p => p.addNode(row.head))
        case _ =>
          pruneNodes[Path](row.zip(path).map(p => p._2.addNode(p._1)), mergePaths)
      }
    })
    p.head
  }


  def pruneNodes[T](row:List[T], merge: (T, T) => Path) = {
    row.zip(row.tail).map(p => merge(p._1,p._2))
  }

  def mergeNodes(n1:Node, n2:Node) = {
    if (n1.weight <= n2.weight) new Path(n1) else new Path(n2)
  }

  def mergePaths(p1:Path, p2:Path) = {
    if (p1.length <= p2.length) p1 else p2
  }



}
