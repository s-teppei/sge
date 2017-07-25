package xyz.sizuma.sge.util

import org.scalatest.{FlatSpec, Matchers}
import xyz.sizuma.sge.entity.attribute.HasSelfState

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class ObserveTest extends FlatSpec with Matchers{

  class ObservableImpl extends HasObservableState[Int] with ObservableDefaultImpl[Int] with HasSelfState[Int]{
    override def initialState: Int = 0

    def getState = this.state
    def setState(newState:Int):Unit = this.state = newState
  }

  "A Observer" should "receive 1 notify" in {
    val observable = new ObservableImpl
    var state = Option.empty[Int]
    observable.observe(target => {
      assert(state.isEmpty)
      target match {
        case oi : ObservableImpl => state = Some(oi.getState)
      }
    })

    observable.setState(1)
    Thread.sleep(500)
    assert(state.contains(1))
  }

  "A Observer" should "receive notifies" in {
    val observable = new ObservableImpl
    var count = 0
    observable.observe( _ => count += 1)
    for(i <- 0 until 100) observable.setState( i)

    assert(count == 100)
  }
}
