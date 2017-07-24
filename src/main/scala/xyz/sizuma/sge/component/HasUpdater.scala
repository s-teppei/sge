package xyz.sizuma.sge.component

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait HasUpdater[A] {
  self : Entity[A] =>

  def update(oldState:A):A

  def doUpdate():Unit = {
    val oldState = state
    val newState = update(oldState)
    this.state = newState
  }
}
