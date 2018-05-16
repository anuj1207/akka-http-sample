package com.combat.code.services

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class HelloServiceSpec extends WordSpec with ScalatestRouteTest with Matchers{
  val helloService = new HelloService

  "HelloServiceSpec" should {

    val smallRoute =
      get {
        pathSingleSlash {
          complete {
            "Captain on the bridge!"
          }
        } ~
          path("ping") {
            complete("PONG!")
          }
      }

    "test simple route" in {
      Get() ~> smallRoute ~> check {
        responseAs[String] shouldEqual "Captain on the bridge!"
      }
    }

    "test pong route" in {
      Get("/ping") ~> smallRoute ~> check {
        responseAs[String] shouldEqual "Captain on the bridge!"
      }
    }

    "test hello route" in {
      Get("/hello") ~> helloService.route ~> check {
        responseAs[String] shouldEqual "<h1>Hello</h1>"
      }
    }


  }
}