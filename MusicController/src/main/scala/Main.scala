
import MusicPlayer.startMusic
import akka.actor.{ActorSystem, Props}

object Main {

  def main(args: Array[String]): Unit = {




    val system = ActorSystem()

    val musicPlayerRef = system.actorOf(Props[MusicPlayer])

    musicPlayerRef ! startMusic

    //terminate the system
    system.terminate()

  }


}