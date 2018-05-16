package com.combat.code.tables

import com.combat.code.connection.DBconnection
import com.combat.code.models.User
import slick.lifted

trait UserTable extends DBconnection {
  this:DBconnection=>
  import driver.api._

  class UserTable(tag: Tag) extends Table[User](tag, "user") {
    val user_id = column[Int]("user_id", O.PrimaryKey,O.AutoInc)
    val contact=column[Int]("contact")
    val user_name = column[String]("user_name")

    def * = (user_id,contact,user_name) <> (User.tupled, User.unapply)
  }

  val userQuery = lifted.TableQuery[UserTable]
}