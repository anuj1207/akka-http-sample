package com.combat.code.tables

import com.combat.code.connection.DBconnection
import com.combat.code.models.{Slot, Station}
import slick.lifted


trait SlotTable extends DBconnection {
  this: DBconnection =>

  import driver.api._

  val slotQuery = lifted.TableQuery[SlotTable]

  class SlotTable(tag: Tag) extends Table[Slot](tag, "slot") {
    val slot_id = column[Int]("slot_id", O.PrimaryKey)
    val time_slot = column[String]("time_slot")
    def * = (slot_id,time_slot) <> (Slot.tupled, Slot.unapply)
  }
}
