import akka.actor.{ActorSystem, Props}

/**
  * Created by martingwarada on 15/06/2016.
  */
object Main extends App {


  //define actor system
  val system = ActorSystem("greeter")

  //define the actor ref
  val actorRef = system.actorOf(Props[Greeter], "greeter")

  actorRef ! Greet("Hello ruvimbo")

}
