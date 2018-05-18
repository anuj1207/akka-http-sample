package com.combat.code.tables

import com.combat.code.connection.DBconnection
import com.combat.code.models.Station
import slick.lifted

trait StationTable extends DBconnection {
  this: DBconnection =>

  import driver.api._

  val stationQuery = lifted.TableQuery[StationTable]

  class StationTable(tag: Tag) extends Table[Station](tag, "station") {
    val station_id = column[Int]("station_id", O.PrimaryKey, O.AutoInc)
    val station_address = column[String]("station_address")
    val total_points = column[Int]("total_points")
    val x_cordinate = column[Int]("x_cordinate")
    val y_cordinate = column[Int]("y_cordinate")


    def * = (station_id, station_address, total_points, x_cordinate, y_cordinate) <> (Station.tupled, Station.unapply)
  }
}