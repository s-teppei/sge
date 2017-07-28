package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasSelfState[A] {
  self : StatefulComponent[A] =>

  private[this] var _state:A = initialState

  protected def initialState:A

  override protected def state: A = _state

  override protected def state_=(newState: A): Unit = {
    _state = newState
    this.onStateUpdated()
  }
}
