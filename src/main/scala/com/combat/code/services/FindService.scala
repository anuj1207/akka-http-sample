package com.combat.code.services

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}
import com.combat.code.models.Station
import com.combat.code.repos.{BookingRepo, SlotRepo}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class FindService extends Directives{

  private val emptyResponse = "<h1>Please Enter Some data to find me a Fuel Station</h1>"
  private val normalResponse = (str: Map[String, String]) => s"<h1>Please Do the processing on data ${findRoute(str)}</h1>"
  val getPath = "find"

  def route: Route = path(getPath){
    parameterMap{ params =>
      if(params.isEmpty || (!params.keySet.contains("from") && !params.keySet.contains("to") && !params.keySet.contains("date"))){
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, emptyResponse))
      } else{
        val map = (params.get("from"), params.get("to"), params.get("date")) match {
          case (Some(source), Some(destination), Some(date)) =>

            val stationList = List(1, 2, 3).flatMap(DBHelper.getStationById)
            val slots = Await.result(SlotRepo.getAllSlots, Duration.Inf)
            val bookingList = Await.result(Future.sequence(stationList.map(station => BookingRepo.getBookingForStationsAndDate(station.station_Id, date))), Duration.Inf).flatten
            println(EnRouteHelper.getSlotMap(stationList, slots, bookingList))
//            EnRouteHelper.findStationsBetweenCities(source,destination, date)
        }
//        println(Await.result(map, 3.seconds))
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, normalResponse(params)))
      }
    }
  }

  def findRoute(map: Map[String, String]): String = {
    map.toList.map(pair => pair._1 + " = " + pair._2).mkString(" & ")
  }

}
