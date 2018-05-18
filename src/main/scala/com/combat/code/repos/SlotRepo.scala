package com.combat.code.repos

import com.combat.code.connection.{DBconnection, PostgresConnection}
import com.combat.code.models.Slot
import com.combat.code.tables.SlotTable

import scala.concurrent.Future

trait SlotRepo extends SlotTable {
  this: DBconnection =>

  import driver.api._

  def create: Future[Unit] = db.run(slotQuery.schema.create)

  def insert(slot: Slot): Future[Int] = db.run(slotQuery returning slotQuery.map(_.slot_id) += slot)

  def delete(slot_id: Int): Future[Int] = db.run {
    slotQuery.filter(_.slot_id === slot_id).delete
  }

  def getAllSlots: Future[List[Slot]] = db.run {

    slotQuery.to[List].result
  }


}

object SlotRepo extends SlotRepo with PostgresConnection