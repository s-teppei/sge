package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Delegatee[Key,A] {
  def apply(key: Key):A
  def update(key: Key,a: A):Unit
}
