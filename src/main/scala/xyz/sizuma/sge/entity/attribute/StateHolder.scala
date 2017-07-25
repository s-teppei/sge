package xyz.sizuma.sge.entity.attribute

import java.util.UUID

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait StateHolder[A] {
  def apply(uuid:UUID):A
  def update(uuid: UUID,newState:A):Unit
}
