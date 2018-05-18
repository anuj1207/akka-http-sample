package com.combat.code.repos

import com.combat.code.connection.{DBconnection, PostgresConnection}
import com.combat.code.models.Booking
import com.combat.code.tables.BookingTable

import scala.concurrent.Future

trait BookingRepo extends BookingTable {
  this: DBconnection =>

  import driver.api._

  def create: Future[Unit] = db.run(bookingQuery.schema.create)

  def insert(booking: Booking): Future[Int] = db.run(bookingQuery returning bookingQuery.map(_.booking_id) += booking)

  def delete(booking_id: Int): Future[Int] = db.run (bookingQuery.filter(_.slot_id === booking_id).delete)

  def getAllBookings: Future[List[Booking]] = db.run (bookingQuery.to[List].result)

  def getBookingForStationsAndDate(stationId: Int, date: String): Future[Seq[Booking]] = db.run{
    bookingQuery.filter(booking => booking.date === date && booking.station_id === stationId).result
  }


}

object BookingRepo extends BookingRepo with PostgresConnection