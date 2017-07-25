package xyz.sizuma.sge.entity

import java.awt.BorderLayout
import javax.swing.JFrame

import xyz.sizuma.sge.entity.impl.RandomColorEntity

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
