package xyz.sizuma.sge.unit

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Dimension[A] {
  def width : A
  def height : A
  def depth : A
}
