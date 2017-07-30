package xyz.sizuma.sge.ss

import xyz.sizuma.sge.ss.StateManager.ListenEvidence

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait StateManager[Key,A] {
  def apply(key: Key):A
  def update(key: Key,a: A):Unit

  def listenUpdate(key: Key,f: () => Unit):ListenEvidence[Key,A]
  def removeListener(key: Key,f: () => Unit):Unit
}

object StateManager {
  case class ListenEvidence[Key,A](stateManager: StateManager[Key,A],key:Key,f:() => Unit) {
    def remove():Unit = stateManager.removeListener(key,f)
  }
}