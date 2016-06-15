import akka.actor.{Actor, Props}

object MusicController {

  sealed trait ControllerMsg

  case object play extends ControllerMsg

  case object stop extends ControllerMsg

}

class MusicController extends Actor {

  override def receive = {
    case play => println("Music started ........ ")
    case stop => println("Music stopped ........ ")
  }

}

