package com.combat.code.repos

import com.combat.code.connection.{DBconnection, PostgresConnection}
import com.combat.code.models.{Slot, Station}
import com.combat.code.tables.{SlotTable, StationTable}

trait SlotRepo extends SlotTable {
  this: DBconnection =>

  import driver.api._

  def create = db.run(slotQuery.schema.create)

  def insert(slot: Slot) = db.run(slotQuery returning slotQuery.map(_.slot_id) += slot)

  def delete(slot_id: Int) = db.run {
    slotQuery.filter(_.slot_id === slot_id).delete
  }

  def getAllSlots = db.run {

    slotQuery.to[List].result
  }


}

object SlotRepo extends SlotRepo with PostgresConnection