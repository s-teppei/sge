package xyz.sizuma.sge.unit

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Point[T] {
  def x: T

  def y: T

  def z: T

  override def equals(obj: scala.Any): Boolean = obj match {
    case p: Point[T] => p.x == x && p.y == y && p.z == z
    case _ => false
  }
}