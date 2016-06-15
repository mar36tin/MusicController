import MusicController.play
import akka.actor.{Actor, Props}

object MusicPlayer {

  sealed trait PlayMsg

  case object stopMusic extends PlayMsg

  case object startMusic extends PlayMsg

}


class MusicPlayer extends Actor {
  override def receive = {
    case stopMusic => println("........ Stop music")
    case startMusic => context.actorOf(Props[MusicController]) ! play
  }
}