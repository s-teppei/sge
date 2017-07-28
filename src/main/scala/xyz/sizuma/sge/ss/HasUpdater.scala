package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasUpdater[A] {
  self : StatefulComponent[A] =>

  protected def updateState(oldState:A):A

  def doUpdate():Unit = {
    val oldState = state
    this.state = updateState(oldState)
  }

}
