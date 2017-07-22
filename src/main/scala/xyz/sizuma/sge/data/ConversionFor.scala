package xyz.sizuma.sge.data

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait ConversionFor[A] {
  implicit def conversion:PrimitiveConversion[A]
}
