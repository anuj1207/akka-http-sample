package com.combat.code.tables

import com.combat.code.connection.DBconnection
import com.combat.code.models.{Booking, Station}
import slick.lifted

trait BookingTable extends DBconnection {
  this: DBconnection =>

  import driver.api._

  val bookingQuery = TableQuery[BookingTable]

  class BookingTable(tag: Tag) extends Table[Booking](tag, "booking") {
    val booking_id = column[Int]("booking_id", O.PrimaryKey, O.AutoInc)
    val station_id = column[Int]("station_id")
    val user_id = column[Int]("user_id")
    val slot_id= column[Int]("slot_id")
    val date = column[String]("date")


    def * = (booking_id, station_id, user_id, date,station_id) <> (Booking.tupled, Booking.unapply)
  }
}
