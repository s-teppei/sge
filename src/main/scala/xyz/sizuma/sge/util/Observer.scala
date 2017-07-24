package xyz.sizuma.sge.util

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Observer[A] {
  def onUpdate(target:Observable[A],state:A):Unit
}
