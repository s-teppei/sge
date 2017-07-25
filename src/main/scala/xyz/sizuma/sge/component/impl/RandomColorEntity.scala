package xyz.sizuma.sge.component.impl

import java.awt.{Color, Graphics, Graphics2D}
import java.util.Timer
import javax.swing.JComponent

import xyz.sizuma.sge.component.{AutoUpdate, Entity, HasUpdater, ObserverJPanel, RenderFor}
import xyz.sizuma.sge.util.Observable

import scala.util.Random

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class RandomColorEntity(override val timer:Timer = new Timer(),override val delay:Int = 0,override val interval:Int = 1000) extends Entity[Color] with HasUpdater[Color] with AutoUpdate{
  protected def randomColor:Color = {
    val random = new Random
    def random256 = random.nextInt(256)
    new Color(random256,random256,random256)
  }

  override protected def initialState: Color = randomColor
  override def update(oldState: Color): Color = randomColor
}

object RandomColorEntity extends RenderFor[RandomColorEntity]{
  class RandomColorEntityRender(randomColorEntity: RandomColorEntity) extends ObserverJPanel[Color](randomColorEntity) {

    override def paintComponent(g: Graphics): Unit = {
      super.paintComponent(g)
      val bounds = g.getClipBounds
      g.setColor(randomColorEntity.state)
      g.fillRect(0,0,bounds.width,bounds.height)
    }
  }

  override implicit def genRender(entity: RandomColorEntity): JComponent = new RandomColorEntityRender(entity)
}