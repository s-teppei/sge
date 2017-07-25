package xyz.sizuma.sge.entity

import javax.swing.JPanel

import xyz.sizuma.sge.util.{Observable, Observer}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class ObserverJPanel[A](target:Observable[A]) extends JPanel with Observer[A]{

  target.observe(this)

  override def onUpdate(target: Observable[A]): Unit = {
    this.revalidate()
    this.repaint()
  }
}
