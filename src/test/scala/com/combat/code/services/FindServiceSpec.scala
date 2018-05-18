package com.combat.code.services

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class FindServiceSpec extends WordSpec with ScalatestRouteTest with Matchers{
  val findService = new FindService

  "FindService" should {
    "find the route with empty input" in {
      Get("/find") ~> findService.route ~> check {
        responseAs[String] shouldEqual "<h1>Please Enter Some data to find me a Fuel Station</h1>"
      }
    }

    "try to find the route with some non empty input" in {
      Get("/find?from=delhi&to=goa") ~> findService.route ~> check {
        responseAs[String] shouldEqual "<h1>Please Do the processing on data from = delhi & to = goa</h1>"
      }
    }
  }
}
