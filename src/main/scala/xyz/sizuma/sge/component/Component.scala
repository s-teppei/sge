package xyz.sizuma.sge.component

import java.awt.Graphics2D

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Component {
  def render(graphics2D: Graphics2D):Unit
}
