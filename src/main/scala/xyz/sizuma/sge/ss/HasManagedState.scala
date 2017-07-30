package xyz.sizuma.sge.ss

import xyz.sizuma.sge.ss.StateManager.ListenEvidence

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasManagedState[Key,A] {
  self : StatefulComponent[A] =>

  protected def stateManager:StateManager[Key,A]

  protected def key:Key

  protected val listenEvidence:ListenEvidence[Key,A] = stateManager.listenUpdate(key, () => onStateUpdated())

  override protected def state: A = stateManager(key)

  override protected def state_=(newState: A): Unit = stateManager(key) = newState
}
