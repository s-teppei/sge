package xyz.sizuma.sge.ss.impl

import xyz.sizuma.sge.ss.StateManager

/**
  * Created by Teppei Shiroyama under MIT License.
  */
class LifeGameStateManager extends StateManager[(Int,Int),Boolean]{

  protected var states = Set.empty[(Int,Int)]
  protected var listeners = Map.empty[(Int,Int),Seq[() => Unit]]

  override def apply(key: (Int, Int)): Boolean = states(key)

  override def update(key: (Int, Int), a: Boolean): Unit = {
    if(a) states += key else states -= key
    for ( ls <- listeners.get(key) ; listener <- ls ) listener.apply()
  }

  override def listenUpdate(key: (Int,Int), f: () => Unit): StateManager.ListenEvidence[(Int,Int),Boolean] = {
    val newSeq = listeners.getOrElse(key,Seq.empty) :+ f
    listeners += (key -> newSeq)
    StateManager.ListenEvidence(this,key,f)
  }

  override def removeListener(key: (Int,Int),f: () => Unit): Unit = {
    val newSeq = listeners.getOrElse(key,Seq.empty).filterNot(_ == f)
    listeners += (key -> newSeq)
  }

  def around(p:(Int,Int)):Set[(Int,Int)] = p match {
    case (x, y) => Set(
      (x,y - 1) ,
      (x+1,y-1) ,
      (x+1,y) ,
      (x+1,y+1) ,
      (x,y+1) ,
      (x-1,y+1) ,
      (x-1,y) ,
      (x-1,y-1) ,
    )
  }

  def shouldUpdates:Set[(Int,Int)] = states.flatMap(around)

  def updateAll():Unit = {
    val should = shouldUpdates

    val (lives,deads) = should.partition(states.contains)

    val newState = lives.filter(p => {
      val size = around(p).count(states.contains)
      size == 2 || size == 3
    } ) ++ deads.filter(p => around(p).count(states.contains) == 3)
    states = newState

    for( ls <- listeners.values ; listener <- ls) listener()
  }
}
