package xyz.sizuma.sge.data.parser

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Teppei Shiroyama under MIT License.
  */
object StdParsers extends RegexParsers{
  val sign:Parser[String] = "+" | "-" | ""
  val number:Parser[String] = "[0-9]+".r
  val signedInteger:Parser[String] = sign ~ number ^^ {
    case (s ~ n) => s + n
  }
  val signedDecimal:Parser[String] = signedInteger ~ "." ~ number ^^ {
    case (signed ~ dot ~ n) => signed + dot + n
  }

  val string:Parser[String] = "\"" ~ "[^\"]".r ~ "\"" ^^ {
    case (_ ~ literal ~ _) => literal
  }

  val boolean:Parser[Boolean] = ("true" | "false") ^^ { _ == "true" }


}
