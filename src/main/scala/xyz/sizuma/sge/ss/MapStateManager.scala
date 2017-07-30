package xyz.sizuma.sge.ss

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class MapStateManager[Key,A] extends StateManager[Key,A]{
  protected var states = Map.empty[Key,A]
  protected var listeners = Map.empty[Key,Seq[() => Unit]]

  override def apply(key: Key): A = states(key)

  override def update(key: Key, a: A): Unit = {
    states += (key -> a)
    for( ls <- listeners.get(key) ; listener <- ls ) listener()
  }

  override def listenUpdate(key: Key, f: () => Unit): StateManager.ListenEvidence[Key,A] = {
    val newSeq = listeners.getOrElse(key,Seq.empty) :+ f
    listeners += (key -> newSeq)
    StateManager.ListenEvidence(this,key,f)
  }

  override def removeListener(key: Key,f: () => Unit): Unit = {
    val newSeq = listeners.getOrElse(key,Seq.empty).filterNot(_ == f)
    listeners += (key -> newSeq)
  }
}
