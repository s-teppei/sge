package xyz.sizuma.sge.data

/**
  * Created by Teppei Shiroyama under MIT License.
  */
sealed trait Primitive

object Primitive {

  case class Number(long: Long) extends Primitive
  case class Real(double: Double) extends Primitive
  case class Chars(string: String) extends Primitive
  case class Bool(boolean: Boolean) extends Primitive
  case class Sequence(seq: Seq[Primitive]) extends Primitive
  case class Dictionary(map: Map[String,Primitive]) extends Primitive
  case object Null extends Primitive

  implicit class Reader(val dictionary: Dictionary) extends AnyVal {
    def get[A](key:String)(implicit fromPrimitive: FromPrimitive[A]) : Option[A] = dictionary.map.get(key).flatMap(fromPrimitive.fromPrimitive)
  }

  implicit class Writer(val dictionary: Dictionary) extends AnyVal {
    def +[A](key:String,data:A)(implicit toPrimitive: ToPrimitive[A]) : Dictionary = Dictionary(dictionary.map + (key -> toPrimitive.toPrimitive(data)))
  }
}
