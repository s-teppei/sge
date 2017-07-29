package xyz.sizuma.sge.ss

import javax.swing.{JComponent, JPanel}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait StatefulComponent[A] {

  self : JComponent =>

  protected def state:A
  protected def state_=(newState:A):Unit

  protected def onStateUpdated():Unit = {
    this.revalidate()
    this.repaint()
  }

}
