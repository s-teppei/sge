package xyz.sizuma.sge.unit

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Dimension[A] {
  def width : A
  def height : A
  def depth : A

  def * (v:A)(implicit times : {
    def times(v1:A,v2:A):A
  }):Dimension[A]
}
