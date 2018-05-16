package com.combat.code

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.combat.code.models.User
import com.combat.code.repos.UserRepo
import com.combat.code.services.HelloService

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

object Application extends App{

//  implicit val system: ActorSystem = ActorSystem("system")
//  implicit val materializer: ActorMaterializer = ActorMaterializer()
//  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
//
//  val helloService = new HelloService
//
//  val bindingFeat = Http().bindAndHandle(helloService.route, "localhost", 8080)
//  println("server is up")
  //Await.result(UserRepo.create,Duration.Inf)
  val result=Await.result(UserRepo.insert(User(1,989898,"first")),Duration.Inf)
  println(result)
}
