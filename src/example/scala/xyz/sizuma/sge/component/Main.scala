package xyz.sizuma.sge.component

import java.awt.{BorderLayout, Graphics2D}
import java.util.Timer
import javax.swing.JFrame

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val jframe = new JFrame()
    jframe.setLayout(new BorderLayout())
    val componentRender = new ComponentRender(new CountingEntity)
    jframe.add(componentRender,BorderLayout.CENTER)

    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    jframe.setVisible(true)
    jframe.pack()
  }

  class CountingEntity(val t:Timer = new Timer()) extends Entity[Int] with HasUpdater[Int] with AutoUpdate{
    override def update(oldState: Int): Int = oldState + 1
    override def timer: Timer = t
    override def delay: Int = 0
    override def interval: Int = 1000
    override def initialState: Int = 0
    override def render(graphics2D: Graphics2D): Unit = graphics2D.drawString(state.toString,10,10)
  }
}
