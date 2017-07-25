package xyz.sizuma.sge.entity.attribute

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait DelegateState[A] {
  self : HasUUID with HasState[A] =>

  this.state = initialState

  def stateHolder:StateHolder[A]
  override protected def state: A = stateHolder(uuid)
  override protected def state_=(newState: A): Unit = stateHolder(uuid) = newState
}
