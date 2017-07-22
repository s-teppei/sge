package xyz.sizuma.sge.data

import org.scalatest.{FlatSpec, Matchers}
import xyz.sizuma.sge.data.parser.JSONStringParser
import xyz.sizuma.sge.data.Primitive._
import xyz.sizuma.sge.data.Conversions._
/**
  * Created by Teppei Shiroyama under MIT License.
  */
class DataTest extends FlatSpec with Matchers{

  def parse(string:String):Option[Primitive] = JSONStringParser.parse(string)
  "A Number Json Parser" should "parse correctly" in {
    assert( parse("1").contains(Number(1)))
    assert( parse("-1").contains(Number(-1)))
    assert( parse("+2").contains(Number(2)))
  }

  "A Real Json Parser" should "parse correctly" in {
    assert( parse("1.0").contains(Real(1.0)))
    assert( parse("-1.123").contains(Real(-1.123)))
    assert( parse("+2.0").contains(Real(2.0)))
  }

  "A String Json Parser" should "parse correctly" in {
    assert( parse("\"str\"").contains(Chars("str")))
    assert( parse("\"\"").contains(Chars("")))
  }

  "A Bool Json Parser" should "parse correctly" in {
    assert( parse("true").contains(Bool(true)))
    assert( parse("false").contains(Bool(false)))
  }

  "A Sequence Json Parser" should "parse correctly" in {
    assert( parse("[]").contains(Sequence(Seq.empty)))
    assert( parse("[1,2,3]").contains(Sequence(Seq(Number(1),Number(2),Number(3)))))
  }

  "A Dictionary Json Parser" should "parse correctly" in {
    assert( parse("{}").contains(Dictionary.empty()))
    assert( parse("{ a : 1}").contains(Dictionary(Map( ("a",Primitive.Number(1))))))
  }

  "A Null Json Parser" should "parse correctly" in {
    assert( parse(null).contains(Null))
  }

  "A Json Parser" should "parse complex json correctly" in {
    val json =
      """{
        | int : 1,
        | real : -1.2,
        | str : "string",
        | seq : [1,3,4],
        | map : {
        |    mapInt : 1
        | }
        |}""".stripMargin
    val parsedOpt = parse(json)
    assert(parsedOpt.isDefined)
    val parsed = parsedOpt.get.asInstanceOf[Dictionary]
    assert( parsed.get[Int]("int").contains(1) )
    assert( parsed.get[Double]("real").contains(-1.2) )
    assert( parsed.get[String]("str").contains("string") )
    assert( parsed.get[Seq[Int]]("seq").contains(Seq(1,3,4)) )
    assert( parsed.get[Map[String,Int]]("map").contains(Map(("mapInt",1))))
  }
}
