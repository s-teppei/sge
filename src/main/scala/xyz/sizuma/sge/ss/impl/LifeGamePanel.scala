package xyz.sizuma.sge.ss.impl

import java.awt.event.{KeyAdapter, KeyEvent}
import java.util.{Timer, TimerTask}
import javax.swing.JPanel

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class LifeGamePanel(val vCount:Int,val hCount:Int) extends JPanel{

  private[this] val _layout = new GridLayout2(vCount,hCount)
  private[this] val lgsm = new LifeGameStateManager
  private[this] val timer = new Timer
  var updating = true

  setLayout(_layout)
  for(y <- 0 until vCount ;
      x <- 0 until hCount
  ){
    val cell = new LifeGameCell(x,y,lgsm)
    this.add(cell,(x,y))
  }

  timer.schedule(new TimerTask {
    override def run(): Unit = {
      if(updating) lgsm.updateAll()
    }
  },0,1000)
}
