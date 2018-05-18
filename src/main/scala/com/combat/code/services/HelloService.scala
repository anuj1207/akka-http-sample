package com.combat.code.services

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}

class HelloService extends Directives{

  val getPath = "hello"

  def route: Route = path(getPath){
    parameterMap{ params =>
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>Hello${convert(params)}</h1>"))
    }
  }

  def convert(map: Map[String, String]) = {
    map.toList.mkString("or")
  }

}
