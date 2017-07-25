package xyz.sizuma.sge

import javax.swing.JComponent

/**
  * Created by Teppei Shiroyama under MIT License.
  */
package object component {
  implicit def entityToJComponent[E <: Entity[_]](entity:E)(implicit renderFor:RenderFor[E]):JComponent = renderFor.genRender(entity)
}
