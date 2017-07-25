package xyz.sizuma.sge.entity

import xyz.sizuma.sge.util.{DefaultImpl, HasObservableState, Observable}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
abstract class Entity[A] extends HasObservableState[A] with DefaultImpl[A] {
  private[this] var _state = initialState

  protected def initialState: A

  override def state: A = _state

  override def state_=(newState: A): Unit = {
    _state = newState
  }
}
