import Dependencies._

name := "akka-http-sample"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  akkaHTTP,
  akkaActor,
  akkaStream,
  akkaTestKit,
  akkaHTTPTestKit,
  scalaTest,
  slick,
  slickHikariCp,
  postgresSQL,
  gson
)