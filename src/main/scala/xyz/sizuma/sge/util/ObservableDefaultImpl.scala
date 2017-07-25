package xyz.sizuma.sge.util

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait ObservableDefaultImpl[A] {
  self : Observable[A] =>
  private[this] var observers = Seq.empty[Observer[A]]

  override def notifyObservers(): Unit = observers.foreach(_.onUpdate(this))

  override def observe(observer: Observer[A]): Unit = observers :+= observer

  override def unObserve(observer: Observer[A]): Unit = observers = observers filterNot(_ == observer)
}
