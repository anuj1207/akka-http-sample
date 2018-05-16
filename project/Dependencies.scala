import sbt._

object Dependencies extends AutoPlugin {

  val akkaHTTPVersion = "10.1.1"
  val akkaVersion = "2.5.12"
  val slickVersion = "3.2.3"
  val postgresVersion = "9.4.1212"

  val akkaHTTP = "com.typesafe.akka" %% "akka-http" % akkaHTTPVersion
  val akkaHTTPTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHTTPVersion % Test

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test

  val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion

  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test
  val slick = "com.typesafe.slick" %% "slick" % slickVersion
  val slickHikariCp = "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
  val postgresSQL = "org.postgresql" % "postgresql" % postgresVersion
}
