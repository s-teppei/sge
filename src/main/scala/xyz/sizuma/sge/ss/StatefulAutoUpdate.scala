package xyz.sizuma.sge.ss

import javax.swing.JComponent

/**
  * Created by Teppei Shiroyama under MIT License.
  */
trait StatefulAutoUpdate[A] extends StatefulComponent[A] with HasSelfState[A] with HasUpdater[A] with AutoUpdater{
  self : JComponent =>
}
