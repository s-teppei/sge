package xyz.sizuma.sge.component

import java.awt.{BorderLayout, Color, Graphics, Graphics2D}
import java.util.Timer
import javax.swing.{JComponent, JFrame, JPanel}
/**
  * Created by Teppei Shiroyama under MIT License.
  */
object Main {
  implicit val countingEntityRender = new RenderFor[CountingEntity] {
    override def genRender(entity: CountingEntity): JComponent = new JPanel(){
      entity.observe(_ => {
        this.revalidate()
        this.repaint()
      })
      override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)
        val bounds = g.getClipBounds
        g.drawString(entity.state.toString,10,10)
      }
    }
  }
  def main(args: Array[String]): Unit = {
    val jframe = new JFrame()
    jframe.setLayout(new BorderLayout())
    val componentRender = new CountingEntity
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
    override protected def initialState: Int = 0
  }
}
