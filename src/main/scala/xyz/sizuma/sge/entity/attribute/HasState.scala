package xyz.sizuma.sge.entity.attribute

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasState[A]{
  protected def initialState:A
  protected def state:A
  protected def state_=(newState:A):Unit
}
