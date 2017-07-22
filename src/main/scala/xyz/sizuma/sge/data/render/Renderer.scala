package xyz.sizuma.sge.data.render

import xyz.sizuma.sge.data.Primitive

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Renderer[To] {
  def render(primitive: Primitive): To
}
