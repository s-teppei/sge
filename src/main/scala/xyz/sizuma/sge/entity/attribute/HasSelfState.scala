package xyz.sizuma.sge.entity.attribute

import xyz.sizuma.sge.util.Observable

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasSelfState[A] {
  self : HasState[A] =>

  private var _state:A = initialState

  override protected def state: A = _state
  override protected def state_=(newState: A): Unit = {
    _state = newState
    this match {
      case o : Observable[_] => o.notifyObservers()
      case _ =>
    }
  }
}
