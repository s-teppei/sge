package xyz.sizuma.sge.util

import xyz.sizuma.sge.entity.attribute.HasState

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasObservableState[A] extends Observable[A] with HasState[A]{
  protected def initialState : A
}
