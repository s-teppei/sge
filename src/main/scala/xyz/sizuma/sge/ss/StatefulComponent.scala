package xyz.sizuma.sge.ss

import javax.swing.JPanel

/**
  * Created by Teppei Shiroyama under MIT License.
  */
abstract class StatefulComponent[A] extends JPanel {

  protected def state:A
  protected def state_=(newState:A):Unit

  protected def onStateUpdated():Unit = {
    this.revalidate()
    this.repaint()
  }

}
