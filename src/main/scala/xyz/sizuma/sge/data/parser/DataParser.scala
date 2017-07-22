package xyz.sizuma.sge.data.parser

import xyz.sizuma.sge.data.Primitive

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait DataParser[From] {
  def parse(from: From): Option[Primitive]
}

object DataParser {

  abstract class DataParserAdaptor extends RegexParsers with DataParser[String] {
    def parseNumber: Parser[Primitive.Number]

    def parseReal: Parser[Primitive.Real]

    def parseString: Parser[Primitive.Chars]

    def parseBool: Parser[Primitive.Bool]

    def parseSequence: Parser[Primitive.Sequence]

    def parseDictionary: Parser[Primitive.Dictionary]

    def parseNull: Parser[Primitive.Null]

    override def parse(from: String): Option[Primitive] = if (from == null) Option(Primitive.Null) else parseAll(parsers, from) match {
      case Success(primitive, _) => Some(primitive)
      case _ => None
    }

    def parsers: Parser[Primitive] = parseNull | parseBool | parseReal | parseNumber | parseString | parseDictionary | parseSequence
  }

}