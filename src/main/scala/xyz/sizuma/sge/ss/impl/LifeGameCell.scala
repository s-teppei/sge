package xyz.sizuma.sge.ss.impl

import java.awt.event.{KeyAdapter, KeyEvent, MouseAdapter, MouseEvent}
import java.awt.{Color, Graphics}
import javax.swing.JPanel

import xyz.sizuma.sge.ss.{HasManagedState, StateManager, StatefulComponent}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class LifeGameCell(val cellX:Int,val cellY:Int,override val stateManager:StateManager[(Int,Int),Boolean]) extends JPanel with StatefulComponent[Boolean] with HasManagedState[(Int,Int),Boolean] {
  override protected def key: (Int, Int) = (cellX,cellY)

  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    if(this.state) g.setColor(Color.GREEN) else g.setColor(Color.BLACK)
    g.fillRect(0,0,g.getClipBounds.width,g.getClipBounds.height)
  }
  this.setFocusable(true)

  this.addMouseListener(new MouseAdapter {
    override def mousePressed(e: MouseEvent): Unit = {
      state = true
      println(s"clicked $key")
    }
  })

  this.addKeyListener(new KeyAdapter {
    override def keyTyped(e: KeyEvent): Unit = {
      val parent = getParent.asInstanceOf[LifeGamePanel]
      parent.updating = !parent.updating
      println(s"updating [${parent.updating}]")
    }
  })
}
