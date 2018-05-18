package com.combat.code.services

import java.time.LocalDate

import com.combat.code.models.{Booking, Slot, Station}
import com.combat.code.repos.{BookingRepo, StationRepo}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object DBHelper {

//  def availableSlotsAtStation(station_id: Int, date: LocalDate): List[Slot] = {
//    val bookingsForDate = findAllBookings().filter(booking => booking.date == date.toString && booking.station_id == station_id)
//
//  }

  def findAllBookings(): List[Booking] = {
    val bookings = Await.result(BookingRepo.getAllBookings, Duration.Inf)
    bookings
  }

  def getStationById(station_id: Int): List[Station] = {
    Await.result(StationRepo.getAllStations, Duration.Inf).filter(_.station_Id == station_id)
  }
}
