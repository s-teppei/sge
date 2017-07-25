package xyz.sizuma.sge.component

import java.awt.{BorderLayout, Graphics}
import java.util.Timer
import javax.swing.{JComponent, JFrame, JPanel}

import xyz.sizuma.sge.component.impl.RandomColorEntity

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object Main2 {
  def main(args: Array[String]): Unit = {
    val jframe = new JFrame()
    jframe.setLayout(new BorderLayout())
    jframe.add(new RandomColorEntity(),BorderLayout.CENTER)

    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    jframe.setVisible(true)
    jframe.pack()
  }
}
