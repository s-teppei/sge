package xyz.sizuma.sge.data

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait PrimitiveConversion[A] extends FromPrimitive[A] with ToPrimitive[A]
