package xyz.sizuma.sge.component

import java.util.Observable

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait Entity[A] extends HasState[A] with Component {
}
