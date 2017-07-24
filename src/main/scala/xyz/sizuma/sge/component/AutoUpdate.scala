package xyz.sizuma.sge.component

import java.util.{Timer, TimerTask}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait AutoUpdate[A] {
  self : HasUpdater[A] =>
  def timer:Timer
  def delay:Int
  def interval:Int

  timer.schedule(new TimerTask {
    override def run() = doUpdate()
  },delay,interval)
}
