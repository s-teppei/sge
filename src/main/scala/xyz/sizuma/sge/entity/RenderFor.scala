package xyz.sizuma.sge.entity

import javax.swing.JComponent

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait RenderFor[E <: Entity[_]] {
  implicit def genRender(entity:E):JComponent
}
