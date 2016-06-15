import akka.actor.Actor


//actor
class Greeter extends Actor {

  override def receive = {
    case Greet(msg) => println(msg)
  }

}

//define message to be sent
case class Greet(message: String)