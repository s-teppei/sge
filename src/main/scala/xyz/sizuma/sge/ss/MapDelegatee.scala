package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class MapDelegatee[Key,A] extends Delegatee[Key,A] {
  protected var map = Map.empty[Key,A]

  override def apply(key: Key): A = map(key)

  override def update(key: Key, a: A): Unit = map += (key -> a)
}
