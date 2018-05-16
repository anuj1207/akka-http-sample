package com.combat.code

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.combat.code.services.HelloService

import scala.concurrent.ExecutionContextExecutor

object Application extends App{

  implicit val system: ActorSystem = ActorSystem("system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val helloService = new HelloService
  
  val bindingFeat = Http().bindAndHandle(helloService.route, "localhost", 8080)
  println("server is up")
}