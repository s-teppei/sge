package xyz.sizuma.sge.unit

import org.scalatest._
/**
  * Created by Teppei Shiroyama under MIT License.
  */
class PointTest extends FlatSpec with Matchers{
  "A Point" should "contain values correctly" in {
    val p = PointI(1,2,3)

    assert(p.x == 1)
    assert(p.y == 2)
    assert(p.z == 3)
  }

  it  should "implement equals correctly" in {
    val p1 = PointI(1,2,3)
    val p2 = PointI(1,2,3)
    val p3 = PointI(0,0,0)

    assert(p1 == p2)
    assert(p2 != p3)
  }
}
