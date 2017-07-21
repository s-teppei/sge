package xyz.sizuma.sge.data

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait ToPrimitive[A] {
  def toPrimitive(a:A):Primitive
}
