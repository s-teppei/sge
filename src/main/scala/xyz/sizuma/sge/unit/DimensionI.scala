package xyz.sizuma.sge.unit

/**
  * Created by Teppei Shiroyama under MIT License.
  */
case class DimensionI(override val width:Int,override val height:Int,override val depth :Int = 0) extends Dimension[Int] {
  override def *(v: Int)(implicit times: {
    def times(v1: Int, v2: Int): Int
  }): Dimension[Int] = DimensionI(times.times(width,v),times.times(height,v),times.times(height,v))
}
