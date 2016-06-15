import akka.actor.{Terminated, Props, ActorRef, ActorSystem}
import akka.testkit.{ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfterAll, Matchers, FlatSpecLike}

/**
  * Created by martingwarada on 31/12/2015.
  */
class FaultHandlingDocSpec(_system: ActorSystem) extends TestKit(_system) with
  ImplicitSender with FlatSpecLike with Matchers with BeforeAndAfterAll {

    def this() = this(ActorSystem("FaultHandlingDocSpec", ConfigFactory.parseString("""
      akka {
        loggers = ["akka.testkit.TestEventListener"]
        loglevel = "WARNING"
      }""")))


  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  val supervisor = system.actorOf(Props[Supervisor], "supervisor")

  supervisor ! Props[Child]

  val child = expectMsgType[ActorRef]


  "A supervisor" must "apply the chosen strategy for its child" in {
    child ! 42 // set state to 42
    child ! "get"
    expectMsg(42)
  }

  it must "apply chosen strategy testing the resume option" in {
    child ! new ArithmeticException
    child ! "get"
    expectMsg(42)
  }

//  it must "apply chosen strategy testing the restart option" in {
//    child ! new NullPointerException
//    child ! "get"
//    expectMsg(0)
//  }

//  it must "apply chosen strategy testing the stop " in {
//    watch(child)
//    child ! new IllegalArgumentException
//    expectMsgPF(){ case Terminated(`child`) =>  ()}
//  }

//  it must "apply chosen strategy: Escalating to the system actor" in {
//
//    supervisor ! Props[Child] //creates a new child
//    val child2 = expectMsgType[ActorRef]
//    watch(child2)
//    child2 ! "get" //just verfying if its still live
//    expectMsg(0)
//
//    child2 ! new Exception("CRASH")
//    expectMsgPF() {
//      case t @ Terminated(`child2`) if t.existenceConfirmed => ()
//    }
//
//  }

}
