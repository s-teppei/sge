package xyz.sizuma.example

import javax.swing.JFrame

import xyz.sizuma.sge.ss.impl.LifeGamePanel

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object LifeGame {

  def main(args: Array[String]): Unit = {
    val frame = new JFrame()
    val lgp = new LifeGamePanel(18,32)

    frame.add(lgp)
    frame.setResizable(false)
    frame.pack()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setVisible(true)
  }

}
