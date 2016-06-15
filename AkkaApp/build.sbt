name := "AkkaApp"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor"   % "2.4-SNAPSHOT",
    "org.scalatest"     %% "scalatest"    % "2.2.4" % "test",
    "com.typesafe.akka" %% "akka-testkit" % "2.4.1",
    "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test"
  )
}