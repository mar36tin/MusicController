import akka.actor.Actor
import akka.dispatch.{BoundedMessageQueueSemantics, RequiresMessageQueue}

/**
  * Created by martingwarada on 03/01/2016.
  */
trait MyActor extends Actor {


}


trait MyBoundedActor extends MyActor with RequiresMessageQueue[BoundedMessageQueueSemantics]


class MyPersonalActor extends MyBoundedActor {
  def receive = ???
}