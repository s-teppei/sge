package xyz.sizuma.sge.component

import javax.swing.JComponent

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait RenderFor[E <: Entity[_]] {
  def genRender(entity:E):JComponent
}
