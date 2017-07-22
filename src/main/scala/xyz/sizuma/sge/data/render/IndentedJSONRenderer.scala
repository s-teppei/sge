package xyz.sizuma.sge.data.render

import xyz.sizuma.sge.data.Primitive

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class IndentedJSONRenderer(indent:String = "\t") extends Renderer[String]{
  def renderPrimitive(primitive: Primitive) : String = primitive match {
    case Primitive.Number(long) => long.toString
    case Primitive.Real(double) => double.toString
    case Primitive.Chars(string) => '"' + string + '"'
    case Primitive.Bool(boolean) => boolean.toString
    case Primitive.Null => "null"
    case Primitive.Sequence(sq) => "[" + sq.map(render).mkString(",") + "]"
    case Primitive.Dictionary(dic) => "{\n" +dic.mapValues(render).map({
      case (k,v) => k+":"+v
    }).mkString(",\n" )+ "\n}\n"
  }

  override def render(primitive: Primitive): String = {
    var level = 0
    def indents = (0 until level).map(_ => indent).mkString("")
    val str = renderPrimitive(primitive)
    str.lines.map(line => {
      if(line.contains("}")) level -= 1
      val result = indents + line
      if(line.contains("{")) level += 1
      result
    }).mkString("\n")
  }
}
