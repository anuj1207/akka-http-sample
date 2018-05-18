package com.combat.code.tables

import java.sql.Timestamp

import com.combat.code.connection.DBconnection
import com.combat.code.models.User
import slick.lifted
import slick.lifted.ProvenShape

trait UserTable extends DBconnection {
  this:DBconnection=>
  import driver.api._

  class UserTable(tag: Tag) extends Table[User](tag, "user_table") {
    val user_id = column[Int]("user_id", O.PrimaryKey,O.AutoInc)
    val contact=column[Int]("contact_no")
    val user_name = column[String]("user_name")
    def * : ProvenShape[User] = (contact,user_name,user_id) <> (User.tupled, User.unapply _)
  }

  val userQuery = lifted.TableQuery[UserTable]
}