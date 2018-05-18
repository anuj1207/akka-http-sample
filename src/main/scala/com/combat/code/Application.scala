package com.combat.code

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.combat.code.models.User
import com.combat.code.repos.{BookingRepo, UserRepo}
import com.combat.code.services.{BookService, FindService}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

object Application extends App{

  implicit val system: ActorSystem = ActorSystem("system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val findService = new FindService
  val bookService = new BookService

  private val route = findService.route ~ bookService.route
  val bindingFeat = Http().bindAndHandle(route, "localhost", 8080)
  println("server is up")
}
//object test extends App{
// val result=Await.result(BookingRepo.create,Duration.Inf)
//println(result)
//}
