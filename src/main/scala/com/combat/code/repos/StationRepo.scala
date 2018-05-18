package com.combat.code.repos

import com.combat.code.connection.{DBconnection, PostgresConnection}
import com.combat.code.models.Station
import com.combat.code.tables.StationTable

trait StationRepo extends StationTable {
  this: DBconnection =>

  import driver.api._

  def create = db.run(stationQuery.schema.create)

  def insert(station: Station) = db.run(stationQuery returning stationQuery.map(_.station_id) += station)

  def delete(station_id: Int) = db.run {
    stationQuery.filter(_.station_id === station_id).delete
  }

  def getAllStations = db.run {

    stationQuery.to[List].result
  }


}

object StationRepo extends StationRepo with PostgresConnection