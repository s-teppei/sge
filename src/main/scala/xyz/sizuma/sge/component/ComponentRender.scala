package xyz.sizuma.sge.component

import java.awt.{Graphics, Graphics2D}
import javax.swing.JPanel

import xyz.sizuma.sge.util.Observable

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class ComponentRender(val component: Component) extends JPanel{

  component match {
    case observable : Observable[_] =>
      observable.observe( _ => {
        this.revalidate()
        this.repaint()
      })
    case _ =>
  }

  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    component.render(g.asInstanceOf[Graphics2D])
  }

}
