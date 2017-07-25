package xyz.sizuma.sge.entity.attribute

import java.util.UUID

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait StateHolder[A] {
  def apply(uuid:UUID):A
  def update(uuid: UUID,newState:A):Unit
}

object StateHolder {
  def empty[A]:StateHolder[A] = new StateHolder[A] {
    private[this] var map = Map.empty[UUID,A]
    override def apply(uuid: UUID): A = map(uuid)
    override def update(uuid: UUID, newState: A): Unit = map += uuid -> newState
  }
}