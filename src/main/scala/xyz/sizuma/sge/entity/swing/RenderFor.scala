package xyz.sizuma.sge.entity.swing

import javax.swing.JComponent

import xyz.sizuma.sge.entity.Entity

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait RenderFor[E <: Entity[_]] {
  implicit def genRender(entity:E):JComponent
}
