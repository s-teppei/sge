package xyz.sizuma.sge.util

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Observable[A] {
  def notifyObservers():Unit
  def observe(observer: Observer[A]):Unit
  def unObserve(observer: Observer[A]):Unit
}
