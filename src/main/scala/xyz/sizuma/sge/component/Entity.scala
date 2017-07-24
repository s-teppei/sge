package xyz.sizuma.sge.component

import xyz.sizuma.sge.util.{DefaultImpl, Observable}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
abstract class Entity[A] extends Observable[A] with DefaultImpl[A] with Component {
  private[this] var _state = initialState

  def initialState: A

  def state: A = _state

  def state_=(newState: A): Unit = {
    _state = newState
    notifyObservers()
  }
}
