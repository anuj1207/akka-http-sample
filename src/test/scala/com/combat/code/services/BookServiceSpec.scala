package com.combat.code.services

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class BookServiceSpec extends WordSpec with ScalatestRouteTest with Matchers{
  val bookService = new BookService

  "BookService" should {
    "return a response when slot is booked" in {
      val json =
        """
          |{
          |"recoverId": "12345678",
          |"newPassword": "123456111"
          |}
        """.stripMargin

      Post("/validate", json) ~> bookService.route ~> check {
        status shouldEqual StatusCodes.Accepted
      }
    }
  }
}