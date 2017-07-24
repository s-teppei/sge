package xyz.sizuma.sge.util

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Observable[A] {
  def notifyToObservers(self:Observable[A],state:A):Unit
  def observe(observer: Observer[A]):Unit
  def unObserve(observer: Observer[A]):Unit
}
