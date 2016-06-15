import akka.actor.{Props, ActorSystem}

object Sample extends App {

  import akka.util.Timeout
  import scala.concurrent.duration._
  import akka.pattern.ask
  import akka.dispatch.ExecutionContexts._

  implicit val ec = global

//  override def main(args: Array[String]) = {
    val system = ActorSystem("System")

//    val filename = "/resources/storm.txt"

    val actor = system.actorOf(Props(new WordCounterActor()))
    implicit val timeout = Timeout(25 seconds)
    val future = actor ? StartprocessFileMsg()
    future.map { result =>
      println("Total number of words "+ result)
      system.terminate()

    }
//  }

}
