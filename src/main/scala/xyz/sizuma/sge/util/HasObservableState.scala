package xyz.sizuma.sge.util

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasObservableState[A] extends Observable[A]{
  private[this] var _state = initialState

  def initialState : A

  def state:A = _state

  def state_=(newState : A):Unit = {
    _state = newState
    notifyObservers()
  }
}
