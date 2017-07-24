package xyz.sizuma.sge.component

import java.awt.{Graphics, Graphics2D}
import java.util.Observable
import javax.swing.JPanel

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class ComponentRender(val component: Component) extends JPanel{

  component match {
    case observable : Observable =>
      observable.addObserver( (_,_) => {
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
