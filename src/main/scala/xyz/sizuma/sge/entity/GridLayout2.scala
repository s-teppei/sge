package xyz.sizuma.sge.entity

import java.awt._

import xyz.sizuma.sge.unit.Point

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class GridLayout2(val w: Int, val h: Int, val vCount: Int, val hCount: Int) extends LayoutManager2 {

  private[this] val componentDimension = new Dimension(w, h)
  private[this] val parentDimension = new Dimension(w * hCount, h * vCount)
  private[this] var buffer = Map.empty[java.awt.Component, Point[Int]]

  override def invalidateLayout(target: Container): Unit = {}

  override def getLayoutAlignmentX(target: Container): Float = 0

  override def getLayoutAlignmentY(target: Container): Float = 0

  override def maximumLayoutSize(target: Container): Dimension = parentDimension

  override def addLayoutComponent(comp: java.awt.Component, constraints: scala.Any): Unit = constraints match {
    case p: Point[Int] =>
      buffer += comp -> p
  }

  override def preferredLayoutSize(parent: Container): Dimension = parentDimension

  override def removeLayoutComponent(comp: java.awt.Component): Unit = {
    buffer = buffer.filterNot({
      case (_, c) => c == comp
    })
  }

  override def minimumLayoutSize(parent: Container): Dimension = parentDimension

  override def layoutContainer(parent: Container): Unit = {
    val components = parent.getComponents
    components.foreach(comp => {
      val p = buffer(comp)
      comp.setBounds(new Rectangle(p.x * componentDimension.width, p.y * componentDimension.height, componentDimension.width, componentDimension.height))
    })
  }

  override def addLayoutComponent(name: String, comp: java.awt.Component): Unit = ???
}
