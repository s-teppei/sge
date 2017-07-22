package xyz.sizuma.sge.data

import xyz.sizuma.sge.data.Primitive._

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object Conversions {

  implicit val intConversion = new PrimitiveConversion[Int] {
    override def toPrimitive(a: Int): Primitive = Number(a)

    override def fromPrimitive(primitive: Primitive): Option[Int] = primitive match {
      case Number(long) => Some(long.toInt)
      case Real(double) => Some(double.toInt)
      case Chars(string) => try {
        Some(string.toInt)
      } catch {
        case e: NumberFormatException => None
      }
      case _ => None
    }
  }

  implicit val longConversion = new PrimitiveConversion[Long] {
    override def toPrimitive(a: Long): Primitive = Number(a)

    override def fromPrimitive(primitive: Primitive): Option[Long] = primitive match {
      case Number(long) => Some(long)
      case Real(double) => Some(double.toLong)
      case Chars(string) => try {
        Some(string.toLong)
      } catch {
        case e: NumberFormatException => None
      }
      case _ => None
    }
  }

  implicit val doubleConversion = new PrimitiveConversion[Double] {
    override def toPrimitive(a: Double): Primitive = Real(a)

    override def fromPrimitive(primitive: Primitive): Option[Double] = primitive match {
      case Number(long) => Some(long.toDouble)
      case Real(double) => Some(double)
      case Chars(string) => try {
        Some(string.toDouble)
      } catch {
        case e: NumberFormatException => None
      }
      case _ => None
    }
  }

  implicit val booleanConversion = new PrimitiveConversion[Boolean] {
    override def toPrimitive(a: Boolean): Primitive = Bool(a)

    override def fromPrimitive(primitive: Primitive): Option[Boolean] = primitive match {
      case Number(0) => Some(false)
      case Number(_) => Some(true)
      case Real(0) => Some(false)
      case Real(_) => Some(true)
      case Bool(boolean) => Some(boolean)
      case Chars("true") | Chars("t") => Some(true)
      case Chars("false") | Chars("f") => Some(false)
      case _ => None
    }
  }

  implicit val stringConversion = new PrimitiveConversion[String] {
    override def toPrimitive(a: String): Primitive = Primitive.Chars(a)

    override def fromPrimitive(primitive: Primitive): Option[String] = primitive match {
      case Chars(string) => Some(string)
      case _ => None
    }
  }

  implicit def seqToPrimitive[A](implicit toPrimitiveA: ToPrimitive[A]): ToPrimitive[Seq[A]] = seq => Sequence(seq.map(toPrimitiveA.toPrimitive))

  implicit def seqFromPrimitive[A](implicit fromPrimitive: FromPrimitive[A]): FromPrimitive[Seq[A]] = {
    case Sequence(primitives) => Some(primitives.flatMap(fromPrimitive.fromPrimitive))
    case _ => None
  }

  implicit def mapToPrimitive[A](implicit toPrimitive: ToPrimitive[A]): ToPrimitive[Map[String, A]] = map => Dictionary(map.mapValues(toPrimitive.toPrimitive))

  implicit def mapFromPrimitive[A](implicit fromPrimitive: FromPrimitive[A]): FromPrimitive[Map[String, A]] = {
    case Dictionary(map) => Some(map.flatMap({
      case (k, v) =>
        val vOpt = fromPrimitive.fromPrimitive(v)
        vOpt match {
          case None => None
          case Some(p) => Some(k, p)
        }
    }))
    case _ => None
  }
}
