package xyz.sizuma.sge.entity.attribute

import xyz.sizuma.sge.entity.Entity

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasAutoUpdater[A] extends HasUpdater[A] with AutoUpdate{
  self : Entity[A] =>
}
