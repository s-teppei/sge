package xyz.sizuma.sge.entity.attribute

import java.util.{Timer, TimerTask}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait AutoUpdate {
  self: HasUpdater[_] =>
  def timer: Timer

  def delay: Int

  def interval: Int

  timer.schedule(new TimerTask {
    override def run() = doUpdate()
  }, delay, interval)
}
