package xyz.sizuma.sge.data.render
import xyz.sizuma.sge.data.Primitive

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object CompactJSONRenderer extends Renderer[String]{
  override def render(primitive: Primitive): String = primitive match {
    case Primitive.Number(long) => long.toString
    case Primitive.Real(double) => double.toString
    case Primitive.Chars(string) => '"' + string + '"'
    case Primitive.Bool(boolean) => boolean.toString
    case Primitive.Null => "null"
    case Primitive.Sequence(sq) => "[" + sq.map(render).mkString(",") + "]"
    case Primitive.Dictionary(dic) => "{" +dic.mapValues(render).map({
      case (k,v) => k+":"+v
    }).mkString("," )+ "}"
  }
}
