package xyz.sizuma.sge.unit

/**
  * Created by Teppei Shiroyama under MIT License.
  */
case class DimensionI(override val width:Int,override val height:Int,override val depth :Int = 0) extends Dimension[Int] {
}
