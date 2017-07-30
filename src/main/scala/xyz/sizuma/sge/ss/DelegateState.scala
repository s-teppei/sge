package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait DelegateState[Key,A] {
  self : StatefulComponent[A] =>

  protected def delegatee:Delegatee[Key,A]

  protected def initialState:A

  protected def key:Key

  override protected def state: A = delegatee(key)

  override protected def state_=(newState: A): Unit = {
    delegatee(key) = newState
    onStateUpdated()
  }
}
