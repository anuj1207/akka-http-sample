package com.combat.code

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.combat.code.services.{FindService, HelloService}

import scala.concurrent.ExecutionContextExecutor

object Application extends App{

  implicit val system: ActorSystem = ActorSystem("system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val helloService = new HelloService
  val findService = new FindService
  
  val bindingFeat = Http().bindAndHandle(findService.route, "0.0.0.0", 8080)
  println("server is up")
}
