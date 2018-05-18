package com.combat.code

import java.sql.Timestamp

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.combat.code.models.{Booking, Slot, User}
import com.combat.code.repos.{BookingRepo, SlotRepo, StationRepo, UserRepo}
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
//  Await.result(SlotRepo.create,Duration.Inf)
//    Await.result(SlotRepo.insert(Slot(1,"00:00 AM - 00:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(2,"00:30 AM - 01:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(3,"01:00 AM - 01:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(4,"01:30 AM - 02:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(5,"02:00 AM - 00:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(6,"02:30 AM - 03:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(7,"03:00 AM - 03:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(8,"03:30 AM - 04:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(9,"04:00 AM - 04:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(10,"04:30 AM - 05:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(11,"05:00 AM - 05:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(12,"05:30 AM - 06:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(13,"06:00 AM - 06:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(14,"06:30 AM - 07:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(15,"07:00 AM - 07:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(16,"07:30 AM - 08:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(17,"08:00 AM - 08:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(18,"08:30 AM - 09:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(19,"09:00 AM - 09:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(20,"09:30 AM - 10:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(21,"10:00 AM - 10:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(22,"10:30 AM - 11:00 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(23,"11:00 AM - 11:30 AM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(24,"11:30 AM - 12:00 PM ")),Duration.Inf)
//
//  Await.result(SlotRepo.insert(Slot(25,"12:00 PM - 12:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(26,"12:30 PM - 01:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(27,"01:00 PM - 01:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(28,"01:30 PM - 02:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(29,"02:00 PM - 00:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(30,"02:30 PM - 03:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(31,"03:00 PM - 03:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(32,"03:30 PM - 04:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(33,"04:00 PM - 04:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(34,"04:30 PM - 05:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(35,"05:00 PM - 05:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(36,"05:30 PM - 06:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(37,"06:00 PM - 06:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(38,"06:30 PM - 07:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(39,"07:00 PM - 07:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(40,"07:30 PM - 08:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(41,"08:00 PM - 08:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(42,"08:30 PM - 09:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(43,"09:00 PM - 09:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(44,"09:30 PM - 10:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(45,"10:00 PM - 10:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(46,"10:30 PM - 11:00 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(47,"11:00 PM - 11:30 PM ")),Duration.Inf)
//  Await.result(SlotRepo.insert(Slot(48,"11:30 PM - 00:00 AM ")),Duration.Inf)


Await.result(UserRepo.create,Duration.Inf)
  Await.result(StationRepo.create,Duration.Inf)
  Await.result(BookingRepo.create,Duration.Inf)








}
