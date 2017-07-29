package xyz.sizuma.sge.ss

import java.util.{Timer, TimerTask}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait AutoUpdater {
  self : HasUpdater[_] =>

  protected def timer:Timer
  protected def initialDelay:Int
  protected def delay:Int

  timer.schedule(new TimerTask {
    override def run(): Unit = doUpdate()
  },initialDelay,delay)

}
