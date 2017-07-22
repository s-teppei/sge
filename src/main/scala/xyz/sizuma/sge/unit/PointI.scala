package xyz.sizuma.sge.unit

import xyz.sizuma.sge.data._
import xyz.sizuma.sge.data.Primitive._
import xyz.sizuma.sge.data.Conversions._
/**
  * Created by Teppei Shiroyama under MIT License.
  */
case class PointI(x:Int,y:Int,z:Int = 0) extends Point[Int]

object PointI extends ConversionFor[PointI]{
  implicit val conversion:PrimitiveConversion[PointI] = new PrimitiveConversion[PointI] {
    override def fromPrimitive(primitive: Primitive): Option[PointI] = {
      primitive match {
        case d:Dictionary =>
          for(x <- d.get[Int]("x");
              y <- d.get[Int]("y") ) yield d.get[Int]("z") match {
            case Some(z) => PointI(x,y,z)
            case None => PointI(x,y)
          }
        case _ => None
      }
    }
    override def toPrimitive(a: PointI): Dictionary = Dictionary.empty() + ("x",a.x) + ("y",a.y) + ("z",a.z)
  }
}