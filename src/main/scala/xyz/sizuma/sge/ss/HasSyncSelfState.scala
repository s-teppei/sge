package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasSyncSelfState[A] {
  self : StatefulComponent[A] =>

  private[this] var _state:A = initialState
  private[this] val _stateLock = new AnyRef

  protected def initialState:A

  override protected def state: A = _stateLock.synchronized(_state)

  override protected def state_=(newState: A): Unit = {
    _stateLock.synchronized{
      _state = newState
    }
    this.onStateUpdated()
  }

}
