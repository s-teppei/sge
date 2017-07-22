package xyz.sizuma.sge.data.parser

import xyz.sizuma.sge.data.Primitive
import xyz.sizuma.sge.data.parser.DataParser.DataParserAdaptor

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object JSONStringParser extends DataParserAdaptor{

  override def parseNull: JSONStringParser.Parser[Primitive.Null] = "null" ^^ {
    case _ => Primitive.Null
  }

  override def parseNumber: JSONStringParser.Parser[Primitive.Number] = ("+" | "-" | "") ~ """[0-9]+""".r ^^ {
    case (sign ~ str) => Primitive.Number( (sign+str).toLong )
  }

  override def parseReal: JSONStringParser.Parser[Primitive.Real] = ("+" | "-" | "") ~ """[0-9]+""".r ~ "." ~ """[0-9]+""".r ^^ {
    case (sign ~ r ~ dot ~ f) => Primitive.Real( (sign+r+dot+f).toDouble )
  }

  override def parseString: JSONStringParser.Parser[Primitive.Chars] = "\"" ~ """[^\"]*""".r ~ "\"" ^^ {
    case (_ ~ s ~ _) => Primitive.Chars(s)
  }


  override def parseBool: JSONStringParser.Parser[Primitive.Bool] = ("true" | "false") ^^ {
    case s => Primitive.Bool(s == "true")
  }

  override def parseSequence: JSONStringParser.Parser[Primitive.Sequence] = "[" ~ repsep(parsers,",") ~ "]" ^^ {
    case (_ ~ s ~ _) => Primitive.Sequence(s)
  }

  def keyParser:Parser[(String,Primitive)] = "[a-zA-Z]+".r ~ ":" ~ parsers ^^ {
    case (key ~ _ ~ primitive) => (key,primitive)
  }

  override def parseDictionary: JSONStringParser.Parser[Primitive.Dictionary] = "{" ~ repsep(keyParser,",") ~ "}" ^^ {
    case (_ ~ kvs ~ _) => Primitive.Dictionary(kvs.toMap)
  }
}
