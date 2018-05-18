package com.combat.code.services

import java.time.LocalDate

import com.combat.code.models.{Booking, Slot}
import com.combat.code.repos.BookingRepo

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class DBservice {

  def findAllBookings():List[Booking]={
    val bookings=Await.result(BookingRepo.getAllBookings,Duration.Inf)
    bookings
  }

  def availableSlotsAtStation(station_id: Int, date: LocalDate):List[Slot] = {
    val bookingsForDate = findAllBookings.filter(booking => booking.date == date && booking.station_id == station_id)

  }
}
