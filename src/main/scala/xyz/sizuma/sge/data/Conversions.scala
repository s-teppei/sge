package xyz.sizuma.sge.data

import xyz.sizuma.sge.data.Primitive.{Bool, Chars, Number, Real}

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object Conversions {

  val intConversion = new PrimitiveConversion[Int] {
    override def toPrimitive(a: Int): Primitive = Number(a)
    override def fromPrimitive(primitive: Primitive): Option[Int] = primitive match {
      case Number(long) => Some(long.toInt)
      case Real(double) => Some(double.toInt)
      case Chars(string) => try{
        Some(string.toInt)
      }catch {
        case e:NumberFormatException => None
      }
      case _ => None
    }
  }

  val longConversion = new PrimitiveConversion[Long] {
    override def toPrimitive(a: Long): Primitive = Number(a)
    override def fromPrimitive(primitive: Primitive): Option[Long] = primitive match {
      case Number(long) => Some(long)
      case Real(double) => Some(double.toLong)
      case Chars(string) => try{
        Some(string.toLong)
      }catch {
        case e:NumberFormatException => None
      }
      case _ => None
    }
  }

  val doubleConversion = new PrimitiveConversion[Double] {
    override def toPrimitive(a: Double): Primitive = Real(a)
    override def fromPrimitive(primitive: Primitive): Option[Double] = primitive match {
      case Number(long) => Some(long.toDouble)
      case Real(double) => Some(double)
      case Chars(string) => try{
        Some(string.toDouble)
      }catch {
        case e:NumberFormatException => None
      }
      case _ => None
    }
  }

  val booleanConversion = new PrimitiveConversion[Boolean] {
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
}