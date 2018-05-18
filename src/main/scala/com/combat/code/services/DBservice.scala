package com.combat.code.services

import java.time.LocalDate

import com.combat.code.models.{Booking, Slot, Station}
import com.combat.code.repos.{BookingRepo, StationRepo}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class DBservice {

  def availableSlotsAtStation(station_id: Int, date: LocalDate): List[Slot] = {
    val bookingsForDate = findAllBookings().filter(booking => booking.date == date.toString && booking.station_id == station_id)

  }

  def findAllBookings(): List[Booking] = {
    val bookings = Await.result(BookingRepo.getAllBookings, Duration.Inf)
    bookings
  }

  def getStationById(station_id: Int): Option[Station] = {
    val station = Await.result(StationRepo.getAllStations, Duration.Inf).filter(_.station_Id == station_id)
    if (station != Nil)
      None
    else
      station.headOption
  }

  getBookingByStationAndDate()
}
