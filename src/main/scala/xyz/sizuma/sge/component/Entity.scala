package xyz.sizuma.sge.component

import java.util.Observable

/**
  * Created by Teppei Shiroyama under MIT License.
  */
abstract class Entity[A] extends Observable with Component {
  def initialState : A

  private[this] var _state = initialState

  def state:A = _state
  def state_=(newState : A):Unit = {
    _state = newState
    setChanged()
    notifyObservers()
  }
}
