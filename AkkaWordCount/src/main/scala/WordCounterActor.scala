import akka.actor.{Props, ActorRef, Actor}

case class StartprocessFileMsg()

class WordCounterActor() extends Actor {

  private var running = false
  private var totalLines = 0
  private var linesProcessed = 0
  private var result = 0
  private var fileSender: Option[ActorRef] = None

  def receive = {
    case StartprocessFileMsg() => {
      if(running){
        println("Warning duplicate start message received")
      }else{
        running = true
        fileSender = Some(sender)
        import scala.io.Source._
        fromFile("/resources/storm.txt").getLines().foreach{ line =>
          context.actorOf(Props[StringCounterActor]) ! ProcessStringMsg(line)
          totalLines += 1
        }
      }
    }
    case StringProcessedMsg(words) => {
      result += words
      linesProcessed += 1
      if(linesProcessed == totalLines){
        fileSender.map(_ ! result)
      }
    }
    case _ => println("message not recognized!")
  }

}
