import java.util.concurrent.TimeUnit

import akka.actor.SupervisorStrategy.{Restart, Stop, Escalate, Resume}
import akka.actor.{Props, OneForOneStrategy, Actor}

class Supervisor extends Actor {

  var router = {
    val routees = Vector.fill(5)
    {

    }
  }

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = (1 , TimeUnit.MINUTES)) {
      case _:ArithmeticException => Resume
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  def receive = {
    case p: Props => sender() ! context.actorOf(p)
  }

}
