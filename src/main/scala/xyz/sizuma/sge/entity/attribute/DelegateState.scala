package xyz.sizuma.sge.entity.attribute

import xyz.sizuma.sge.util.Observable

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait DelegateState[A] {
  self : HasUUID with HasState[A] =>

  this.state = initialState

  def stateHolder:StateHolder[A]
  override protected def state: A = stateHolder(uuid)
  override protected def state_=(newState: A): Unit = {
    stateHolder(uuid) = newState
    this match {
      case o : Observable[_] => o.notifyObservers()
      case _ =>
    }
  }
}
