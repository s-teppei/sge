package xyz.sizuma.sge.data

/**
  * Created by Teppei Shiroyama under MIT License.
  */
sealed trait Primitive

object Primitive {

  sealed trait Null extends Primitive

  case class Number(long: Long) extends Primitive

  case class Real(double: Double) extends Primitive

  case class Chars(string: String) extends Primitive

  case class Bool(boolean: Boolean) extends Primitive

  case class Sequence(seq: Seq[Primitive]) extends Primitive

  case class Dictionary(map: Map[String, Primitive]) extends Primitive {
    def get[A](key: String)(implicit fromPrimitive: FromPrimitive[A]): Option[A] = map.get(key).flatMap(fromPrimitive.fromPrimitive)

    def +(key: String, primitive: Primitive): Dictionary = Dictionary(map + (key -> primitive))

    def +[A](key: String, data: A)(implicit toPrimitive: ToPrimitive[A]): Dictionary = Dictionary(map + (key -> toPrimitive.toPrimitive(data)))
  }

  object Sequence {
    def empty(): Sequence = Sequence(Seq.empty)
  }

  object Dictionary {
    def empty(): Dictionary = Dictionary(Map.empty)
  }

  case object Null extends Null

}
