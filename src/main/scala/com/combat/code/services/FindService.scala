package com.combat.code.services

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}

class FindService extends Directives{

  private val emptyResponse = "<h1>Please Enter Some data to find me a Fuel Station</h1>"
  private val normalResponse = (str: Map[String, String]) => s"<h1>Please Do the processing on data ${findRoute(str)}</h1>"
  val getPath = "find"

  def route: Route = path(getPath){
    parameterMap{ params =>
      println(params)
      if(params.isEmpty){
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, emptyResponse))
      } else{
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, normalResponse(params)))
      }
    }
  }

  def findRoute(map: Map[String, String]): String = {
    map.toList.map(pair => pair._1 + " = " + pair._2).mkString(" & ")
  }

}
