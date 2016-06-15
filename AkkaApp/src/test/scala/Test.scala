import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.{FlatSpec, ShouldMatchers}
import org.scalatest.selenium.WebBrowser

/**
  * Created by martingwarada on 04/01/2016.
  */
class Test extends UnitSpec{

  "a number 2 " should "be equal to 4 - 2" in {
    val two = 2
    val another = 4 - 2

    two shouldEqual another
  }

}

class BlogSpec extends FlatSpec with ShouldMatchers with WebBrowser {

  implicit val webDriver: WebDriver = new HtmlUnitDriver

  val host = "http://localhost:9000/"

  "The blog app home page" should "have the correct title" in {
    go to (host + "index.html")
    pageTitle should be ("Awesome Blog")
  }

  "The man should be maertin " should "have the " in {
    println("martin ")
  }
}
