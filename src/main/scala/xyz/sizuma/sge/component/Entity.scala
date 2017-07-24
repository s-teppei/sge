package xyz.sizuma.sge.component

import xyz.sizuma.sge.util.{DefaultImpl, HasObservableState, Observable}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
abstract class Entity[A] extends HasObservableState[A] with DefaultImpl[A] with Component {
  private[this] var _state = initialState

  def initialState: A

  override def state: A = _state

  override def state_=(newState: A): Unit = {
    _state = newState
    notifyObservers()
  }
}
