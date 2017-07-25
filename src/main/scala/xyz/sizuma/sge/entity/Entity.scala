package xyz.sizuma.sge.entity

import xyz.sizuma.sge.entity.attribute.HasSelfState
import xyz.sizuma.sge.util.{DefaultImpl, HasObservableState, Observable}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
abstract class Entity[A] extends HasObservableState[A] with HasSelfState[A] with DefaultImpl[A] {
}
