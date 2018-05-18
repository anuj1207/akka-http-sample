package com.combat.code.services

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}

class BookService extends Directives{

  private val emptyResponse = "<h1>Please Enter Some data to find me a Fuel Station</h1>"
  private val normalResponse = (str: Map[String, String]) => s"<h1>Please Do the processing on data ${findRoute(str)}</h1>"
  val getPath = "book"

  def route: Route = path(getPath) {
      (post & entity(as[String])) { json =>
        println(json)
        complete(StatusCodes.Accepted)
      }
    }

  def findRoute(map: Map[String, String]): String = {
    map.toList.map(pair => pair._1 + " = " + pair._2).mkString(" & ")
  }

}
