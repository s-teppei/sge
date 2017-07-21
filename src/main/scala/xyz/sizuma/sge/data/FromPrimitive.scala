package xyz.sizuma.sge.data

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait FromPrimitive[A] {
  def fromPrimitive(primitive: Primitive):Option[A]
}
